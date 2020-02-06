package ver.postgres;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PG implements AutoCloseable {
	
	

	
	private static BasicDataSource PG_POOL = null;
	public static String TARGET_SCHEMA;
	
	static{
		
		if(System.getenv("PG_TARGET_SCHEMA") == null) {
			TARGET_SCHEMA = "bad";
		}
		else {
			TARGET_SCHEMA = System.getenv("PG_TARGET_SCHEMA");
		}

		init_pg_pool();
	}

	private static void init_pg_pool(){

		try {
			URI dbUri = new URI(coalesce(
					System.getenv("HEROKU_POSTGRESQL_GOLD_URL")
					, System.getenv("DATABASE_URL")
			));
			String jdbc = String.format("jdbc:postgresql://%s?user=%s&password=%s&sslmode=require",
					dbUri.getHost() + dbUri.getPath(), dbUri.getUserInfo().split(":")[0],
					dbUri.getUserInfo().split(":")[1]);
			PG_POOL = new BasicDataSource();

			PG_POOL.setDriverClassName("org.postgresql.Driver");
			PG_POOL.setUrl(jdbc);
			PG_POOL.setInitialSize(1);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	private Connection conn;
	private Statement stmt;

	public PG() throws SQLException{
		conn = PG_POOL.getConnection();
	}
	
	
	public JSONArray query(String sql, Object[] args) throws JSONException, SQLException{
		
		
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; args != null && i < args.length; i++){
			stmt.setObject(i + 1, args[i]);
		}
		return to_json(stmt.executeQuery());
	}
	
	public boolean execute(String sql, Object[] args) throws JSONException, SQLException{
		
		
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; args != null && i < args.length; i++){
			stmt.setObject(i + 1, args[i]);
		}
		
		return stmt.execute();
	}
	
	public boolean run(String sql, Object[] args) throws SQLException{
		
		
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; args != null && i < args.length; i++){
			stmt.setObject(i + 1, args[i]);
		}
		return stmt.execute();
	}

	public static JSONArray Query(String sql, Object[] args) throws JSONException, SQLException{
		PG client = null;
		
		try {
			client = new PG();
			return client.query(sql, args);
		}
		catch (JSONException | SQLException e) {
			throw e;
		}
		finally{
			close(client);
		}
	} 
	
	public static Boolean Execute(String sql, Object[] args) {
		PG client = null;
		
		try {
			client = new PG();
			return client.execute(sql, args);
		}
		catch (JSONException | SQLException ex) {
			//PG.error(PG.class, "Execute", sql, ex);
		}
		finally{
			close(client);
		}
		
		return false;
	} 
	
	public static boolean Run(String sql, Object[] args) {
		PG client = null;
		
		try {
			client = new PG();
			return client.run(sql, args);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(client);
		}
		
		return false;
	} 
	
	private static JSONArray to_json(ResultSet rs) throws JSONException, SQLException{
		int total_cols = rs.getMetaData().getColumnCount();
        JSONArray result = new JSONArray();
        
        while (rs.next()) {
            
	        	JSONObject obj = new JSONObject();

	        	
	        for (int i = 0; i < total_cols; i++) {
	            	
	            	Object data = rs.getObject(i + 1) != null ? rs.getObject(i + 1) : JSONObject.NULL;
	            	String column_name = rs.getMetaData().getColumnLabel(i + 1);

	            	if(rs.getMetaData().getColumnTypeName(i + 1).contains("json")){
	            		obj.put(column_name, data == JSONObject.NULL ? data :
            				rs.getObject(i + 1).toString().startsWith("{")
		        				? new JSONObject(data.toString())
									: new JSONArray(data.toString())
        				);
	            	}
	            	else{
	                	obj.put(rs.getMetaData().getColumnLabel(i + 1), data);
	            	}
            }
            
            result.put(obj);
        }
        return result;
	}

	public void close(){
		close(stmt);
		close(conn);
	}
	public static String coalesce(String a, String b) {
		if (a != null)
			return a;
		else
			return b;
	}

	public static void close(AutoCloseable e) {
		try {
			e.close();
		} catch (Exception ex) {
		}
	}
}
