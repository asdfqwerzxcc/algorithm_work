import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon22966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min= 5;
        String answer="";

        for(int i =0; i<n;i++){

            StringTokenizer st= new StringTokenizer(br.readLine());
            String s= st.nextToken();

            int a=Integer.parseInt(st.nextToken());

            if(a<min){
                min=a;
                answer=s;
            }
        }
//        while(n-->0){
//            StringTokenizer st= new StringTokenizer(br.readLine());
//            String s= st.nextToken();
//            int a= Integer.parseInt(st.nextToken());
//
//            if( a<min){
//                min=a;
//                answer=s;
//
//            }
//        }
        System.out.println(answer);
    }
}
