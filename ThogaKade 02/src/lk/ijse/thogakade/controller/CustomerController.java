/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.model.Customer;

/**
 *
 * @author LAHIRU SASANKA
 */
public class CustomerController {
    
    public static ArrayList<Customer> getAllCustomers() throws Exception{
        String SQL="select * from customer";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Customer> custList= new ArrayList<>();
        while (rst.next()) {
            Customer c= new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
            custList.add(c);
        }
        return custList;
    } 
    
    public static ArrayList<String> getAllCustomersID() throws Exception{
        String SQL="select id from customer";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<String> custListID= new ArrayList<>();
        while (rst.next()) {
            custListID.add(rst.getString(1));
        }
        return custListID;
    } 
    
    public static boolean deleteCustomer(String id) throws Exception{
        String SQL="delete from customer where id='"+id+"'";
        Connection connection= DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }
    
    	
    public static Customer searchCustomer(String id)throws Exception{
	String SQL="Select * From Customer where id='"+id+"'";
	Connection conn=DBConnection.getInstance().getConnection();
	Statement stm=conn.createStatement();
	ResultSet rst=stm.executeQuery(SQL);
	if(rst.next()){
            Customer c1=new Customer();
                c1.setCid(rst.getString(1));
                c1.setName(rst.getString(2));
                c1.setAddress(rst.getString(3));
                c1.setSalary(rst.getDouble(4));
            return c1;
	}else{
            return null;
	}
    }
    
    public static boolean updateCustomer(Customer customer)throws Exception{
	String SQL="Update Customer set name='"+customer.getName()+"',address='"+customer.getAddress()+"',salary="+customer.getSalary()+" where id='"+customer.getCid()+"'";
	Connection conn=DBConnection.getInstance().getConnection();
	Statement stm=conn.createStatement();
	return stm.executeUpdate(SQL)>0;
    }	
    
    public static boolean addCustomer(Customer customer)throws Exception{
	String SQL="Insert into Customer Values('"+customer.getCid() +"','"+customer.getName()+"','"+customer.getAddress()+"',"+customer.getSalary()+")";
	Connection conn=DBConnection.getInstance().getConnection();
	Statement stm=conn.createStatement();
	return stm.executeUpdate(SQL)>0;
    }
}
