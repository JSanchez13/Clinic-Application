/*
 * the Patient is a Person sub class that has the patients information and
 *creates a file name to hold the patients history
 */
package Clinic;

import javax.swing.JTextField;

/**
 *
 * @author Andy Vega
 */
public class Patient extends Person
{
    private String dateOfBirth, patientAddress, fileName, insProvider;
      
   
    public Patient(String fN, String lN, String phNum, String addr,
            String birth, String insProvider)
    {
       super(fN, lN, phNum);
       this.insProvider = insProvider; 
       patientAddress = addr;
       dateOfBirth = birth;
       
       setFileName(birth);
    }

    
   
    //setFileName will use the last and first names with the date of bieth to 
    //create a file name for the patient in the format "lastFirstYYYY-MM-DD
   public final void setFileName(String bDay)
    {
         String lNameLower = super.getLName().toLowerCase();
       fileName = (lNameLower + super.getFName() + dateOfBirth);
       
     
    }
   
   public void setInsProvider(String insProvider)
   {
       this.insProvider = insProvider;
   }
   
    public String getInsProvider()
   {
       return insProvider;
   }
   
   //return the file name
   public String getFileName()
    {
        
       return fileName ;
    }
   
   public String getFirstName()
    {
        
       return super.getFName();
    }
   
   public String getLastName()
    {
        
       return super.getLName() ;
    }
    
       
   
  
   //??????????????????????????????????????????????????????????????????????????
   
   
    //set patient address
    public void setpatientAddress(String addr)
    {
        patientAddress = addr;
    }
    
     //get patient address
    public String getPAddress()
    {
        return patientAddress;
    }
    
    //set the date of birth
    public void setDateOfBirth(String birth)
    {
       dateOfBirth = birth;
    }    
    
    //get the date of birth
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    
    //for GUI need to change void to String and Print to return
   

    //the toString mathod returns the patients information including the
    //name of the file containing the patients history
   public String toString()
            {
                return  "Patient: " + super.getFName() + " " +
                        super.getLName() + "\nDate of Birth: " + dateOfBirth + 
                        "\nPhone Number: " + super.getPhone() + 
                        "\nAddress: " + patientAddress + "\n" +
                        "Health Provider: " + insProvider + "\n";
                        
            }
       
}
