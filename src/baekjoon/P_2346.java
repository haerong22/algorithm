package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2346
 *
 * 풍선 터뜨리기
 */
public class P_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            deq.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));

        while(deq.size() > 1) {
            Balloon cur = deq.poll();
            result.append(cur.idx).append(" ");
            int move = cur.num;
            if(move < 0) {
                while(move++ < 0)
                    deq.addFirst(deq.pollLast());
            } else {
                move--;
                while(move-- > 0)
                    deq.addLast(deq.pollFirst());
            }
        }

        result.append((deq.poll()).idx);

        System.out.println(result);
    }

    static class Balloon {
        int idx, num;

        Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}