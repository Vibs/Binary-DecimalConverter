package com.company;

import java.util.*; // Scanner

public class Print
{
    Scanner scanner = new Scanner(System.in);
    
    public String findFromType()
    {
        System.out.print("Which number system would you like to convert from? (binary or decimal): ");
        
        String fromType = null;
        
        while(true)
        {
            fromType = scanner.nextLine();
            
            if(fromType.equalsIgnoreCase("binary") || fromType.equalsIgnoreCase("decimal"))
            {
                return fromType;
            }
            
            System.out.print("Wrong input. You have to choose either binary or decimal: ");
        }
    }
    
    public void welcomeMessage()
    {
        System.out.println("\n\nHello, and WELCOME to the number-converter!\n" +
                                   "You can use the converter to convert a number from binary to decimal or from " +
                                   "decimal to binary.");
    }
    
    public void chooseNumberToConvert(String fromType)
    {
        System.out.print("Which integer-value " + fromType + " number would you like to convert?: ");
    }
    
    
}
