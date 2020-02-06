package ver.badminton.queing.service.matching.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	private Util() {
		throw new IllegalStateException("Util class");
	}

	public static String objToJson(Object object) {
		ObjectMapper obj = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = obj.writeValueAsString(object);
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonString;
	}
}
