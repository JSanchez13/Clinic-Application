/*
 * Person is an bstract Super class to create a person with First Name Last Name
 * phone number and address. This can be used by the Doctor and Patient 
 * subclasses to create new Doctors and Patients
 */
package Clinic;

/**
 *
 * @author Andy Vega
 */
public abstract class Person 
{
    private String fName, lName;
    private String phone;
    
    //person constructor
    public Person(String fN, String lN, String phNum)
    {
        fName = fN;
        lName = lN;
        phone = phNum;
       
    }
    
    //set all fields
    public void setFName(String fN)
    {
        fName = fN;
    }
    
     public void setLName(String lN)
    {
        lName = lN;
    }
    
     public void setPhone(String phNum)
    {
        phone = phNum;
    }
    
          
      //get all
      
       public String getFName()
    {
        return fName;
    }
     
           public String getLName()
    {
        return lName;
    }
           
        public String getPhone()
    {
        return phone;
    }
      
     
}
