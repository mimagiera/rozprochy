package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class DatabaseConnection {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:requests.db";

    static final String COLUMN_PRODUCT_NAME = "product_name";
    static final String COLUMN_COUNTER = "counter";
    static final String TABLE_NAME = "requests";

    private Connection connection;
    private Statement statement;

    public DatabaseConnection() {
        try {
            Class.forName(DatabaseConnection.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC found for class DbConnector");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Error creating connection");
            e.printStackTrace();
        }
        createTable();
    }

    public Connection getConnection() {
        return connection;
    }

    private void createTable() {
        String createRequestsTable = format("CREATE TABLE IF NOT EXISTS %s" +
                        " (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s int)",
                TABLE_NAME, COLUMN_PRODUCT_NAME, COLUMN_COUNTER);
        try {
            statement.execute(createRequestsTable);
        } catch (SQLException e) {
            System.err.println("Error creating table");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
