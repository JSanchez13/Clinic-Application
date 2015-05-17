/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

/**
 *
 * @author Andy
 */
public class Doctor extends Person
{
   
    private String specialization;
    
    ///////////////////////doctor schedule/////////////////////////////////////   
       
    private final int monthsWith31Days = 31;
    private final int monthsWith30Days = 30;
    private final int daysInFebruary = 28;
    private final int appointmentsInDay = 14;

    /**
     *
     */
    protected String[][] Jan;
    protected String[][] Feb;
    protected String[][] Mar;
    protected String[][] Apr;
    protected String[][] May;
    protected String[][] Jun;
    protected String[][] Jul;
    protected String[][] Aug;
    protected String[][] Sep;
    protected String[][] Oct;
    protected String[][] Nov;
    protected String[][] Dec;
//////////////////////////////////////////////////////////////////////////////
    
     //Constructor for Doctor
    public Doctor(String fN, String lN, String phNum, String special)
    {
       
        super(fN, lN, phNum);
        this.Dec = new String[appointmentsInDay][monthsWith31Days];
        this.Nov = new String[appointmentsInDay][monthsWith30Days];
        this.Oct = new String[appointmentsInDay][monthsWith31Days];
        this.Sep = new String[appointmentsInDay][monthsWith30Days];
        this.Aug = new String[appointmentsInDay][monthsWith31Days];
        this.Jul = new String[appointmentsInDay][monthsWith31Days];
        this.Jun = new String[appointmentsInDay][monthsWith30Days];
        this.May = new String[appointmentsInDay][monthsWith31Days];
        this.Apr = new String[appointmentsInDay][monthsWith30Days];
        this.Mar = new String[appointmentsInDay][monthsWith31Days];
        this.Feb = new String[appointmentsInDay][daysInFebruary];
        this.Jan = new String[appointmentsInDay][monthsWith31Days];
        specialization = special;
      
    }
    
     /**
     * 
     *
     * @param special
     */
    public void setSpecialization(String special)
    {
        specialization = special;
    }
    
     public String getSpecialization()
    {
       return specialization;
    }
    public String getFirstName()
    {
        return super.getFName();
    }
    public String getLastName()
    {
        return super.getLName();
    }
    
    public String getName()
    {
        return "Dr. " + super.getFName() + " " + super.getLName();
    }
      
    //Get doctor list *****Might need to change from print to return for GUI
      
    
     //Get doctor specialty list *****Might need to change from print to return for GUI
       
  
   //////////////////////////////////////////////////////////////////////////
  ////////////////DOCTOR SCHEDULE///////////////////////////////////////////
    /**
     *Set appointment in Doctors schedule
     * @param pName
     * @param hour
     * @param month
     * @param day
     */
    public void setSchedule(String pName, int month, int hour, int day)
    {
         switch (month)
        {
            case 1:
                Jan[hour][day] = pName;
                 
            case 2:
                Feb[hour][day] = pName;
               
            case 3:
                Mar[hour][day] = pName;
                
            case 4:
                Apr[hour][day] = pName;
                
            case 5:
                May[hour][day] = pName;
                
            case 6:
                Jun[hour][day] = pName;
                
            case 7:
                Jul[hour][day] = pName;
                
            case 8:
                Aug[hour][day] = pName;
                
            case 9:
                Sep[hour][day] = pName;
                
            case 10:
                Oct[hour][day] = pName;
                
            case 11:
                Nov[hour][day] = pName;
                
            case 12:
                Dec[hour][day] = pName;
                
            default:
                System.out.println("For the month you must use only the first"
                    + "three letters of the month and it must be "
                        + "capitalized\n");  
         }       
    }
    
    //get open appointments from doctors schedule
    public String getSchedule(int month, int hour, int day)
    {
        switch (month)
        {
            case 1:
                return Jan[hour][day];
                 
            case 2:
                return Feb[hour][day];
               
            case 3:
                return Mar[hour][day];
                
            case 4:
                return Apr[hour][day];
                
            case 5:
                return May[hour][day];
                
            case 6:
                return Jun[hour][day];
                
            case 7:
                return Jul[hour][day];
                
            case 8:
                return Aug[hour][day];
                
            case 9:
                return Sep[hour][day];
                
            case 10: 
                return Oct[hour][day];
                
            case 11:
                return Nov[hour][day];
                
            case 12:
                return Dec[hour][day];
                
            default:
                return "No appointments available for this month";
             
        }
       
    }
 ///////////////////////////////////////////////////////////////////////////
    
    /////toString method/////////////////////////////////////////
     public String toString()
            {
                return  "Doctor: " + super.getLName() + ", " + super.getFName() + " " +
                          "    Specialization: " + specialization + "\n";
                                        
            }
    
}
