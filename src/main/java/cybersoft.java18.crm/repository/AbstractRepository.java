package repository;

//import com.mysql.cj.MysqlConnection;
import cybersoft.java18.crm.jdbc.MysqlConnection;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractRepository<T> {

    //    Get All -> List Data
    protected List<T> excuteQuery(cybersoft.java18.crm.repository.JdbcExcute<List<T>> process){
        try{
            Connection connection = MysqlConnection.getConnection();
            //Lamda Function
            return process.processor(connection);
        }catch (Exception e){
            throw new RuntimeException("Error connect database");
//            System.out.println("Error connect database " + e.getMessage());
        }
    }

    protected Integer excuteSaveAndUpdate(cybersoft.java18.crm.repository.JdbcExcute<Integer> process){
        try{
            Connection connection = MysqlConnection.getConnection();
            //Lamda Function
            return process.processor(connection);
        }catch (Exception e){
            throw new RuntimeException("Error connect database");
//            System.out.println("Error connect database " + e.getMessage());
        }
    }

}