package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18258
 *
 * 큐 2
 */
public class P_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();

            switch (operator) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    result.append(queue.pop()).append("\n");
                    break;
                case "size":
                    result.append(queue.size()).append("\n");
                    break;
                case "empty":
                    result.append(queue.empty()).append("\n");
                    break;
                case "front":
                    result.append(queue.front()).append("\n");
                    break;
                default:
                    result.append(queue.back()).append("\n");
                    break;
            }
        }

        System.out.println(result);
    }

    static class Queue {

        private final int[] arr;
        private int front = 0;
        private int back = 0;

        Queue(int N) {
            this.arr = new int[N];
        }

        void push(int x) {
            arr[back++] = x;
        }

        int pop() {
            if (front == back) return -1;

            return arr[front++];
        }

        int size() {
            return back - front;
        }

        int empty() {
            return front == back ? 1 : 0;
        }

        int front() {
            if (front == back) return -1;

            return arr[front];
        }

        int back() {
            if (front == back) return -1;

            return arr[back - 1];
        }
    }

}