package com.mycompany.all;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaushikakumara
 */
public class Activity 
{
    private int activityId;
    private String activityName;
    private int activityQuantity;
    private String activityDate;
    
    public Activity(int activityId, String activityName, int activityQuantity, String activityDate)
    {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = activityDate;
    }
    
    //getter methods
        public int getActivityId()
        {
            return activityId;
        }
        public String getActivityName()
        {
            return activityName;
        }
        public int getActivityQuantity()
        {
            return activityQuantity;
        }
        public String getActivityDate()
        {
            return activityDate;
        }

        //setter methods
        public void setActivityId(int actid)
        {
            activityId = actid;
        }
        public void setActivityName(String actname)
        {
            activityName = actname;
        }
        public void setActivityQuantity(int actquantity)
        {
            activityQuantity = actquantity;
        }
        public void setActivityDate(String actdate)
        {
            activityDate = actdate;
        }
        
        public void display()
        {
            System.out.println("Activity ID is" + activityId);
            System.out.println("Activity Name is" + activityName);
            System.out.println("Activity Quantity is" + activityQuantity);
            System.out.println("Activity Date is" + activityDate);
        }
        
        public String toString() 
        {
        return 
                "Activity Id= " + activityId + "\n" +
                "Activity Name= " + activityName + "\n" +
                "Activity Quantity= " + activityQuantity + "\n" +
                "Activity Date= " + activityDate + "\n" +
                " " + "\n" +
                "≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠" + "\n" + 
                " "; 
        }
    
}
