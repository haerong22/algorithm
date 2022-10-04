class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] numbers = {-50, 1,39, 50};
        System.out.println(solution2.solution(numbers));
    }

    private int answer = Integer.MAX_VALUE;

    private int sum1 = 0;
    private int sum2 = 0;
    private int[] numbers;

    public int solution(int[] numbers) {
        if (numbers.length == 2) {
            return Math.abs(numbers[0] - numbers[1]);
        }

        this.numbers = numbers;
        search(0);
        return answer;
    }

    private void search(int i) {

        if(i == this.numbers.length) {
            int sub = Math.abs(sum1 - sum2);
            if(sub < answer)
                answer = sub;
            return;
        }

        sum1 += this.numbers[i];
        search(i+1);
        sum1 -= this.numbers[i];

        sum2 += this.numbers[i];
        search(i+1);
        sum2 -= this.numbers[i];

    }

}
