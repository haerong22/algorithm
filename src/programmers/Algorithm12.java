package programmers;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * https://programmers.co.kr/
 * 올바른 신용카드 번호 검색하기
 *
 * 신용 카드 번호들이 담긴 문자열 배열 card_numbers가 주어질 때,
 * 각 카드 번호가 올바르면 1, 올바르지 않으면 0으로 표시한 배열을 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm12 {
    public static void main(String[] args) {
        String[] a = {"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"};
        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(String[] card_numbers) {
        int[] result = new int[card_numbers.length];
        for(int i=0; i<card_numbers.length; i++) {
            boolean regex1 = Pattern.matches("^[0-9]*$", card_numbers[i]);
            boolean regex2 = Pattern.matches("^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}", card_numbers[i]);
            int[] arr = null;
            if(regex1 || regex2) {
                arr = card_numbers[i].chars().filter(v -> v != '-').map(Character::getNumericValue).toArray();
                if(arr.length != 16) {
                    result[i] = 0;
                } else {
                    int a = 0;
                    int b = 0;
                    int temp = 0;
                    for(int j=0; j<arr.length; j++) {
                        if(j % 2 == 0) {
                            temp = arr[j] * 2;
                            if(temp > 9) {
                                temp = temp % 10 + (int) temp/10;
                            }
                            a += temp;
                        } else {
                            b += arr[j];
                        }
                    }
                    if((a + b) % 10 == 0) {
                        result[i] = 1;
                    } else {
                        result[i] = 0;
                    }
                }
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
