/**
 * https://programmers.co.kr/
 * 신규 아이디 추천
 */

public class Algorithm1 {
    public static void main(String[] args) {
        System.out.println(solution("123_.def"));
    }

    public static String solution(String new_id) {
        String s = new_id.toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("\\.+", ".")
                .replaceAll("^[.]|[.]$","");
        if (s.equals("")) s = "a";
        if (s.length() >= 16) s = s.substring(0, 15).replaceAll("^[.]|[.]$","");
        while (s.length() <= 2) {
            s = s + s.charAt(s.length() - 1);
        }
        return s;
    }

}
