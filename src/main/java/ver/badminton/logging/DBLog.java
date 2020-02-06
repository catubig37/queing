/**
 * @author vcatubig
 */
package ver.badminton.logging;

import java.sql.SQLException;

import org.json.JSONException;

import ver.badminton.helper.Config;
import ver.badminton.queing.helper.Util;
import ver.postgres.PG;


public class DBLog extends Log{


	private DBLog() {
		
	}
	private static DBLog paymentLog;
	
	public static DBLog getInstance() {
		paymentLog = new DBLog();
		return paymentLog;
	}

	@Override
	public void _log(String message) {
		if (isShouldLog(super.getLevel())) {
			try {
				PG.Query(String.format(
						"INSERT INTO %s.\"Payment_Log\" (transaction_number, account_number, class_name, method_name, level, title, message, json_value)"
								+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?) RETURNING *;",
						Config.TARGET_RTP_SCHEMA),
						new Object[] { super.getTransactionNumber(), super.getAccountNumber(), super.getClassName(),
								super.getMethodName(), super.getLevel().getLevel(), super.getTitle(), message,
								super.getJsonStr() });
			} catch (JSONException | SQLException | NullPointerException e) {
				Util.log(super.getTransactionNumber(), super.getAccountNumber(), "DBLog", "_log", LogLevel.ERROR,
						"DBLog", e.toString(), Util.objToJson(this));
			}
		}
		reset();
	}

	/**
	 * Check DB_LOG_LEVEL value in Config Vars then validate if level
	 * will qualify for logging.
	 */
	@Override
	public boolean isShouldLog(LogLevel level){
		return Config.DB_LOG_LEVEL  != LogLevel.OFF.getValue() && level.getValue() <= Config.DB_LOG_LEVEL;
	}
	
}
