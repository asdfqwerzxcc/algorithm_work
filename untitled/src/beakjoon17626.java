import java.io.*;
import java.nio.Buffer;

public class beakjoon17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());

        int[] dp=new int[n+1];
        dp[1]=1;

        int min=0;
        for(int i=2; i<=n;i++){
            min=Integer.MAX_VALUE;

            for(int j =1; j*j<=i;j++){
                int temp=i-j*j;
                min=Math.min(min,dp[temp]);
            }
            dp[i]=min+1;
        }
        wr.write(dp[n]+"\n");
        wr.flush();
        wr.close();
        br.close();
    }
}
