package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 * [3차] 파일명 정렬
 */

public class Algorithm122 {
    public static void main(String[] args) {

        final String[] numbers = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {

        public String[] solution(String[] files) {
            return Arrays.stream(files).sorted((a, b) -> {
                String[] parseA = parse(a);
                String[] parseB = parse(b);

                int head = parseA[0].compareTo(parseB[0]);
                if (head == 0) {
                    return Integer.compare(Integer.parseInt(parseA[1]), Integer.parseInt(parseB[1]));
                }

                return head;
            }).toArray(String[]::new);
        }

        private String[] parse(String filename) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            int idx = 0;
            for (; idx < filename.length(); idx++) {
                char c = filename.charAt(idx);
                if (c >= '0' && c <='9') break;
                head.append(c);
            }

            for (; idx < filename.length(); idx++) {
                char c = filename.charAt(idx);
                if (!(c >= '0') || !(c <='9')) break;
                number.append(c);
            }

            for (; idx < filename.length(); idx++) {
                char c = filename.charAt(idx);
                tail.append(c);
            }

            return new String[]{head.toString().toLowerCase(), number.toString(), tail.toString()};
        }
    }
}