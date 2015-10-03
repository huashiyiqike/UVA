import javax.security.auth.login.AccountException;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {

//        FileInputStream fis = null;
//        FileOutputStream fout = null;
//        try {
//            fis = new FileInputStream("/Users/lq/leetcode/UVA/1.txt");
//            fout = new FileOutputStream("/Users/lq/leetcode/UVA/2.txt");
//
//        }catch(Exception e){
//            System.out.println(e);
//
//        }
//        Scanner cin = new Scanner(fis);
//        PrintStream ps=new PrintStream(fout);
//        System.setOut(ps);

        Scanner cin = new Scanner(System.in);

        float[] drop = new float[101];
        while(true){
            int duration = cin.nextInt();
            float downpay = cin.nextFloat(), owe = cin.nextFloat(), value = owe + downpay;
            if(duration < 0) break;
            downpay = owe/duration;
            int times = cin.nextInt();
            Arrays.fill(drop, 0.0f);
            for(int i = 0; i < times; i++){
                drop[cin.nextInt()] = cin.nextFloat();
            }
            int i = 0;
            for(; i < 101; i++){
                if(i >0 && drop[i] == 0) drop[i] = drop[i-1];
                value *= (1.0f - drop[i]);
                if(value > owe) break;
                owe -= downpay;
              //  System.out.println(owe + " "+ value);
            }
            System.out.println(i + (i==1?" month":" months"));
        }
        cin.close();
       // ps.close();
    }
}
