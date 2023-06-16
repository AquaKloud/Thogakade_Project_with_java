package lk.ijse.thogakade.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.model.Item;

public class ItemController{
    public static ArrayList<String>getAllItemCodes()throws Exception{
	Connection connection=DBConnection.getInstance().getConnection();	
	Statement stm=connection.createStatement();
	ResultSet rst=stm.executeQuery("Select code from Item");
	ArrayList<String>itemCodeList=new ArrayList<>();
	while(rst.next()){
            itemCodeList.add(rst.getString("code"));
	}	
	return itemCodeList;
    }
		
    public static Item searchItem(String code)throws Exception{
	Connection connection=DBConnection.getInstance().getConnection();	
	Statement stm=connection.createStatement();
	ResultSet rst=stm.executeQuery("Select * from Item where code='"+code+"'");
	if(rst.next()){
            Item item=new Item();
		item.setCode(code);
		item.setDescription(rst.getString("description"));
		item.setUnitprice(rst.getDouble("unitPrice"));
		item.setQty(rst.getInt("qtyOnHand"));
		return item;
	}
	return null;
    } 
    
    public static boolean deleteItem(String id) throws Exception{
        String SQL="delete from item where code='"+id+"'";
        Connection connection= DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }	
    
    public static boolean updateItem(Item item)throws Exception{
	String SQL="Update item set description='"+ ""+item.getDescription()+"',unitPrice='"+item.getUnitprice()+"',qtyOnHand="+item.getQty()+""+ " where code='"+item.getCode()+"'";
	Connection conn=DBConnection.getInstance().getConnection();
	Statement stm=conn.createStatement();
	return stm.executeUpdate(SQL)>0;
    }
    
    public static boolean addCustomer(Item item)throws Exception{
	String SQL="Insert into item Values('"+ ""+item.getCode() +"',"+ "'"+item.getDescription()+"',"+ "'"+item.getUnitprice()+"',"+ ""+item.getUnitprice()+")";
	Connection conn=DBConnection.getInstance().getConnection();
	Statement stm=conn.createStatement();
	return stm.executeUpdate(SQL)>0;
    }
    
}
