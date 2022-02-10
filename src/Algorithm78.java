import java.util.*;

/**
 * https://programmers.co.kr/
 * 신고 결과 받기
 */

public class Algorithm78 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        System.out.println(Arrays.toString(solution(id_list, report, 2)));
    }

    public static class Report {
        int reportedCount = 0;
        List<String> reportList = new ArrayList<>();
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(report));

        HashMap<String, Report> map = new HashMap<>();

        for (String id : id_list) {
            map.put(id, new Report());
        }

        for (String s : set) {
            String[] split = s.split(" ");
            map.get(split[0]).reportList.add(split[1]);
            map.get(split[1]).reportedCount++;
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            for (String s : map.get(id).reportList) {
                if (map.get(s).reportedCount >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
