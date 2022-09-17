package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1620
 * <p>
 * 나는야 포켓몬 마스터 이다솜
 */
public class P_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> index = new HashMap<>();
        String[] dic = new String[N];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            index.put(name, i);
            dic[i - 1] = name;
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            int num = toNum(question);
            if (num == -1) {
                result.append(index.get(question)).append("\n");
            } else {
                result.append(dic[num]).append("\n");
            }
        }

        System.out.println(result);
    }

    static int toNum(String s) {
        try {
            return Integer.parseInt(s) -1;
        } catch (Exception e) {
            return -1;
        }
    }
}