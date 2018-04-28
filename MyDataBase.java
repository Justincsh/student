/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Chan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataBase {

    Connection con;
    Statement sta;
    ResultSet res;

    public MyDataBase() {
        try {

            con = DriverManager.getConnection();
            sta = con.createStatement();
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet FindDatabase(String s) {
        try {
            res = sta.executeQuery(s);
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    public void Setdatabase(String s) {
        try {
            sta.executeUpdate(s);
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
