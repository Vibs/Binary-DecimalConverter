package com.company; // hvorfor skal der stå det?

import java.util.*; // Scanner,

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Print print = new Print();
        Converter converter = new Converter();
        
        print.welcomeMessage();
        
        // gemmer typen de vil convertere FRA
	    String fromType = print.findFromType();
	    
	    print.chooseNumberToConvert(fromType);
	    
	    // få værdien de vil converte i int
        if(fromType.equalsIgnoreCase("decimal"))
        {
            int decNum = converter.requestDecNum();
            
            if(decNum >= 0) // if positiv: Brug metode til positive tal
            {
                System.out.println("The decimal number: " + decNum + " is: " + converter.convertPosDec(decNum)
                                           + " in binary.");
            }
            else // if negativ: brug metode for negative tal
            {
                System.out.println("The decimal number: " + decNum + " is: " + converter.convertNegativeDecimal(decNum)
                                           + " in binary.");
            }
        }
        
        else // if(fromType.equalsIgnoreCase("binary"))
        {
            String binNum = scanner.nextLine();
            
            //if()
            
            System.out.println("\nThe binary number, " + binNum + ", is: " + converter.convertPosBin(binNum) +
                                       " in decimal.");
        }
    
	    // convert int-værdien til en String
        // String fromNumberString = Integer.toString(fromNumberInt); // JEG ER IKKE SIKKER PÅ AT DENNE ER NØDVENDIG

        
    }
}
