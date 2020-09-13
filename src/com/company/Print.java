package com.company;

import java.util.*; // Scanner

public class Print
{
    Scanner scanner = new Scanner(System.in);
    
    public void welcomeMessage()
    {
        System.out.println("\n\n\t\t\tWELCOME TO THE BINARY CONVERTER!\n" +
                                   "You can use the converter to convert a number from binary to decimal OR from " +
                                   "decimal to binary.");
    }
    
    
    public String findFromType()
    {
        System.out.print("\nWhich number system would you like to convert from? (binary or decimal): ");
        
        String fromType = null;
        
        while(true)
        {
            fromType = scanner.nextLine();
            
            // hvis de skriver enten binary eller decimal
            if(fromType.equalsIgnoreCase("binary") || fromType.equalsIgnoreCase("decimal"))
            {
                return fromType;
            }
            
            System.out.print("\t\tOOPS, wrong input.\nYou have to choose either binary or decimal: ");
        }
    }
    

    
    public void chooseNumberToConvert(String fromType)
    {
        System.out.print("Which " + fromType.toLowerCase() + " number would you like to convert?: ");
    }
    
    
}
