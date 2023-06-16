/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.model;

/**
 *
 * @author LAHIRU SASANKA
 */
public class Item {
    
    private String code;
    private String description;
    private int qty;
    private double unitprice;

    public Item() {
    }

    public Item(String code, String description, int qty, double unitprice) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.unitprice = unitprice;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the unitprice
     */
    public double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }
    
    
    
    
}
