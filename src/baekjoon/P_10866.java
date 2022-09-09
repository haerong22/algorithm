package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10866
 *
 * 덱
 */
public class P_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front": {
                    deque.addFirst(Integer.valueOf(st.nextToken()));
                    break;
                }
                case "push_back": {
                    deque.addLast(Integer.valueOf(st.nextToken()));
                    break;
                }
                case "pop_front": {
                    Integer first = deque.pollFirst();
                    result.append(first == null ? -1 : first).append("\n");
                    break;
                }
                case "pop_back": {
                    Integer last = deque.pollLast();
                    result.append(last == null ? -1 : last).append("\n");
                    break;
                }
                case "size": {
                    result.append(deque.size()).append("\n");
                    break;
                }
                case "empty": {
                    result.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case "front": {
                    result.append(deque.peekFirst() == null ? -1 : deque.peekFirst()).append("\n");
                    break;
                }
                case "back": {
                    result.append(deque.peekLast() == null ? -1 : deque.peekLast()).append("\n");
                    break;
                }
            }
        }

        System.out.println(result);
    }

}