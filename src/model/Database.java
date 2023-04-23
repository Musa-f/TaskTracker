package model;
import java.sql.*;
public class Database {
    Connection conn = null;

    public Database(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:task_project.db");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void createTables(){
        try{
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS tasks (id_task INTEGER PRIMARY KEY, name_task VARCHAR(100), description_task TEXT, date_start_task DATE, date_end_task DATE)";
            stmt.execute(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateTables(){

    }

    public void deleteTables(){
        
    }
}
