package com.mycompany.all;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaushikakumara
 */
public class SupermarketManager 
{
    private JFrame jframe;
    private JFrame createProductFrame;
    private JFrame displayProductsFrame;
    private JFrame deleteProductFrame;
    private JFrame displaySameCategoryFrame;
    private JFrame updateSystemNewActivityFrame;
    private JFrame vendorReportFrame;
    
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Activity> activities = new ArrayList<>();
    HashMap<Integer, ArrayList<Activity>> vendorReport = new HashMap<>();

    public SupermarketManager()
    {
        jframe = new JFrame("LondonMet Supermarket");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(6,2));
        
        //creating the buttons
        JButton createProductButton = new JButton("Create & Add New Product");
        JButton displayProductsButton = new JButton("Display Products");
        JButton deleteProductButton = new JButton("Delete a Product");
        JButton displaySameCategoryButton = new JButton("Display the same Category Products");
        JButton updateSystemNewActivityButton = new JButton("Add New Activity");
        JButton vendorReportButton = new JButton("Display Vendor Report");

        //adding the buttons to the frame
        jframe.add(createProductButton);
        jframe.add(displayProductsButton);
        jframe.add(Box.createHorizontalGlue());
        jframe.add(Box.createHorizontalGlue());
        jframe.add(deleteProductButton);
        jframe.add(displaySameCategoryButton);
        jframe.add(Box.createHorizontalGlue());
        jframe.add(Box.createHorizontalGlue());
        jframe.add(updateSystemNewActivityButton);
        jframe.add(vendorReportButton);
        jframe.add(Box.createHorizontalGlue());
        jframe.add(Box.createHorizontalGlue());

        jframe.pack();
        jframe.setVisible(true);
        
        //1st action create & adding an item
        createProductButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createProductFrame = new JFrame("Create a New Product");
                createProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                createProductFrame.setLayout(new GridLayout(6,1));
                
                JTextField productIdField = new JTextField(20);
                JTextField productNameField = new JTextField(20);
                JTextField productCategoryField = new JTextField(20);
                JTextField productDateField = new JTextField(20);
                JTextField productQuantityField = new JTextField(20);
                JButton saveProductButton = new JButton("Save Product");
                JButton clearButton = new JButton("Clear");
                
                createProductFrame.add(new JLabel("Product ID: "));
                createProductFrame.add(productIdField);
                createProductFrame.add(new JLabel("Product Name: "));
                createProductFrame.add(productNameField);
                createProductFrame.add(new JLabel("Product Categoty: "));
                createProductFrame.add(productCategoryField);
                createProductFrame.add(new JLabel("Product Date: "));
                createProductFrame.add(productDateField);
                createProductFrame.add(new JLabel("Product Quantity: "));
                createProductFrame.add(productQuantityField);
                createProductFrame.add(clearButton);
                createProductFrame.add(saveProductButton);
                
                
                createProductFrame.pack();
                createProductFrame.setVisible(true);
                
                saveProductButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            
                        int productId = Integer.parseInt(productIdField.getText());
                        String productName = productNameField.getText();
                        String productCategory = productCategoryField.getText();
                        String productDate = productDateField.getText();
                        int productQuantity = Integer.parseInt(productQuantityField.getText());
                        
                        if(productQuantity<0)
                        {
                            JOptionPane.showMessageDialog(createProductFrame, "Product quantity cannot be negetive", "Create", JOptionPane.PLAIN_MESSAGE);
                            return;
                        }
                        
                        Product product = new Product(productId, productName,productCategory,productDate,productQuantity);
                        products.add(product);
                        
                        JOptionPane.showMessageDialog(createProductFrame, "Product Sucessfully created", "Create", JOptionPane.PLAIN_MESSAGE);
                        }
                        
                        catch(NumberFormatException ee)
                        {
                            JOptionPane.showMessageDialog(createProductFrame, "Please check your text fields", "Create", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    
                });
                clearButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        productIdField.setText("");
                        productNameField.setText("");
                        productCategoryField.setText("");        
                        productDateField.setText(""); 
                        productQuantityField.setText("");        
                    }
                });
            }
 
        });
        
        //2nd action display
        displayProductsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displayProductsFrame= new JFrame("Displaing the Products");
                displayProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                displayProductsFrame.setLayout(new BorderLayout());
                
                JTextArea textArea= new JTextArea();
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                displayProductsFrame.add(new JScrollPane (textArea),BorderLayout.CENTER);

                displayProductsFrame.setSize(600,400);
                displayProductsFrame.setLocationRelativeTo(null);
                displayProductsFrame.setVisible(true);
                
                for(Product product:products)
                {
                    textArea.append(product.toString()+"\n");
                    
                }
            }
        });
        
        //3rd action
        deleteProductButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteProductFrame = new JFrame("Delete A Product");
                deleteProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                deleteProductFrame.setLayout(new GridLayout(3,2));
                
                JTextField productIdField= new JTextField(20);
                JButton removeProductButton = new JButton("Remove The Product");
                JButton clear = new JButton("Clear");
                
                deleteProductFrame.add(new JLabel("Please enter the product id:"));
                deleteProductFrame.add(Box.createHorizontalGlue());
                deleteProductFrame.add(new JLabel("Product ID"));
                deleteProductFrame.add(productIdField);
                deleteProductFrame.add(clear);
                deleteProductFrame.add(removeProductButton);
                
                deleteProductFrame.pack();
                deleteProductFrame.setVisible(true);
                
                removeProductButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            int productId = Integer.parseInt(productIdField.getText());
                            Iterator<Product> iterator = products.iterator();
                            boolean productFound = false;
        
                            while (iterator.hasNext())
                            {
                                Product product = iterator.next();
                                if (product.getProductID() == productId) 
                                {
                                    iterator.remove();
                                    productFound = true;
                                    break; // Assuming there's only one product with the given ID, you can exit the loop once found.
                                 
                                }
                            }
                            if(productFound)
                            {
                                JOptionPane.showMessageDialog(deleteProductFrame, "Product "+ productId +" Successfully deleted", "Delete", JOptionPane.PLAIN_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(deleteProductFrame, "Please enter a valid Product Id number", "Delete", JOptionPane.PLAIN_MESSAGE);
                            }
                             
                            
                        }
                        catch(NumberFormatException ee)
                        {
                            JOptionPane.showMessageDialog(deleteProductFrame, "Please check your text field", "Delete", JOptionPane.PLAIN_MESSAGE);
                        }
                        
                    }
                });
                clear.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        productIdField.setText("");
                    }
                });
            }
        });
        
        //4th action 
        displaySameCategoryButton.addActionListener(new ActionListener()
        {
            boolean found = false;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displaySameCategoryFrame = new JFrame("Display the same category products");
                displaySameCategoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel displaySameCategoryPanel = new JPanel (new FlowLayout());
                JPanel displaySameCategoryPanel1 = new JPanel (new FlowLayout());

                JTextArea displaySameCategory= new JTextArea();
                JTextField productCategoryField = new JTextField(15);
                JButton searchButton = new JButton("Search");
                JButton clear = new JButton("Clear");
                
                displaySameCategoryPanel.add(new JLabel("Please enter the product Category:"));
                displaySameCategoryPanel.add(new JLabel("Product Category"));
                displaySameCategoryPanel.add(productCategoryField);
                displaySameCategoryPanel.add(clear);
                displaySameCategoryPanel.add(searchButton);
                displaySameCategoryPanel1.setLayout(new BoxLayout(displaySameCategoryPanel1,BoxLayout.Y_AXIS));
                displaySameCategoryPanel1.add(displaySameCategoryPanel);
                displaySameCategoryPanel1.add(new JScrollPane (displaySameCategory),BorderLayout.CENTER);
                displaySameCategoryFrame.add(displaySameCategoryPanel1);
                
                displaySameCategoryFrame.setSize(600,400);
                displaySameCategoryFrame.setLocationRelativeTo(null);
                displaySameCategoryFrame.setVisible(true);

                searchButton.addActionListener(new ActionListener()
                {
                   @Override
                   public void actionPerformed(ActionEvent e)
                   {
                       displaySameCategory.setText("");
                       ArrayList<Product> sameCategory = new ArrayList<>();
                       String productCategory = (productCategoryField.getText());
                       for(Product product:products)
                       {
                           if(product.getProductCategory().equalsIgnoreCase(productCategory))
                           {
                               sameCategory.add(product);
                               found = true;
                           }
                       }
                       Collections.sort(sameCategory, Comparator.comparingInt(Product::getProductQuantity));
                       for(Product product1:sameCategory)
                       {
                           displaySameCategory.append(product1.toString()+"\n");
                       }
                       
                       if(found == false)
                       {
                           JOptionPane.showMessageDialog(displaySameCategoryFrame, "Please enter a valid Product Category", "Same Category", JOptionPane.PLAIN_MESSAGE);
                       }
                       
                   }
                });
                clear.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        productCategoryField.setText("");
                        displaySameCategory.setText("");
                    }
                });
            }
        });
        
        //5th action
        updateSystemNewActivityButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateSystemNewActivityFrame = new JFrame("Update the system with new Activity");
                updateSystemNewActivityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateSystemNewActivityFrame.setLayout(new GridLayout(6,2));
                
                String [] options = {"Add to Stock", "Remove from Stock"};
                JTextField productIdField = new JTextField(20);
                JTextField activityIDField = new JTextField(20);
                JComboBox <String> dropdown = new JComboBox<> (options);
                JTextField activityQuantityField = new JTextField(20);
                JTextField activityDateField = new JTextField(20);
                JButton clearButton = new JButton("Clear");
                JButton updateActivityButton = new JButton("Update Activity");
               
                updateSystemNewActivityFrame.add(new JLabel("Product ID: "));
                updateSystemNewActivityFrame.add(productIdField);
                updateSystemNewActivityFrame.add(new JLabel("Activity ID: "));
                updateSystemNewActivityFrame.add(activityIDField);
                updateSystemNewActivityFrame.add(new JLabel("Activity Name: "));
                updateSystemNewActivityFrame.add(dropdown);
                updateSystemNewActivityFrame.add(new JLabel("Activity Quantity: "));
                updateSystemNewActivityFrame.add(activityQuantityField);
                updateSystemNewActivityFrame.add(new JLabel("Activity Date: "));
                updateSystemNewActivityFrame.add(activityDateField);
                updateSystemNewActivityFrame.add(clearButton);
                updateSystemNewActivityFrame.add(updateActivityButton);
                
                
                updateSystemNewActivityFrame.pack();
                updateSystemNewActivityFrame.setVisible(true);
                
                updateActivityButton.addActionListener(new ActionListener()
                {
                   @Override
                   public void actionPerformed(ActionEvent e)
                   {
                       
                       int activityQuantity = 0;
                       try
                       {
                           activityQuantity= Integer.parseInt(activityQuantityField.getText());
                           if(activityQuantity < 0)
                           {
                               JOptionPane.showMessageDialog(null,"Please enter a Positive number.");
                               return;
                           }
                       }
                       catch(NumberFormatException ex)
                       {
                           JOptionPane.showMessageDialog(null,"Please enter a valid number.");
                           return;
                       }
               
                       int productID = Integer.parseInt(productIdField.getText());
                       for(Product product:products)
                       {
                           if(product.getProductID()==productID)
                           {
                               int activityId = Integer.parseInt(activityIDField.getText());
                               String activityName = (String) dropdown.getSelectedItem();
                               String activityDate = activityDateField.getText();
                               int productQuantity = product.getProductQuantity();
                           
                               if(activityName.equals("Add to Stock"))
                               {
                                   product.setProductQuantity(activityQuantity + productQuantity);
                               }
                               else
                               {
                                   if(activityQuantity > productQuantity)
                                   {
                                       JOptionPane.showMessageDialog(null,"Please enter a number smaller than product quantity");
                                       return;
                                   }
                                   else
                                   {
                                       product.setProductQuantity(productQuantity - activityQuantity);
                                   }
                               }
                               
                               Activity activity = new Activity(activityId, activityName, activityQuantity, activityDate);
                               activities.add(activity);
                               JOptionPane.showMessageDialog(updateSystemNewActivityFrame, "New Activity Upadated", "Update an Activity", JOptionPane.PLAIN_MESSAGE);
                               product.setActivityList(activity);
                               vendorReport.put(productID, product.getActivityList());
                               
                           }
                       }
                   }
                });
                clearButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        productIdField.setText("");
                        activityIDField.setText("");
                        activityQuantityField.setText("");        
                        activityDateField.setText("");     
                    }
                });
                
            }
        });
        
        //6th action
        vendorReportButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                vendorReportFrame = new JFrame("Vendor Report");
                vendorReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel vendorReportPanel = new JPanel(new FlowLayout());
                JPanel vendorReportPanel1 = new JPanel(new FlowLayout());
                
                JTextField productIdField = new JTextField(20);
                JButton displayVendorReportButton = new JButton("Display Vendor Report");
                JTextArea displayVendorReportTextArea = new JTextArea();
                JButton clear = new JButton("Clear");
                
                vendorReportPanel.add(new JLabel("Please enter the product ID"));
                vendorReportPanel.add(new JLabel("Product ID: "));
                vendorReportPanel.add(productIdField);
                vendorReportPanel.add(clear);
                vendorReportPanel.add(displayVendorReportButton);
                vendorReportPanel1.setLayout(new BoxLayout(vendorReportPanel1,BoxLayout.Y_AXIS));
                vendorReportPanel1.add(vendorReportPanel);
                vendorReportPanel1.add(new JScrollPane (displayVendorReportTextArea),BorderLayout.CENTER);
                vendorReportFrame.add(vendorReportPanel1);
                
                        
                vendorReportFrame.setSize(600,400);
                vendorReportFrame.setLocationRelativeTo(null);
                vendorReportFrame.setVisible(true);
                
                displayVendorReportButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            int vendorReportint = Integer.parseInt(productIdField.getText());
                        
                            for(int i : vendorReport.keySet())
                            {
                                if(i==vendorReportint)
                                {   
                                    for(Activity activity:vendorReport.get(vendorReportint))
                                    {
                                        displayVendorReportTextArea.append(activity.toString()+"\n");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(vendorReportFrame, "Please enter a valid product Id", "Displaying vendor report", JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                        }
                        catch(NumberFormatException ee)
                        {
                            JOptionPane.showMessageDialog(vendorReportFrame, "Please check your text field", "Displaying vendor report", JOptionPane.PLAIN_MESSAGE);
                        }
                        
                    }
                });
                clear.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        productIdField.setText("");
                        displayVendorReportTextArea.setText("");
                        
                    }
                });
                
            }
        });
    }
}
                
              