package com.mycompany.all;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaushikakumara
 */
public class Product 
{
    private int productId;
    private String productName;
    private String productCategory;
    private String productDate;
    private int productQuantity;
    private ArrayList<Activity> activityList = new ArrayList<>();
    
    public Product(int productId, String productName, String productCategory, String productDate,int productQuantity)
    {
        this.productId = productId;
        this.productName= productName;
        this.productCategory = productCategory;
        this.productDate = productDate;
        this.productQuantity = productQuantity;
        
    }
    
    //getter methods
    public int getProductID()
    {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public String getProductCategory()
    {
        return productCategory;
    }
    public String getProductDate()
    {
        return productDate;
    }
    public int getProductQuantity()
    {
        return productQuantity;
    }
    
    //setter methods
    public void setProductID(int proid)
    {
        productId = proid;
    }
    public void setProductName(String proname)
    {
        productName = proname;
    }
    public void setProductCategory(String procategory)
    {
        productCategory = procategory;
    }
    public void setProductDate(String prodate)
    {
        productDate = prodate;
    }
    public void setProductQuantity(int proquantity)
    {
        productQuantity = proquantity;
    }
    
    public void display()
    {
        System.out.println("Product ID is: "+ productId);
        System.out.println("Product Name is: "+ productName);
        System.out.println("Product Category is: "+ productCategory);
        System.out.println("Product Date is: "+ productDate);
        System.out.println("Product Quantity is: "+ productQuantity);
        
    }
    @Override
    public String toString() 
    {
        return 
                "product Id= " + productId + "\n" +
                "product Name= " + productName + "\n" +
                "product Category= " + productCategory + "\n" +
                "product Date= " + productDate + "\n" +
                "product Quantity= " + productQuantity + "\n" +
                " " + "\n" +
                "≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠" + "\n" + 
                " "; 
    }
    
    public ArrayList<Activity> getActivityList()
    {
        return this.activityList;
    }
    
    public void setActivityList(Activity activity)
    {
        if(activityList.size()>3)
        {
            activityList.remove(0);
            activityList.add(activity);
        }
        else
        {
            activityList.add(activity);
        }
        
    }

    
}
