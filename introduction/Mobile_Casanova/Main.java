import java.io.*;
import java.util.*;

/**
 * Created by lq on 15/10/2.
 */
public class Main{
    public static void main(String[] args) {
        int _testin = 0, _testout = 0;
        Scanner cin = null;PrintStream ps = null;
        if (_testin == 1) {
            FileInputStream fis = null;
            FileOutputStream fout = null;
            try {
                fis = new FileInputStream("/Users/lq/leetcode/UVA/1.txt");
                fout = new FileOutputStream("/Users/lq/leetcode/UVA/2.txt");
                if(_testout == 1) {
                    ps = new PrintStream(fout);
                    System.setOut(ps);
                }
            } catch (Exception e) {
                System.out.println(e);

            }
            cin = new Scanner(fis);
        } else {
            cin = new Scanner(System.in);
        }



        int num, total = 1;
        long numbers[] = new long[100001];
        while (true) {
            num = cin.nextInt();
            if (num == 0) break;
            if(total > 1)
                System.out.println("");
            System.out.println("Case "+ total++ +":");
            for (int i = 0; i < num; i++) {
                numbers[i] = Long.parseLong(cin.next());
            }
            int first = 0;
            while (first < num) {
                int last = first;
                while (last + 1 < num) {
                    if (numbers[last + 1] == numbers[last] + 1)
                        last++;
                    else break;
                }
                if (first == last) {
                    System.out.println("0" + numbers[first]);
                    first++;
                    continue;
                }
                String res = "0", firststr = "" + numbers[first], laststr = "" + numbers[last];
                if (firststr.length() == laststr.length()) {
                    int i = 0;
                    for (; i < firststr.length(); i++) {
                        if (firststr.charAt(i) == laststr.charAt(i)) res += firststr.charAt(i);
                        else break;
                    }
                    if (i != firststr.length()) {
                        res += firststr.substring(i, firststr.length());
                        res += "-";
                        res += laststr.substring(i, firststr.length());
                    }
                    System.out.println(res);
                } else {
                    System.out.println(res + firststr + "-" + laststr);
                }
                first = last+1;
            }
        }
        System.out.println("");
        cin.close();
        if(_testin == 1 && _testout == 1){ps.close();}
    }
}
