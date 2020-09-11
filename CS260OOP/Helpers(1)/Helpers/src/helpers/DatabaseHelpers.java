package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelpers {
	
	private static final String CONNECTION_STRING = "jdbc:mysql://devry.edupe.net:4300/CIS355A_1047";

	protected static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	public static boolean setConnection(String userName, String password) {
		boolean valid = false;
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				valid = true;
			}
			catch (ClassNotFoundException e) {
				String prompt = "\nDatabase Helpers setConnection: cannot find database drivers\n";
				OutputHelpers.showConsole(prompt);
				valid = false;
			}
			if(valid)
			{
				try {
					connection = DriverManager.getConnection(CONNECTION_STRING, userName, password);
					String prompt = "\nDatabase Helpers, Connected to OmnyBus\n";
					OutputHelpers.showConsole(prompt);
				}
				catch (SQLException e) {
					String prompt = "\nDatabase Helpers setConnection: Cannot connect to database server\n";
					OutputHelpers.showConsole(prompt);
					valid = false;
				}
			}
			
		}
		return valid;
	}
	public static void closeConnection() throws SQLException {
		if ((connection != null) && (!connection.isClosed())) {
			connection.close();
			connection = null;
		}
	}

}
