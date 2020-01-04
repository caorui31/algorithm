package raymond.project.wechat;

public class SolutionOne {

    public int getMaxS(int M[][], int row, int col) {
        // 以长宽较小的边为周长，这里提前+1是为了后面进入循环--
        int size = Math.min(row, col) + 1;

        boolean isFind = false;
        do {
            size--;
            isFind = isFindAnswer(M, row, col, size);
        } while (!isFind && size > 0);

        return isFind ? size * size : 0;
    }

    // 在当前的边长（size）下是否有符合条件的正方形
    private boolean isFindAnswer(int M[][], int row, int col, int size) {
        for(int i = 0; i <= row-size; ++i) {
            for(int j = 0;j <= col-size;++j) {
                if(isAllOne(M, i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 以startRow和startCol为起始行列，以size为周长，判断该正方形内部是否都为1
    private boolean isAllOne(int M[][], int startRow, int startCol, int size) {
        for(int i = 0;i < size;++i) {
            for(int j = 0;j < size;++j) {
                if(M[startRow + i][startCol + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        int M[][] = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,0,1}};
        SolutionOne solutionOne = new SolutionOne();

        System.out.println(solutionOne.getMaxS(M, 4, 5));
    }
}
