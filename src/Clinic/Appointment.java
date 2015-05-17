/*
 *The Appointment Class puts toghether a patient object with a doctor object
 *at a specific day and time
 */
package Clinic;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Andy Vega
 */
public final class Appointment extends Clinic
{

private String patientFName;
private String patientLName;
private String patientDOB;
private String patientFileName;
private String appointmentDate;
private int docSize = getDoctorList().size();
private int patSize = getPatientsList().size();
private static ArrayList<Patient> patientList;
private static ArrayList<Doctor> doctorList;
public String doctorName;
private int month, day, appointNum, typeAppointment, docNum;
String dt = DateClass.getDate();  // Start date

//////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
//constructor for first available/////////////////////////
    /**
     * @param pFName
     * @param pLName
     * @param pDOB
     */
    
    public Appointment(String pFName, String pLName, String pDOB)
    {
        super();
        patientFName = pFName;
        patientLName = pLName;
        patientDOB = pDOB;
        patientList = getPatientsList();
        doctorList = getDoctorList();
        patientFileName = patientLName.toLowerCase() + patientFName + patientDOB;
        typeAppointment = 1;

        getAppointment();

    }
 ////////////////////////////////////////////////////////////////////////////   
    //constructor for appointment with specific doctor
    public Appointment(String pFName, String pLName, String pDOB, 
            String dFName, String dLName)
    {
        patientFName = pFName;
        patientLName = pLName;
        patientDOB = pDOB;
        patientFileName = patientLName.toLowerCase() + patientFName +
                patientDOB;
        
        doctorName = "Dr. " + dFName + " " + dLName;
        
        typeAppointment = 2;
        
        getAppointment();
    }
 /////////////////////////////////////////////////////////////////////////////   
          //Constructor for Appointment with specific Doctor on a specific date
       //and time
       
       public Appointment(String pFName, String pLName, String pDOB, 
               String dFName, String dLName, int monthNum,
               int day, int appointNum)
       {
            patientFName = pFName;
            patientLName = pLName;
            patientDOB = pDOB;
            patientFileName = patientLName.toLowerCase() + patientFName +
            patientDOB;
        
            doctorName = "Dr. " + dFName + " " + dLName;
        
            this.month = monthNum;
            this.day = day;
            this.appointNum = appointNum;
            
            typeAppointment = 3;
                
            getAppointment();
           
       } 
 //////////////////////////////////////////////////////////////////////////////   
    
    
 
//**get patient file name from patient list to confirm active patient***
//  LOOP to search patientList and compare
//*************************************************************************
//*************************************************************************
private Boolean getCheckPatientFile()
{
    {
        int pSize; 
         for(pSize = 0; pSize < patSize; pSize++)
        {
          if(this.patientFileName.equals(patientList.get(pSize).
                  getFileName()))
          {
            return false;
          }
            
        
        } 
            return true;
    }
}
//***************************************************************************
//***************************************************************************
///////////////////////////////////////////////////////////////////////////
 //****************************************************************************
        //LOOP to see if doctor name is correct*******************
      private int getDocNum()
      {  
         int num = -1;
   
         {
         for(docNum = 0; docNum < docSize;)
                {
                   if(this.doctorName.equals(doctorList.get(docNum).
                   getName()))
                   {
                      num = docNum;
                      docNum = docSize -1;
                   }
                  docNum++;
                }
        
               return num;
         }
      }
///////////////////////////////////////////////////////////////////////////////        
     

    
    
    

    public String getAppointment() 
   {
       //check to see if patient exists in file
        boolean file = getCheckPatientFile();
   if(file == true)
   {
       System.out.println("The file by that name was not fount! Check spelling.");
       // System.out.println("The file by that name was not fount! Check spelling.");
         return "The file by that name was not fount! Check spelling.";
   }
       
       
    //**********************************************************************
    
    int monthInt = DateClass.getMonth();
    
         dt = DateClass.getDate();  // Start date
        int numMonth = 12;
        boolean appNotSet = true;
        int appointmentNum = 0;
       do
       {
       for(int monCount = 0; monCount < numMonth; monCount++)
        {
            
  //these conditional statements decide the number of days in the current month      
        int monthDays;
               //need to set monthDays to 28 or 30 or 31
        if(monthInt == 2)
        {
            monthDays = 28;
        }
        else if(monthInt == 4 || monthInt == 6 || monthInt == 9 ||
                monthInt == 11 )
        {
            monthDays = 30;
        }    
        else 
            monthDays =31;
  //**************************************************************************
        
        int appointmentsInDay = 14;
        
          for(int dayCount = 0; dayCount < monthDays; dayCount++)
          {
            if(typeAppointment == 3)
            {
                dayCount = day;
            }
            
           for(int appointment = 0; appointment < appointmentsInDay;
                   appointment++)
           {
                                
            for(docNum = 0; docNum < docSize; docNum++)
            {  
               if(typeAppointment == 2 || typeAppointment == 3)
                   {
                       docNum = getDocNum();
                   }
            
                 if(doctorList.get(docNum).getSchedule(monthInt,
                       appointment, dayCount) == null)
                   {
                            doctorList.get(docNum).setSchedule(patientFileName,
                               monthInt, appointment, dayCount);
                                //need to include appointment time
                   
                 //String dt = Date.getDate();  // Start date
                             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar c = Calendar.getInstance();
                    
    //*************************************************************************           
                  
    //**********************************************************************
                   
                    c.add(Calendar.DATE, dayCount);  // number of days to add
                    dt = sdf.format(c.getTime());  // dt is now the new date

                    doctorName =  doctorList.get(docNum).getName();
                    
                    
                   System.out.println("The appointment is for: " +
                           patientFileName + "\nWith: " + doctorName + 
                           "\nDate: " + dt + "\nAppointment number: " +
                           appointment);
                   
                  appNotSet = false; 
                  appointmentDate = dt;
                 // appointmentNum = appointment;
                  
                   return ("The appointment is for: " +
                           patientFileName + "\n:  With: " + doctorName + 
                           "\n:  Date: " + dt + "\n:  Appointment number: " +
                           appointment);
                  
                    }
             
           }
          }
        }
        }
       } while(appNotSet == true);

       return "No appointments available";
      
   }
    
//////////////////////////////////////////////////////////////////////////////       
/////////////////////////////////////////////////////////////////////////////       

    
    
    
  
       
       
   
   //may need to change to "return for GUI//////////////////////// 
   
    
    public String toString()
    {
        return "Patinet file name: " + patientFileName +
                "\nDate of appointment: " + appointmentDate + 
                "\nWith " + doctorName + "\n\n";
    }
}
