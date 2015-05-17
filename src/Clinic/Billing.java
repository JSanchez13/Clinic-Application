/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.io.*;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andres
 */
public class Billing extends Patient
{
    private double balance;
    private double netBalance;
    private double amountCovered;
    private File examData;
    private File insProv;
    private String visitDate;
    private static DataInputStream readingBillingRecords;
    private DataOutputStream writingBillingRecord ;
    private ArrayList<String> examsTakenByPatient; // String organized in the same order as the file MedicalLabExams   
    private Scanner keyboardExam;
    private Scanner keyboardIns;
   

     public Billing(String fn, String ln, String ph, String addr, String InsProv, String birthday, ArrayList<String> examsTaken) 
    {
                      
        super(fn,ln,ph,addr,birthday,InsProv);
        examsTakenByPatient = new ArrayList<>();
        copylist(examsTaken, this.examsTakenByPatient);
        this.balance = 0;
        this.netBalance = 0;
        this.amountCovered = 0;
        visitDate = GetCurrentDateTime();
        loadBillingFiles();
        setBalance();
        findPatientsInsCoverage();   
        saveBillingRecords();
    }

    public ArrayList<String> getExamsTakenByPatient()
    {
        ArrayList<String> copyList = new ArrayList<>();
        copylist(examsTakenByPatient, copyList);
        return copyList;
    }
    public String printExamsTakenbyPatient()
    {
        String auxiliary = "Exams Taken: ";
        for (int i = 0; i < this.examsTakenByPatient.size()-1; i++) 
        {
            auxiliary+= examsTakenByPatient.get(i) + ", ";
        }
        auxiliary += examsTakenByPatient.get(examsTakenByPatient.size()-1);
        
        return auxiliary;
    }

    public double getNetBalance() {
        return netBalance;
    }

    public double getAmountCovered() {
        return amountCovered;
    }
 
     public double getBalance() 
    {
        return this.balance;
    }

    private void setBalance()
    {
        try
        {
            for (int i = 0; i < examsTakenByPatient.size(); i++) 
            {
                if(!examsTakenByPatient.isEmpty())
                while(keyboardExam.hasNextLine())
                {
                 String a = keyboardExam.next();
                
                   if(a.equals(examsTakenByPatient.get(i)))
                    {
                      balance+= keyboardExam.nextDouble();
                      break;
                    } 
                   else keyboardExam.nextLine();
                }
            }
        }
        catch(NoSuchElementException | IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            keyboardExam.close(); 
        }    
    }

    public void setPayment(double payment) throws Exception
    {
        if(payment != this.netBalance)throw new Exception("Payment has to be greater than zero and less than the balance you owe");
        else
        {
            this.balance-=payment;
            this.examsTakenByPatient.clear();
        }
    }

    private void loadBillingFiles() 
    {
        try
        {
             examData = new File("MedicalLabExams.txt");
             insProv = new File("InsuranceProvider.txt");
             writingBillingRecord = new DataOutputStream(new FileOutputStream("billingRecords.txt",true));
             readingBillingRecords = new DataInputStream(new FileInputStream("billingRecords.txt"));
             keyboardExam = new Scanner(examData); 
             keyboardIns = new Scanner(insProv);
                   
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
             
    }
    
    private String SaveBillingFormat() // this will save the patient's file in specific format by patient
    {
        return (super.getFirstName().toLowerCase() + super.getLastName().toLowerCase() + super.getDateOfBirth() + ".txt"); // Date of birth: mm-dd-yyyy
    }
    private void findPatientsInsCoverage()
    {
        try
        {
               while(keyboardIns.hasNext())
                {
                 String a = keyboardIns.next();
                
                   if(a.equals(super.getInsProvider()))
                    {
                      amountCovered = keyboardIns.nextDouble();
                      if(amountCovered >= balance) 
                      {
                          
                          netBalance = 0;
                      
                      }
                      else
                         netBalance = balance- amountCovered;
                      break;
                    } 
                   else keyboardIns.nextLine();
                }
               
                              
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
       finally
       {
         keyboardIns.close();  
       }
             
    }
    
    private void copylist(ArrayList<String> originalList, ArrayList<String> copyList)
    {
        if(!originalList.isEmpty())
        for (int i = 0; i < originalList.size(); i++) 
        {
            
          copyList.add(originalList.get(i));
        }
        originalList.clear();
    }
    
    private void saveBillingRecords() 
    {
     
            String aux = super.getFirstName() + "  " + super.getLastName()+ "    " + "Visit Date: " + this.visitDate + "\n" +
                    printExamsTakenbyPatient()
                    + "\nTotal Amount: $" + getBalance()  +  "\nInsurance Covered Amount: $" 
                    + getAmountCovered() + "\nBalance owed: $" + getNetBalance()+ "\n\n";
            
            try
            {
                writingBillingRecord.writeUTF(("Patient's Info \n").toUpperCase());
                writingBillingRecord.writeUTF(aux);
                
                
            }
            catch (IOException ex)
            {
                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

    public String getVisitDate() {
        return visitDate;
    }
        
    public static String readBillingRecords() throws IOException
    {
        String auxiliary = " ";
        boolean endOfFile = false;
       while(!endOfFile)
       {
           try
           {
                auxiliary += readingBillingRecords.readUTF();
               
           }
           catch (EOFException e)
           {
               endOfFile = true;
           }
   
       }
       return auxiliary;
    }
    
    /**
     *
     * @return
     */
    public static String GetCurrentDateTime()
    {
        
         DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY");
           //get current date time with Date()
           Date date = new Date();
           return dateFormat.format(date);
       
    }
    private void closingFilesOpen()
    {
        try {
            readingBillingRecords.close();
            writingBillingRecord.close();
        } catch (IOException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
}


