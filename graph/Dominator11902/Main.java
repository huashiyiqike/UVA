import java.io.*;
import java.util.*;

public class Main {

    static int[][] tmpgraph = new int[101][101];
    static boolean[] vis = new boolean[101];

    static void dfs(int node, int num) {
        if (vis[node]) return;
        vis[node] = true;
        for (int i = 0; i < num; i++) {
            if (tmpgraph[node][i] == 1) dfs(i, num);
        }
    }

    public static void main(String[] args) throws IOException {
        int _testin = 0, _testout = 0;
        FileInputStream fis = null;
        FileOutputStream fout = null;
        Scanner cin = null;
        PrintStream ps = null;
        if (_testin == 1) {
            try {
                fis = new FileInputStream("/Users/lq/leetcode/UVA/1.txt");
                if (_testout == 1) {
                    fout = new FileOutputStream("/Users/lq/leetcode/UVA/3.txt");
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

        char[][] dominate = new char[101][101];
        int[][] graph = new int[101][101];

        int cases = cin.nextInt();
        for (int cas = 1; cas <= cases; cas++) {
            int num = cin.nextInt();

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    graph[i][j] = cin.nextInt();
                    if (i == j) dominate[i][j] = 'Y';
                    else dominate[i][j] = 'N';
                }
            }

            for (int node = 0; node < num; node++) {
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        if (i == node || j == node) {
                            tmpgraph[i][j] = 0;
                        } else tmpgraph[i][j] = graph[i][j];
                    }
                }
                Arrays.fill(vis, false);
                dfs(0, num);
                for (int i = 0; i < num; i++) {
                    if (!vis[i]) dominate[node][i] = 'Y';
                }
            }
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    tmpgraph[i][j] = graph[i][j];
                }
            }
            Arrays.fill(vis, false);
            dfs(0, num);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (!vis[i] || !vis[j]) {
                        dominate[i][j] = 'N';
                    }
                }
            }

            System.out.println("Case " + cas);
            outliner(num);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print("|" + dominate[i][j]);
                }
                System.out.println("|");
                outliner(num);
            }
        }
    }

    static void outliner(int num) {
        for (int i = 0; i < num; i++) {
            if (i == 0) System.out.print("+-");
            else System.out.print("--");
        }
        System.out.println("+");
    }
}