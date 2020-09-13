package com.company; // hvorfor skal der stå det?

import java.util.*; // Scanner,

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Print print = new Print();
        Converter converter = new Converter();
    
        // System.out.println((charAt(i) + 1) % 2);
        
        print.welcomeMessage();
        
        // gemmer typen de vil convertere FRA
	    String fromType = print.findFromType();
	    
	    print.chooseNumberToConvert(fromType);
	    
	    // få værdien de vil converte i int
        if(fromType.equalsIgnoreCase("decimal"))
        {
            int decNum = converter.requestDecNum(); // metode håndterer wrong input
            
            if(decNum >= 0) // if positiv: convertPosDec
            {
                System.out.println("The decimal number " + decNum + " is: " + converter.convertPosDec(decNum)
                                           + " in binary.");
            }
            else // if negativ: convertNegDec
            {
                System.out.println("The decimal number " + decNum + " is: " + converter.convertNegDec(decNum)
                                           + " in binary.");
            }
        }
        
        else // if(fromType.equalsIgnoreCase("binary"))
        {
            String binNum = converter.requestBinNum(); // metode håndterer wrong input
            
            if(binNum.charAt(0) == '0') // if positiv: convertPosBin
            {
                System.out.println("\nThe binary number " + binNum + " is: " + converter.convertPosBin(binNum) +
                                           " in decimal.");
            }
            else // if(binNum.charAt(0) == '1') // if negativ: convertNegBin
            {
                System.out.println("\nThe binary number " + binNum + " is: " + converter.convertNegBin(binNum) +
                                           " in decimal.");
            }
        }
    
	    // convert int-værdien til en String
        // String fromNumberString = Integer.toString(fromNumberInt); // JEG ER IKKE SIKKER PÅ AT DENNE ER NØDVENDIG

        
    }
}
