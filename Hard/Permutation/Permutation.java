package Hard.Hard.Permutation;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
STRING PERMUTATIONS

* O/P
*
* aht,ath,hat,hta,tah,tha
* abc,acb,bac,bca,cab,cba
* 6Zu,6uZ,Z6u,Zu6,u6Z,uZ6
* */
public class Permutation {

    public static ArrayList<String> permutations = new ArrayList<String>();
    public static void Permutations(String input) {
         Permutations("", input);
    }

    private static void Permutations(String prefix, String s) {
        int len = s.length();
        StringBuilder sb= new StringBuilder();
        if (len == 0) {
            permutations.add(prefix);
            permutations.add(",");
        }
        else {
            for (int i = 0; i < len; i++)
               Permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len));
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                FileInputStream fstream = new FileInputStream(args[0]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line != null || line != " ") {
                        char[] sortedAry = line.toCharArray();
                        Arrays.sort(sortedAry);
                        String sortedline = String.valueOf(sortedAry);
                        permutations.clear();
                        Permutations(sortedline);
                        for(int i=0; i <permutations.size()-1;i++)
                            System.out.print(permutations.get(i));
                        System.out.println();
                    }
                }
                fstream.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
