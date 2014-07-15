package Hard.Hard.EggDroping;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *   Let P(n,h)
 *   n eggs and
 *   height h.
 *   Then dropping 1 egg from some height x (1<=x<=h) has two possible effects:
 *   a) if it breaks, then the problem becomes P(n-1,x-1):
 *     You lost 1 egg and must test all the heights below x.
 *   b) if it does not break, the problem becomes P(n, h-x):
 *     you lost no egg but must test all the heights above x.
 *
 *     Use brute force: try all heights from 1
 *   to h, then pick the one which gives the minimum worst case drops:
 *
 *     for(int x=1; x<h; x++)
 *       best = Math.min(best, Math.max(P(n-1,x-1),P(n,h-x)))
 */
public class EggDroping {

    public static int TrialsEggDroping(int totalegg, int floors) {
        int[][] trials = new int[totalegg + 1][floors + 1];
        int best, eggcount, htcount, x;

        // We need 1 trial for 1 floor and 0 trials for 0 floors
        for (eggcount = 1; eggcount <= totalegg; eggcount++) {
            trials[eggcount][1] = 1;
            trials[eggcount][0] = 0;
        }

        // we have to try all the floors if we have one egg
        if (totalegg > 0) {
            for (htcount = 1; htcount <= floors; htcount++)
                trials[1][htcount] = htcount;
        }

        for (eggcount = 2; eggcount <= totalegg; eggcount++) {
            for (htcount = 2; htcount <= floors; htcount++) {
                trials[eggcount][htcount] = Integer.MAX_VALUE; //set the value to infinity
                for (x = 1; x <= htcount; x++) {
                    best = 1 + Math.max(trials[eggcount - 1][x - 1], trials[eggcount][htcount - x]);
                    if (best < trials[eggcount][htcount])
                        trials[eggcount][htcount] = best;
                }
            }
        }
        return trials[totalegg][floors];
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                FileInputStream fstream = new FileInputStream(args[0]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line != null || line != " ") {
                        String[] str = line.split(" ");
                        System.out.println(TrialsEggDroping(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
                    }
                }
                fstream.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
