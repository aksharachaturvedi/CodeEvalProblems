package Easy.FizzBuzz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args) {
        try{
            if(args.length > 0) {
                FileInputStream fstream = new FileInputStream(args[0]);
                BufferedReader br = new BufferedReader(new InputStreamReader   (fstream));
                String line=null;
                while ((line = br.readLine()) != null)
                {
                    if(line !=null || line!= " "){
                        String[] matrix = line.split(" ");
                        if(matrix.length == 3)
                        {
                            int a = Integer.parseInt(matrix[0]);
                            int b = Integer.parseInt(matrix[1]);
                            int n = Integer.parseInt(matrix[2]);

                            FizzBuzz(a, b, n); // matrix[1], matrix[2]);
                            System.out.println();

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

    public static Boolean isDivisible(int x, int y)
    {
        return x%y == 0;
    }

    public static void FizzBuzz(int a, int b, int n)
    {
        final StringBuilder resultBuilder = new StringBuilder();

        Boolean num1=false, num2=false;
        for(int count = 1 ; count <= n; count++)
        {
            num1 = isDivisible(count, a);
            num2 = isDivisible(count, b);
            if (num1 && num2) {
                resultBuilder.append("FB");
            } else if (num1) {
                resultBuilder.append("F");
            } else if (num2) {
                resultBuilder.append("B");
            } else {
                resultBuilder.append(count);
            }
            if (count < n) {
                resultBuilder.append(" ");
            }
        }
        System.out.println(resultBuilder.toString());
    }
}