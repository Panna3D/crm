package cybersoft.java18.crm.repository;

import cybersoft.java18.crm.jdbc.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AbstractRepository <T> {
    public List<T> executeQuery(JdbcExecute<List<T>> processor){
        try(Connection connection = MySqlConnection.getConnection()){
            return processor.processQuery(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error connect database!");
        }
    }
}
