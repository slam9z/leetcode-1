// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] dp = new int[30];
        int[] plan = new int[30];

        // set the data
        for (int i = 0; i < plan.length; i++) {
            plan[i] = 0;
        }

        for (int i = 0; i < A.length; i++) {
            plan[A[i] - 1] = 1;
        }

        // dp
        for (int i = 0; i < dp.length; i++) {
            // 1 day ticket
            if (i == 0 && plan[i] == 1) {
                dp[i] = 2;
                continue;
            }

            if (i == 0 && plan[i] == 0) {
                dp[i] = 0;
                continue;
            }

            System.out.println(i-1 + " " + dp[i-1]);
            // others
            if (plan[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }

            // if == 1
            int oneDayCost = dp[i - 1] + 2;
            int sevenDayCost = 0;
            if (i - 7 >= 0) {
                sevenDayCost = dp[i - 7] + 7;
            } else {
                sevenDayCost = dp[0] + 7;
            }

            if (oneDayCost <= sevenDayCost) {
                dp[i] = oneDayCost;
            } else {
                dp[i] = sevenDayCost;
            }
        }

        if (dp[29] < 25) {
            return dp[29];
        } else {
            return 25;
        }
    }

    public static void main(String[] args) {

    }
}