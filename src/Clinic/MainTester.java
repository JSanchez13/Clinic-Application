/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class MainTester 
{
    public static void main(String[] args)
    {
        try {
            ArrayList<String> exam1 = new ArrayList<>();
            exam1.add("Breast-Cancer");
            exam1.add("Pregnancy-Test");
            exam1.add("Thyroid-Hormone");
            
            ArrayList<String> exam2 = new ArrayList<>();
            exam2.add("Breast-Cancer");
            exam2.add("Pregnancy-Test");
            exam2.add("Urine-Test");
            
            Billing patient1 = new Billing("Raul", "Gomez","786-318-4060","06-15-1991","SFASF","UnitedHealthOne",exam1);
            Billing patient2 = new Billing("Miguel", "Hernandez", "153-650-1523","12-01-1992","SDFAS","Aetna",exam2);
           
            System.out.println(patient1.readBillingRecords());
        } catch (IOException ex) 
        {
            Logger.getLogger(MainTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
