/**
 * @author vcatubig
 * Jul 30, 2019
 * Meralco Real Time Payment
 * Capgemini
 */
package ver.badminton.logging;

public enum LogLevel {
	OFF(0, "OFF"), FATAL(1, "FATAL"), ERROR(2, "ERROR"), WARN(3, "WARN"), INFO(4, "INFO"), 
	DEBUG(5, "DEBUG"), TRACE(6, "TRACE"), DETAIL(7, "DETAIL");
	LogLevel(int value, String level){
			this.value = value;
			this.level = level;
		}

	private final int value;
	private final String level;

	public int getValue() {
		return value;
	}
	public String getLevel() {
		return level;
	}
}
