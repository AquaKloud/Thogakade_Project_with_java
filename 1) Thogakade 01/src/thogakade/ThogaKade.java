package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThogaKade {

    public static void main(String[] args) {
        try {
            String SQL = "Select * From Customer";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "ijse");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL); //java.sql.ResutlSet
            while (rst.next()) {
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                double salary = rst.getDouble("salary");
                System.out.println(id + "\t" + name + "\t" + address + "\t" + salary);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver S/W not found...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
