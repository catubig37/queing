/**
 * @author vcatubig
 * Jul 29, 2019
 * Meralco Real Time Payment
 * Capgemini
 */
package ver.badminton.logging;

import ver.badminton.helper.Config;

public class ConsoleLog extends Log{
	
	private ConsoleLog() {}
	
	private static ConsoleLog consoleLog;
	
	public static ConsoleLog getInstance() {
		consoleLog = new ConsoleLog();
		return consoleLog;
	}
	@Override
	public void _log(String message) {

		if (isShouldLog(super.getLevel())) {
			if(super.getLevel() != LogLevel.DETAIL)
				sysout("LOG LEVEL: " + super.getLevel().getLevel());
			if (super.getTransactionNumber() != null && !"".equals(super.getTransactionNumber()))
				sysout("TRANSACTION NUMBER: " + super.getTransactionNumber());
			if (super.getAccountNumber() != null && !"".equals(super.getAccountNumber()))
				sysout("ACCOUNT NUMBER: " + super.getAccountNumber());
			if (super.getClassName() != null && !"".equals(super.getClassName()))
				sysout("CLASS NAME: " + super.getClassName());
			if (super.getMethodName() != null && !"".equals(super.getMethodName()))
				sysout("METHOD NAME: " + super.getMethodName());
			if (super.getTitle() != null && !"".equals(super.getTitle()))
				sysout("TITLE: " + super.getTitle());
			if (message != null && !"".equals(message))
				sysout("MESSAGE: " + message);

			super.reset();
		}
	}
	/**
	 * Check CONSOLE_LOG_LEVEL value in Config Vars then validate if level
	 * will qualify for logging.
	 */
	@Override
	public boolean isShouldLog(LogLevel level){
		return Config.CONSOLE_LOG_LEVEL  != LogLevel.OFF.getValue()  && level.getValue() <= Config.CONSOLE_LOG_LEVEL;
	}
	
	private void sysout(String message) {
		System.out.println(message);
	}
}
