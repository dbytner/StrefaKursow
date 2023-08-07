package pl.bytner.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {

        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();


    }
}
