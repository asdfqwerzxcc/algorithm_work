import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class baekjoon10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        int arr[] = new int[26];
        for (int i=0;i<26;i++){
            arr[i]=-1;
        }
        for (int i=0; i< a.length();i++){
            char ch=a.charAt(i);

            if(arr[ch-'a']==-1){
                arr[ch-'a']=i;
            }
        }
        for (int var:arr){
            System.out.print(var+" ");
        }

    }
}
