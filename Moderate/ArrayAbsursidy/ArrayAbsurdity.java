package Moderate;
import java.io.*;

public class ArrayAbsurdity {
    public static void main(String[] args) {
        try{
        if(args.length > 0) {
        FileInputStream fstream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader   (fstream));
            String line=null;
            while ((line = br.readLine()) != null)
            {
                if(line !=null || line!= " "){
                 String[] matrix = line.split(";");
                 if(matrix.length ==2)
                 {
                    int n = Integer.parseInt(matrix[0]);
                    String[] c =matrix[1].trim().split(",");
                    System.out.println(ArrayAbsurdityFun(n, c)); 
                 }
                }
            }
         fstream.close();
        }
      }
      catch(Exception ex){
      System.out.println(ex.getMessage());
      }
    }
    
    public static int ArrayAbsurdityFun(int n, String[] b)
    {
        int sum=0;
        for(String c : b)       
        {
         sum = sum+ Integer.parseInt(c);
        }
    int expected= (n-1)*(n-2)/2;  
    return Math.abs(expected - sum);
    }
}
