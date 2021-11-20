import java.util.ArrayList;
import java.util.Collections;

/**
 * https://programmers.co.kr/
 * 뉴스 클러스터링
 *
 * 입력 형식
 *   - 입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
 *   - 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고,
 *     기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
 *     예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
 *   - 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
 * 출력 형식
 *   - 입력으로 들어온 두 문자열의 자카드 유사도를 출력한다. 유사도 값은 0에서 1 사이의 실수이므로,
 *     이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.
 */

public class Algorithm76 {

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        ArrayList<String> list1 = getList(str1);
        ArrayList<String> list2 = getList(str2);
        double jaccard = getJaccard(list1, list2);
        return (int) (jaccard * 65536);
    }

    private static double getJaccard(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        union.addAll(list2);

        return union .size() == 0 ? 1 :((double) intersection.size()) / union.size();
    }

    private static ArrayList<String> getList(String str) {
        ArrayList<String> list = new ArrayList<>();
        String lowercase = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String substring = lowercase.substring(i, i + 2);
            if (substring.matches("^[a-z]{2}$")) {
                list.add(substring);
            }
        }
        Collections.sort(list);
        return list;
    }
}

