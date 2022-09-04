package programmers;

/**
 * https://programmers.co.kr/
 * 점프와 순간 이동
 */

public class Algorithm79 {

    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
