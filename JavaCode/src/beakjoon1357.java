import java.io.*;
import java.util.StringTokenizer;

public class beakjoon1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int x= Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());

        wr.write(Rex(Rex(x)+Rex(y))+"");
        wr.flush();
        wr.close();
        br.close();

    }
    static int Rex(int num){
        StringBuilder sb= new StringBuilder(num+"");
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
