import java.util.*;

/**
 * https://programmers.co.kr/
 * 오픈채팅방
 *
 * ...
 *
 * 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때,
 * 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
 *
 * ...
 */

public class Algorithm73 {

    public static List<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        List<String[]> messages = new ArrayList<>();
        Map<String, String> nicknames = new HashMap<>();
        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr.length == 3) {
                nicknames.put(arr[1], arr[2]);
            }
            if (!arr[0].equals("Change")) {
                messages.add(arr);
            }
        }

        String[] result = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            String[] msg = messages.get(i);
            result[i] = nicknames.get(msg[1]) + (msg[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
        }
        return result;
    }

}

