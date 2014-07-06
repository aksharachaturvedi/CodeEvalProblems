package Moderate;
import java.io.*;

public class ReverseAdd {

      public static void main(String []args){
     try{
        if(args.length > 0) {
        FileInputStream fstream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader   (fstream));
            String line=null;
            while ((line = br.readLine()) != null)   {
            System.out.println(PalindromeSum(Long.parseLong(line)));
        }
         fstream.close();
        }
      }
      catch(Exception ex){
      System.out.println(ex.getMessage());
      }       
     }
     
     public static String PalindromeSum(long number){
    	if(number < 1) return " "; 
		long rev = ReverseNumber(number), i=1, 
          sum= number+rev;
		while(!Palindrome(sum)) {		
			number = sum;
			rev = ReverseNumber(number);
            sum += rev;
			i++;
		}

		return (i +" "+ sum).toString();
	}
	
	private  static long ReverseNumber(long number)
	{
		long rev =0;
		while(number != 0 )
		{
		 rev = rev * 10 + number % 10;
		 number/=10;
		}
		return rev;
	}
	private static Boolean Palindrome(long number)
	{
		long div =1; 
		while(number / div >=10){
			div *= 10;
		}
		while(number !=0){
			long l = number/div;
			long r = number % 10;
			if(l!=r) return false;
			number = (number % div) /10;
			div /=100; 
		}
		return true;
	}
}