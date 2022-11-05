public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int[][] board = {
                {-10, 20, 30},
                {-10, 0, 10},
                {-20, 40, 1},
        };

        System.out.println(solution3.solution(board));
    }

    private int maxScore = Integer.MIN_VALUE;
    private int[][] board;

    public int solution (int[][] board) {
        this.board = board;
        search(0, 0, board[0][0]);
        return maxScore;
    }

    private void search(int x, int y, int currScore) {

        boolean xCond = x < board.length-1;
        boolean yCond = y < board[0].length-1;

        if(!xCond && !yCond) {
            if(maxScore < currScore)
                this.maxScore = currScore;

            return;
        }

        if(xCond) {
            int nextScore = board[x+1][y];

            if (nextScore == 0) {
                search(x+1, y, currScore * -1);
            }
            search(x+1, y, currScore + nextScore);
        }

        if(yCond) {
            int nextScore = board[x][y+1];

            if (nextScore == 0) {
                search(x, y+1, currScore * -1);
            }
            search(x, y+1, currScore + nextScore);
        }
    }

}