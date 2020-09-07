package com.company;
import java.util.*; // Scanner
import java.lang.Math; // for pow() - to raise a number to the power of ...

public class Converter
{
    Scanner scanner = new Scanner(System.in);
    
    public String findToType(String fromType)
    {
        if(fromType.equalsIgnoreCase("binary"))
        {
            return "decimal";
        }
        return "binary";
    }
    public int requestDecimalNumber()
    {
        int fromNumber = 0;
        
        while(true)
        {
            try
            {
              fromNumber = scanner.nextInt();
              return fromNumber;
            }
            catch(Exception e)
            {
              System.out.print("Wrong input. You must enter an integer value: ");
              scanner.next(); // clearer scanner of old wrong input - sletter det forkerte input
              // continue;
            }
        }
    }
    
    
    // Decimal --> Binary
    public String convertNumber(int fromValue) // kunne evt. navngives toBinary
    {
        // String som returneres
        String toValue = "";
        
        // Regnet efter metoden (9:19): youtube.com/watch?v=rsxT4FfRBaM
        while(fromValue > 0)
        {
            // fordi når modulus % 2 == 1, bliver det et kommatal og så skal 1 tilføjes til toValue-stringen
            // når modulus % 2 == 0, bliver det IKKE et kommatal, og 0 skal tilføjes til toValue-stringen
            toValue = fromValue % 2 + toValue; // Denne linje kode gør det samme som if-elsen)
        }
        return toValue;
    }
    
    // Overloading method
    // Binary --> Decimal
    public int convertNumber(String fromValue) // kunne evt. navngives toDecimal
    {
        int toValue = 0;
        
        for(int i = 0; i < fromValue.length(); i++)
        {
            // converts char at index i to an int:
            int charInFromValue = Character.getNumericValue(fromValue.charAt(i)); // konverterer char til int
            
            if(charInFromValue == 1) // hvis int'en == 1
            {
                // ... ændres værdien toValue:
                // fromValue.length() - i - 1 --->: 2^antalChar - indexpladsIStringArray - 1:
                // Hvis der er 7 antal char: på index nul, skal 2 opløftes i 7 - 1: For at værdien det løftes i ændres
                // fra index til index, bliver vi nødt til at inkludere indexpladsen i ligningen, så regnestykket er:
                // længde - index - 1   ---> e.g. længde - 4 - 1  ---> 7 - 4 - 1 ----> 2
                // 1001010 ---> 2 + 8 + 64
                //      1       0          0          1       0          1       0  --> plads i binærtal
                //     2^6      2^5       2^4        2^3     2^2        2^1     2^0 --> værdi i decimal, hvis der står 1
                // (int) fordi: Math.pow() returns double
                
                toValue = (int) (Math.pow(2,(fromValue.length() - i - 1))) + toValue;
            }
        }
        return toValue;
    }
}
