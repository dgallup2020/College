package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    protected Connection connection = null;
    private String strCon;
     public static int openConnections = 0;
    
    public void setConnectionString(String strCon) {
        this.strCon = strCon;
    }
    public Connection getConnection() {
            return connection;
    }
    public boolean setConnection(String conStr, String userName, String password) {
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
                        connection = DriverManager.getConnection(conStr, userName, password);
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
    public void closeConnection() throws SQLException {
        if ((connection != null) && (!connection.isClosed())) {
            connection.close();
            connection = null;
        }
    }
//    public static void manageConnections(ConnectionHelper connHelper) {
//        openConnections++;    
//        if (ConnectionHelper.openConnections >= 4) {
//            try {
//                connHelper.closeConnection();
//                System.out.println("CLOSED A CONNECTION --- Open Connections: " + openConnections);
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            } finally {
//                ConnectionHelper.openConnections--;
//            }
//        }
//    }
}
