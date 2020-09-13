package com.company;
import java.sql.SQLOutput;
import java.util.*; // Scanner
import java.lang.Math; // for pow() - to raise a number to the power of ...

public class Converter
{
    Scanner scanner = new Scanner(System.in);
    
    public int requestDecNum()
    {
        int decNum = 0;
        
        while(true) // fortsæt så længe brugen indtaster forkert
        {
            try
            {
                decNum = scanner.nextInt();
              return decNum;
            }
            catch(Exception e)
            {
              System.out.print("\t\tOOPS, wrong input.\nYou must enter an integer value: ");
              scanner.next(); // clearer scanner of old wrong input - sletter det forkerte input
            }
        }
    }
    
    public String requestBinNum()
    {
        while(true) // hopper ud, hvis brugeren har indtastet korrekt binært tal
        {
            String binNum = scanner.nextLine();
    
            int stringLength = binNum.length();
    
            for(int i = 0; i < stringLength; i++) // checker hver char
            {
                if(binNum.charAt(i) == '0' || binNum.charAt(i) == '1')
                {
                    if(i == stringLength - 1) // if sidste char i binNum er 0 || 1 == hele tallet godkendt som binær
                    {
                        return binNum;
                    }
                }
                else
                {
                    System.out.print("\t\tOOPS, wrong input.\nYou have to enter a valid binary number," +
                            " consisting of only 0's and 1's.\nPlease enter a valid binary number: ");
                    break; // fra loopet, og indtast binNum igen
                }
            }
        }
    }
    
    // POS Decimal --> Binary
    public String convertPosDec(int decNum) // kunne evt. navngives toBinary
    {
        // Binær-String som returneres
        String binNum = "";
        
        // Regnet efter metoden (9:19): youtube.com/watch?v=rsxT4FfRBaM
        while(decNum > 0)
        {
            // fordi når modulus % 2 == 1, bliver det et kommatal og så skal 1 tilføjes til binNum-stringen
            // når modulus % 2 == 0, bliver det IKKE et kommatal, og 0 skal tilføjes til binNum-stringen
            binNum = decNum % 2 + binNum;
            decNum/=2; // decNum = decNum/2;
        }
        binNum = "0" + binNum; // sikrer at tallet fortolkes som et positivt binært tal, ved at 0 står forrest
        return binNum;
    }
    
    // POS Binary --> Decimal
    public int convertPosBin(String binNum) // kunne evt. navngives toDecimal
    {
        int decNum = 0; // defineres i dette scope, fordi den returneres i dette scope
        
        int stringLength = binNum.length(); // så vi kan bruge variablen stringLength i stedet for at lave
        // udregningen binNum.length() flere gange
        
        for(int i = 0; i < stringLength; i++) // fordi den skal køre igennem hvert ciffer i binNum
        {
            // converts char at index i to an int:
            int charInFromValue = Character.getNumericValue(binNum.charAt(i));
            
            if(charInFromValue == 1) // hvis int'en == 1, skal vi plusse noget til decNum
            {
                // ... ændres værdien toValue:
                // fromValue.length() - i - 1 --->: 2^antalChar - indexpladsIStringArray - 1:
                // Hvis der er 7 antal char: på index nul, skal 2 opløftes i 7 - 1: Altså én mindre en indexpladsen.
                // Derfor: For at ændre værdien det løftes op i fra index til index, bliver vi nødt til at inkludere
                // indexpladsen i ligningen, så regnestykket er:
                // længde - index - 1   ---> e.g. længde - 4 - 1  ---> 7 - 4 - 1 ----> 2
                // 1001010 ---> 2 + 8 + 64
                //      1       0          0          1       0          1       0  --> plads i binærtal
                //     2^6      2^5       2^4        2^3     2^2        2^1     2^0 --> værdi i decimal, hvis der står 1
                // (int) fordi: Math.pow() returns double
    
                decNum += (int) (Math.pow(2,(stringLength - i - 1)));
            }
        }
        return decNum;
    }
    
    // NEG Decimal --> Binary
    public String convertNegDec(int decNum)
    {
        String binNum = "";
        
        
        return binNum;
    }
    
    // NEG Decimal --> Binary
    public int convertNegBin(String binNum) // TODO
    {
        int decNum = 0;
        
        
        return decNum;
    }
}
