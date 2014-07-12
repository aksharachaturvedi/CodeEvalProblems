package Moderate.PrimeNumber;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Print prime numbers less than N
* */
public class PrimeNumbers {

    protected static void PrimeNumber(Integer number) {
        if(number < Integer.MAX_VALUE&& number  > Integer.MIN_VALUE) {
            Boolean[] isPrime = new Boolean[number];
            StringBuilder primenumber = new StringBuilder();
            for (int count = 2; count < number; count++) {
                isPrime[count] = true;
            }

            for (int i = 2; i * i < number; i++) {
                if (isPrime[i]) {
                    for (int j = i; j * i < number; j++)
                        isPrime[i * j] = false;
                }
            }
            for (int count = 2; count < isPrime.length; count++) {
                int i = 1;
                if (isPrime[count]) {
                    System.out.print(count + ",");
                    primenumber.append(count);
                    primenumber.append(",");
                }
            }
            for (int count = 0; count < primenumber.length() - 1; count++) {
                System.out.print(primenumber.charAt(count));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try
        {
            if(args.length > 0) {
                FileInputStream fstream = new FileInputStream(args[0]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String line=null;
                while ((line = br.readLine()) != null)   {
                    if(line !=null || line!= " "){
                        Integer value = Integer.valueOf(line);
                        PrimeNumber(value);
                    }
                }
                fstream.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
