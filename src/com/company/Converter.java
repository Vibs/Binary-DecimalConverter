package com.company;
import java.util.*; // Scanner
import java.lang.Math; // for pow() - to raise a number to the power of ...

public class Converter
{
    Scanner scanner = new Scanner(System.in);
    
    public int requestDecNum() // DONE
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
    
    public String requestBinNum() // DONE
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
    public String convertPosDec(int decNum) // DONE
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
    
    // NEG Decimal --> Binary
    public String convertNegDec(int decNum) // DONE
    {
        int decNumInPos = decNum - (2 * decNum); // finder tallets positive værdi
        
        String binNumPos = convertPosDec(decNumInPos); // finder det binære tal for positiv værdi (decNumInPos)
        
        String reversedBinNumPos = reverseBinNum(binNumPos); // omvender alle 0 --> 1 og 1 --> 0
        
        return add1ToBinNum(reversedBinNumPos); // tilføjer 1 til resultatet og returnerer
    }
    
    // POS Binary --> Decimal
    public int convertPosBin(String binNum) // DONE
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
    public int convertNegBin(String binNum) // DONE
    {
        // int decNum = 0;
        
        String reversedBinNum = reverseBinNum(binNum); // reverser det binære tal
        
        String posBinNum = 0 + add1ToBinNum(reversedBinNum); // adder 1 == finder posBinNum OG + 0 fordi positivt tal
        
        int posDecNum = convertPosBin(posBinNum); // konverter posBinNum til posDecNum
    
        System.out.println(posDecNum - posDecNum - posDecNum);
        
        return posDecNum - posDecNum - posDecNum; // omvender positiv decNum-værdi til negativ decNum-værdi
    }
    
    public String reverseBinNum(String binNum) // DONE
    {
        String reversedBinNum = "";
        
        int stringLength = binNum.length();
        
        for(int i = 0; i < stringLength; i++) // 0 --> 1  OG  1 --> 0
        {
            // TODO overvej at tilføje StringBuilder i stedet
            reversedBinNum += ((binNum.charAt(i) + 1) % 2); // omvernder værdien der findes på binNum.charAt(i)
            
            /* Der står det samme her
            if(binNum.charAt(i) == '1') // hvis
            {
                reversedBinNum += 0;
            }
            else // if(binNum.charAt(i) == '0')
            {
                reversedBinNum += 1; //
            }
            */
        }
        return reversedBinNum;
    }
    
    public String add1ToBinNum(String binNum) // DONE
    {
        // System.out.println("TEST 2: " + binNum);
        String updatedBinNum = "";
        int stringLength = binNum.length();
        
        int carryOver = 1; // startværdi 1 fordi vi skal plusse med 1
        
        for(int i = stringLength - 1; i >= 0; i--) // starter på bagerste tal
        {
            int addition = Character.getNumericValue(binNum.charAt(i)) + carryOver; // finder ud af om der er en ny
            // carryover + parser char til int
            
            if(addition > 1) // så skal der stadig være 1 carryover og så skal loopet køres igen
            {
                updatedBinNum = 0 + updatedBinNum;
            }
            else
            {
                if(addition == 1) // result giver
                {
                    updatedBinNum = 1 + updatedBinNum;
                }
                updatedBinNum = binNum.substring(0, i) + updatedBinNum;
                break; // fra for-loop
            }
        }
        return updatedBinNum;
    }
    
}
