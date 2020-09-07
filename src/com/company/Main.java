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
        
        // gemmer typen de vil converte FRA
	    String fromType = print.findFromType();
	    // gemmer typen de vil converte TIL
	    String toType = converter.findToType(fromType);
	    
	    print.chooseNumberToConvert(fromType);
	    
	    // få værdien de vil converte i int
        if(fromType.equalsIgnoreCase("decimal"))
        {
            int fromNumberInt = converter.requestDecimalNumber();
            System.out.println("The decimal number: " + fromNumberInt + " is: " + converter.convertNumber(fromNumberInt) + " in binary.");
        }
        else if(fromType.equalsIgnoreCase("binary"))
        {
            String fromNumberString = scanner.nextLine();
            System.out.println("\nThe binary number: " + fromNumberString + " is: " + converter.convertNumber(fromNumberString) + " in decimal.");
        }
    
	    // convert int-værdien til en String
        // String fromNumberString = Integer.toString(fromNumberInt); // JEG ER IKKE SIKKER PÅ AT DENNE ER NØDVENDIG

        
    }
}
