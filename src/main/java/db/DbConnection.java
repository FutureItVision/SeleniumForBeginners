package db;

import java.sql.*;

public class DbConnection {

    public  static void dbConection(String query) throws ClassNotFoundException, SQLException {
        //DB connection
        Connection conn=null;
        //DB Queries
        Statement stmt=null;
        //DB result
        ResultSet resultSet=null;

        Class.forName("org.mariadb.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Khanjada?user=root&password=root");
        System.out.println("DB Connected");
        stmt=conn.createStatement();
        resultSet=stmt.executeQuery(query);
        System.out.println(resultSet=stmt.executeQuery(query));
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4)+" " + resultSet.getString(5));
        }
        if(resultSet !=null){
            try{
                resultSet.close();

            }catch (Exception e){

            }
        }
        if (stmt !=null){
            try {
               stmt.close();
            }catch (Exception e){

            }
        }
        if (conn !=null){
            try {
                conn.close();
            }catch (Exception e){

            }
        }
    }


}
