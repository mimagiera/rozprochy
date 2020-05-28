package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static database.DatabaseConnection.*;
import static java.lang.String.format;

public class DatabaseQueries {
    Connection connection;

    public DatabaseQueries(Connection connection) {
        this.connection = connection;
    }

    public Optional<Request> incrementRequest(String productName) {
        return getRequest(productName)
                .map(this::incrementCounter)
                .orElse(insertRequestWithCounter(productName));
    }

    private Optional<Request> getRequest(String productName) {
        try {
            PreparedStatement prepStmt = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " where product_name = ?");
            prepStmt.setString(1, productName);
            ResultSet result = prepStmt.executeQuery();
            int counter;
            while (result.next()) {
                counter = result.getInt(COLUMN_COUNTER);
                return Optional.of(new Request(productName, counter));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Request> incrementCounter(Request request) {
        try {
            request.incrementCounter();
            int newCounter = request.getCounter();
            String sql = createUpdateCounterQuery();
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, newCounter);
            prepStmt.setString(2, request.getProductName());
            prepStmt.executeUpdate();

            return Optional.of(request);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private String createUpdateCounterQuery() {
        return format("UPDATE %s SET %s = ? WHERE %s = ?",
                TABLE_NAME, COLUMN_COUNTER, COLUMN_PRODUCT_NAME);
    }

    private Optional<Request> insertRequestWithCounter(String productName) {
        try {
            PreparedStatement prepStmt = connection.prepareStatement(
                    "insert into " + TABLE_NAME + " values (NULL, ?, ?);");
            prepStmt.setString(1, productName);
            prepStmt.setInt(2, 1);
            prepStmt.execute();

            return Optional.of(new Request(productName, 1));
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
