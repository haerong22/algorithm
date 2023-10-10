package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 * [3차] 방금그곡
 */

public class Algorithm132 {
    public static void main(String[] args) {

        final String m = "ABCDEFG";
        final String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(new Solution().solution(m, musicinfos));
    }

    static class Solution {

        static class Info {
            int play;
            String title;
            String melody;

            public Info(int start, int end, String title, String melody) {
                this.play = end - start;
                this.title = title;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.play; i++) {
                    sb.append(melody.charAt(i % melody.length()));
                }

                this.melody = sb.toString();
            }
        }

        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            m = changeMelody(m);

            List<Info> infos = new ArrayList<>();

            for (String musicinfo : musicinfos) {
                String[] split = musicinfo.split(",");
                infos.add(new Info(toMinute(split[0]), toMinute(split[1]), split[2], changeMelody(split[3])));
            }

            int max = 0;

            for (Info info : infos) {
                if (info.melody.contains(m) && max < info.play) {
                    max = info.play;
                    answer = info.title;
                }
            }

            return answer;
        }

        private String changeMelody(String melody) {
            return melody
                    .replaceAll("C#", "c")
                    .replaceAll("D#", "d")
                    .replaceAll("F#", "f")
                    .replaceAll("G#", "g")
                    .replaceAll("A#", "a");
        }

        private int toMinute(String time) {
            String[] split = time.split(":");
            return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }
    }
}