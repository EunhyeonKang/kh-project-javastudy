package programmers;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % 10007);

        sc.close();
    }
}