package Hard;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LowestCommonSeq {

	public static void LCS(String input1, String input2) 
	{
	        int M = input1.length();
	        int N = input2.length();

	        int[][] lcs = new int[M+1][N+1];

	        for (int i = M-1; i >= 0; i--) {
	            for (int j = N-1; j >= 0; j--) {
	                if (input1.charAt(i) == input2.charAt(j))
	                   { 
	                       lcs[i][j] = lcs[i+1][j+1] + 1;
	                   }
	                else 
	                  {
	                      lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
	                  }
	            }
	        }
	        int i = 0, j = 0;
	        while(i < M && j < N) {
	            if (input1.charAt(i) == input2.charAt(j)) {
	                System.out.print(input1.charAt(i));
	                i++;
	                j++;
	            }
	            else if (lcs[i+1][j] >= lcs[i][j+1]) 
	            {
	                i++;
	            }
	            else             
	            {
	                j++;
	            }
	        }
	        System.out.println();
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
	                 String[] matrix = line.split(";");
	                 if(matrix.length == 2)
	                 {
	                  LCS(matrix[0], matrix[1]);
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
}
