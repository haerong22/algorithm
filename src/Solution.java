class Solution {

    public static void main(String[] args) {
        String s1 = "xyZA";
        String s2 = "ABCxy";
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2) {
        int cnt1 = s1.length();
        int cnt2 = s2.length();

        int loop = Math.min(cnt1, cnt2);

        for (int i = 0; i < loop; i++) {
            if (s2.startsWith(s1.substring(i))) {
                break;
            } else {
                cnt1--;
            }
        }


        for (int i = 0; i < loop; i++) {
            if (s1.startsWith(s2.substring(i))) {
                break;
            } else {
                cnt2--;
            }
        }

        String result1 = s1.concat(s2.substring(cnt1));
        String result2 = s2.concat(s1.substring(cnt2));

        if (cnt1 == cnt2){
            return result1.compareTo(result2) < 0 ? result1 : result2;
        } else if (cnt1 > cnt2) {
            return result1;
        } else {
            return result2;
        }
    }
}
