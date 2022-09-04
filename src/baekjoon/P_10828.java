package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 *
 * 스택
 */
public class P_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String action = st.nextToken();

            switch (action) {
                case "push": stack.push(Integer.parseInt(st.nextToken())); break;
                case "pop": result.append(stack.pop()).append("\n"); break;
                case "size": result.append(stack.size()).append("\n"); break;
                case "empty": result.append(stack.empty()).append("\n"); break;
                case "top": result.append(stack.top()).append("\n"); break;
            }

        }

        System.out.println(result);
    }
}

class Stack {
    private final int[] arr;
    private int index;

    public Stack(int size) {
        this.arr = new int[size];
        this.index = 0;
    }

    public void push(int x) {
        arr[index] = x;
        index++;
    }

    public int pop() {
        if (index == 0) return -1;

        int pop = arr[--index];
        arr[index] = 0;

        return pop;
    }

    public int size() {
        return index;
    }

    public int empty() {
        return index == 0 ? 1 : 0;
    }

    public int top() {
        return index == 0 ? -1 : arr[index - 1];
    }
}
