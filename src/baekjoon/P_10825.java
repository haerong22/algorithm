package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10825
 *
 * 국영수
 */
public class P_10825 {

    private static int N;
    private static Student[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            students[i] = new Student(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
        }

        Arrays.sort(students);

        for (Student student : students) {
            System.out.println(student.name);
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (korean != o.korean) return o.korean - korean;
            if (english != o.english) return english - o.english;
            if (math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }
}