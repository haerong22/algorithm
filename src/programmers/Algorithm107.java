package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * 과제 진행하기
 */

public class Algorithm107 {
    public static void main(String[] args) {

        final String[][] plans = {
//                {"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}
//                {"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}
                {"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}
        };

        System.out.println(Arrays.toString(new Solution().solution(plans)));
    }

    static class Solution {
        private static class Task {

            String name;
            int time;

            public Task(String name, int time) {
                this.name = name;
                this.time = time;
            }
        }

        public String[] solution(String[][] plans) {
            String[] answer = new String[plans.length];
            Arrays.sort(plans, Comparator.comparing(o -> o[1]));

            Stack<Task> tasks = new Stack<>();

            int prevTime = 0;
            int answerIndex = 0;

            for (String[] plan : plans) {
                int startTime = stringToTime(plan[1]);
                int workingTime = stringToTime(plan[2]);

                while (!tasks.empty()) {
                    Task prevTask = tasks.peek();
                    int endTime = prevTime + prevTask.time;

                    if (endTime <= startTime) {
                        answer[answerIndex++] = tasks.pop().name;
                        prevTime += prevTask.time;
                    } else {
                        prevTask.time = prevTask.time - (startTime - prevTime);
                        break;
                    }
                }
                tasks.push(new Task(plan[0], workingTime));
                prevTime = startTime;
            }

            while (!tasks.empty()) {
                answer[answerIndex++] = tasks.pop().name;
            }

            return answer;
        }

        private static int stringToTime(String str) {
            String[] temp = str.split(":");
            int result;
            if (temp.length == 2) {
                result = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            } else {
                result = Integer.parseInt(str);
            }
            return result;
        }
    }
}