/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPriorityQueue;

public class Call implements Comparable<Call>{
    
    String event;
    boolean dangerProperty;
    int dangerLevel;
    
    /**
     * Constructor
     * 
     * @param event
     * @param dangerProperty
     * @param dangerLevel 
     */
    public Call(String event, boolean dangerProperty, int dangerLevel)
    {
        this.event = event;
        this.dangerProperty = dangerProperty;
        this.dangerLevel = dangerLevel;
    }
    
    public void setEvent(String event)
    {
        this.event = event;
    }
    
    public void setDangerProperty(boolean dangerProperty)
    {
        this.dangerProperty = dangerProperty;
    }
    
    public void setDangerProperty(int dangerLevel)
    {
        this.dangerLevel = dangerLevel;
    }
    
    public String getEvent()
    {
        return event;
    }
    
    public boolean getDangerPropery()
    {
        return dangerProperty;
    }

    public int getDangerLevel()
    {
        return dangerLevel;
    }
    
    /**
     * Method that determines if one object is bigger
     * then another
     * 
     * @param kl - object that is compared by
     * @return returns +1 if object is bigger then k1
     *         returns -1 if object is smaller then k1
     *         returns 0 if object is equal to k1
     */
    @Override
    public int compareTo(Call kl) { 
        double newDangerLevel = kl.getDangerLevel();
        if (dangerLevel < newDangerLevel) return -1;
        if (dangerLevel > newDangerLevel) return +1;
        return 0;
    }
    
    /**
     * Formats data and returns string to print
     * 
     * @return returns formatted data to string
     */
    @Override
    public String toString()
    {
        return String.format("%-20s %-8s %15d%n",
               event, dangerProperty, dangerLevel);
    };
        
}
