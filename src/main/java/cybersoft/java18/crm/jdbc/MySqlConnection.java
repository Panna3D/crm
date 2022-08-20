package cybersoft.java18.crm.jdbc;

import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.model.StatusModel;
import cybersoft.java18.crm.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3308/crm_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error while connecting to database.");
        }
    }

    public static List<RoleModel> getRoleList() throws SQLException {
        // Get connection
        Connection con = null;
        List<RoleModel> roleModelList = new ArrayList<>();;
        try {
            con = MySqlConnection.getConnection();
            String query = "Select * from roles";
            PreparedStatement statement = con.prepareStatement(query);
            //Retrieving the records
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                RoleModel roleModel = new RoleModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")

                );
                roleModelList.add(roleModel);
            }
            return roleModelList;
        } catch (Exception e) {
//            throw new e.printStackTrace();
        } finally {
            con.close();
        }
        ;
        //Creating the Statement
        return roleModelList;
    }

    public static List<StatusModel> getStatusList() throws SQLException {
        // Get connection
        Connection con = null;
        List<StatusModel> statusModelList = new ArrayList<>();;
        try {
            con = MySqlConnection.getConnection();
            String query = "Select * from status";
            PreparedStatement statement = con.prepareStatement(query);
            //Retrieving the records
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                StatusModel statusModel = new StatusModel(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                statusModelList.add(statusModel);
            }
            return statusModelList;
        } catch (Exception e) {
//            throw new e.printStackTrace();
        } finally {
            con.close();
        }
        ;
        //Creating the Statement
        return statusModelList;
    }

    public static List<UserModel> getUserList() throws SQLException {
        // Get connection
        Connection con = null;
        List<UserModel> userModelList = new ArrayList<>();;
        try {
            con = MySqlConnection.getConnection();
            String query = "Select * from users";
            PreparedStatement statement = con.prepareStatement(query);
            //Retrieving the records
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                UserModel userModel = new UserModel(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("avatar"),
                        rs.getInt("role_id")
                );
                userModelList.add(userModel);
            }
            return userModelList;
        } catch (Exception e) {
//            throw new e.printStackTrace();
        } finally {
            con.close();
        }
        ;
        //Creating the Statement
        return userModelList;
    }
}



