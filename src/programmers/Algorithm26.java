package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/
 * 프린터
 */

public class Algorithm26 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }
        int prior = 0;
        while(queue.size() != 0) {

            prior = queue.poll();
            location -= 1;
            if(check(queue, prior)) {
                queue.offer(prior);
                if(location == -1) location = queue.size() - 1;
            } else {
                answer++;
                if(location == -1) break;
            }
        }
        return answer;
    }

    public static boolean check(Queue<Integer> queue, int prior) {
        for (Integer i : queue) {
            if(i > prior) return true;
        }
        return false;
    }
}
