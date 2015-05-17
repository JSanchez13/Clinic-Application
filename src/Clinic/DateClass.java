/*
 * This class provides datea for the other classes in Clinic
 */
package Clinic;

//import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Andy Vega
 */
public abstract class DateClass
{
    public static String getDate()
    {
       //Calendar year, month, day
        Calendar now = Calendar.getInstance();
  
  
    //this converts the int variables for year, month and day to a String
    String year = "" + now.get(Calendar.YEAR);
    String month = "" + (now.get(Calendar.MONTH) + 1);
    String day = "" + now.get(Calendar.DATE);
    
    //this puts the String date together in the format "YYYY-MM-DD"
    String date =  month + "-" + day+ "-" + year;
    
    

    return date;
    } 
   
    //*********************************************************************
   
    
    //return the current month as an int
    public static int getMonth()
    {
       Calendar now = Calendar.getInstance();
       int month = (now.get(Calendar.MONTH) + 1); 
        
        
        return month;
    }
          
                
                
    
}
    
    
    
    
    
    
    
    
    
  



    
    
    
    
    
