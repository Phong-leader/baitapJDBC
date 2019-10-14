/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btjavajdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NTP
 */
public class Insert {
    private Connection con = null;
    private String id, name;
    private int age;
    
    public String getname() {
        return name;
    }
 
    public void setname(String tenTacGia) {
        this.name = name;
    }
 
    public String getid() {
        return id;
    }
 
    public void setid(String id) {
        this.id = id;
    }
    public int getage() {
        return age;
    }
 
    public void setage(int age) {
        this.age = age;
    }
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ma sv: ");
        id = scan.nextLine();
        System.out.print("Nhap ten sv: ");
        name = scan.nextLine();
        System.out.print("Nhap so tuoi: ");
        age = Integer.parseInt(scan.nextLine());
    }
    
    public ResultSet GetResultSet() throws SQLException {
        
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select *from Student ";
        rs = stmt.executeQuery(sql);
        return rs;
    }
   
    public void Close() throws Exception {
        con.close();
    }
    public static void main(String[] args) throws SQLException, Exception  {
      KetNoiSQL kn = new KetNoiSQL(); 
      Insert In = new Insert();
      In.input();
        try {
            ResultSet rs= kn.GetResultSet("Studen");//Table Name
            while(rs.next())
            {
                System.out.println(rs.getString("id"));//Field Name
                System.out.println(rs.getString("name"));//Field Name
                System.out.println(rs.getString("age"));//Field Name
            }
            kn.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
