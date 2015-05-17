package Clinic;


import java.io.*;
import java.util.*;


/**
 *
 * @author Andres
 */
public class Clinic 
{

    private static ArrayList<Doctor> doctorList = new ArrayList<>();;
    private static ArrayList<Patient> patientsList = new ArrayList<>();
    private static ArrayList<Appointment> AppointmentList = new ArrayList<>();
    

     public ArrayList<Doctor> getDoctorList() 
    {
        return copylist(doctorList);
    }

    
    public ArrayList<Patient> getPatientsList() 
    {
        return copylist(patientsList);
    }

    public ArrayList<Appointment> getAppointmentList() 
    {
        return copylist(AppointmentList);
    }
   
    private ArrayList copylist(ArrayList originalList)
    {
        ArrayList copyList = new ArrayList<>();
        if(!originalList.isEmpty())
        for (int i = 0; i < originalList.size(); i++) 
        {
            
          copyList.add(originalList.get(i));
        }
        return copyList;
    }


    public void setAppointmentList(Appointment NewAppointment) 
    {
        if (NewAppointment != null) 
        {
            this.AppointmentList.add(NewAppointment);
        }

    }

   

    public static String printDoctorList() //Doctor's Last Name, First Name    Specialty: Surgeon
    {
        String auxiliary = "Sorry. No doctors have been added to the Clinic yet";
        if (!doctorList.isEmpty()) 
        {     
            auxiliary = "";
            for (int i = 0; i < doctorList.size(); i++) 
            {
                auxiliary += "\n"+ doctorList.get(i);
            }
       }
         
        return auxiliary;
    }

    public static String printPatientList()// Will return the Patient's First and Last Name, the Balance owed to the Clinic and the Insurance Provider w/ 
    {                             //the insurance coverage
    
       String auxiliary = "Sorry. No patients have been added to the Clinic yet";
       if (!patientsList.isEmpty()) 
       {
            auxiliary = "";
            for (int i = 0; i < patientsList.size(); i++) 
            {
                auxiliary += patientsList.get(i) + "\n\n";
            }
            
        }
       return auxiliary;

    }

 
    public String searchDoctorbySpecialty(String specialty) 
    {
        String auxiliary = "Sorry, but we were unable to find any results for you/n.";
        if (specialty.length() != 0) 
        {
            auxiliary = "";
            for (int i = 0; i < doctorList.size(); i++) 
            {

                if (doctorList.get(i).getSpecialization().equals(specialty)) 
                {
                    auxiliary += doctorList.get(i);
                    
                }
            }
        }

        return auxiliary;
    }

    public String searchDoctorbyName(String name)
    {
         String auxiliary = "The Field cannot be empty";
         
         if(name.length() != 0)
         {
             boolean gotIn = false;
             auxiliary = "";
            for (int i = 0; i < doctorList.size(); i++) 
            {
                if (doctorList.get(i).getFirstName().equals(name) || doctorList.get(i).getLastName().equals(name)) 
                {
                    auxiliary += doctorList.get(i);
                    gotIn = true;
                }
            }
             if(!gotIn) auxiliary = "Sorry, but we were unable to find any results for you\n.";
         }
        
            return auxiliary;  
    }

    public String searchDoctorbyFLName(String fName, String lName) 
    {
         String auxiliary = "The Field cannot be empty";
        if(fName.length() != 0 && lName.length() != 0)
        {
            boolean gotIn = false;
             auxiliary = "";
            for (int i = 0; i < doctorList.size(); i++) 
            {
                if (doctorList.get(i).getFirstName().equals(fName) && doctorList.get(i).getLastName().equals(lName)) 
                {
                    auxiliary = doctorList.get(i).toString();
                    gotIn = true;
                }
            }
            if(!gotIn) auxiliary = "Sorry, but we were unable to find any results for you\n.";
        }

        return auxiliary;

    }

    public String searchPatientbyName(String name)
    {

         String auxiliary = "The Field(s) cannot be empty";    
        if (name.length() != 0) 
        {
             boolean gotIn = false;
             auxiliary = "";
            for (int i = 0; i < patientsList.size(); i++) {
            if (patientsList.get(i).getFirstName().equals(name) || patientsList.get(i).getLastName().equals(name))
            {
                auxiliary+= patientsList.get(i) + "\n\n";
                gotIn = true;
            }
            }
             if(!gotIn) auxiliary = "Sorry, but we were unable to find any results for you\n.";
        }
        return auxiliary;
    }

    public String searchPatientbyFLName(String fName, String lName) 
    {
        String auxiliary = "The Field(s) cannot be empty";  
        if (fName.length() != 0 && lName.length() != 0)
        {
             boolean gotIn = false;
             
            for (int i = 0; i < patientsList.size(); i++) 
            {

                if (patientsList.get(i).getFirstName().equals(fName) && patientsList.get(i).getLastName().equals(lName)) 
                {
                    auxiliary = patientsList.get(i) + "\n\n";
                    gotIn = true;
                }
            }
            if(!gotIn) auxiliary = "Sorry, but we were unable to find any results for you\n.";
        }
        return auxiliary;
    }
 
    public static void addDoctor(Doctor newDoctor) 
    {
        
        if (!(newDoctor.getFName().equals("")&& newDoctor.getLName().equals("")&& 
                newDoctor.getSpecialization().equals("") && newDoctor.getPhone().equals("")))
        {
            doctorList.add(newDoctor); 
        } 
        
        
     }

    public String addPatient(Patient newPatient) 
    {
        if (newPatient != null) 
        {
            patientsList.add(newPatient);
            return "The Patient has been successfully created.\n";
        } 
        
        return "Sorry! An error occurred. The Patient information cannot be empty";
    }

    public String removeDoctor(Doctor dr) 
    {
        boolean found = false;
        for (int i = 0; i < doctorList.size(); i++) 
        {
             if(doctorList.get(i).getFName().equals(dr.getFName()) && doctorList.get(i).getLName().equals(dr.getLName()) &&
             doctorList.get(i).getSpecialization().equals(dr.getSpecialization()));
            {
                doctorList.remove(i);
                found = true;
            }
        }
        if (found) 
        {
           return ("The doctor was succesfully found and deleted from the system.\n");
        } 
        
         return ("Sorry. The doctor was not found in our clinic.\n"); 
    }

    public String removePatient(String fn, String ln, String ph) 
    {
        boolean found = false;
        for (int i = 0; i < patientsList.size(); i++) 
        {
             if(patientsList.get(i).getFirstName().equals(fn) && patientsList.get(i).getLastName().equals(ln) && 
                     patientsList.get(i).getPhone().equals(ph))
               {
                    patientsList.remove(i);
                    found = true;
               }
        }

        if (found) 
        {
            return ("The patient was succesfully found and deleted from the system.\n");
        }
       
            return ("Sorry. The patient was not found in our clinic.\n");
        
    }

    public String printBillingForAllPatients() throws IOException // This prints the billing for all the patients stored in the file "billingRecords.txt"
    {
        return Billing.readBillingRecords();
        
    }

    public static String printInsuranceProviders() 
    {
        String output; 
        output = ("PROVIDERS              COVERAGE" 
                 +"\nAetna..............................$1,500.00"
                 +"\nIHC-Group.....................$1,000.00"
                 +"\nHumana.........................$1,050.00"
                 +"\nAssurant-Health............$1,050.00"
                 +"\nKaiser-Permanent.........$1,025.00"
                 +"\nUnitedHealthOne...........$1,010.00"
                 +"\nAmbetter...........................$1,250.00"
                 +"\nCigna................................$1,350.00"
                 +"\nCoventry............................$1,450.00"
                 +"\nMolina Health Care.........$1,110.00");
               
        
        return output;
    }

    public String printInsuranceByPatient(Patient pt) 
    {
        String output = "Sorry. The patient was not found in our Clinic\n";
        if (pt != null && searchPatientbyFLName(pt.getFName(), pt.getLName()).length()<50);
        {
            
            output = pt + "\n";
           
        }
        
        return output;
    }

    public static String printInsuranceAllPatientList() 
    {
        String output = "The clinic does not have patients yet. \n";
        if(!patientsList.isEmpty())
        {
            output = "";
            for (int i = 0; i < patientsList.size(); i++) 
            {
                output += patientsList.get(i).getLName() + ", " + patientsList.get(i).getFName() + "  Insurance: " + patientsList.get(i).getInsProvider() + "\n";

            }
        }
        
        return output;
    }

    /**
     *
     * @return
     */
    public static String listOfAppointments() //************DO THIS******************
    {
        String output = "No appointments have been created yet";
        if(!AppointmentList.isEmpty())
        {
            output = "";
        for (int i = 0; i < AppointmentList.size(); i++) 
        {
            output += AppointmentList.get(i);
        }
        }
        return output;
    }

    
        
}
