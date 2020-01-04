package raymond.project.leetcode;


public class S79 {

    char[][] board;
    boolean[][] visited;
    int row;
    int col;
    String word;
    int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        this.word = word;
        this.board = board;

        for(int i = 0;i < row;++i) {
            for(int j = 0;j < col;++j) {
                if(dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // i,j 为格子的位置，pos为word的当前下表
    public boolean dfs(int i, int j, int pos) {
        if(pos == word.length() - 1) {
            return board[i][j] == word.charAt(pos);
        }

        if(board[i][j] != word.charAt(pos)) {
            return false;
        }

        visited[i][j] = true;

        // 4个方向
        for(int k = 0;k < 4;++k) {
            int newI = i + direction[k][0];
            int newJ = j + direction[k][1];
            // 判断下一个方向的点是否还在二维数组内
            if(!inArea(newI, newJ)) {
                continue;
            }
            // 如果访问过了就不能再访问了
            if(visited[newI][newJ]) {
                continue;
            }
            if(dfs(newI, newJ, pos+1)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) throws Exception{
        S79 s = new S79();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(board, "ABCCED"));
    }
}
