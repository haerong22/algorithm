package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 *
 * 프린터 큐
 */
public class P_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        Queue<Integer> priority;
        Queue<Integer> index;
        StringTokenizer st;
        int document;
        int target;

        for (int i = 0; i < testcase; i++) {

            priority = new ArrayDeque<>();
            index = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            document = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < document; j++) {
                priority.add(Integer.parseInt(st.nextToken()));
                index.add(j);
            }

            int count = 1;

            while (!priority.isEmpty()) {

                int max = priority.stream().reduce((a, b) -> a > b ? a : b).get();
                int curr = priority.poll();
                int idx = index.poll();

                if (curr == max) {

                    if (target == idx) {
                        result.append(count).append("\n");
                        break;
                    }

                    count++;

                } else {
                    priority.add(curr);
                    index.add(idx);
                }
            }
        }

        System.out.println(result);
    }
}