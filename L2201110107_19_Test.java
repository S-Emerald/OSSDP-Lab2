import org.junit.Test;
import static org.junit.Assert.*;

public class L2201110107_19_Test {

    /*
    * 对方法 gameOfLife进行单元测试
    * 模式描述： int[][] -> int[][]
    *
    * 对输入进行如下等价类划分：
    * int[][] board：
    * 情形1：行长度为0，列长度为0
    * 情形2：行长度为0，列长度非0
    * 情形3：行长度非0，列长度为0
    * 情形4：行长度为1，列长度为1
    * 情形5：行长度为1，列长度为大于1的整数
    * 情形6：行长度为大于1的整数，列长度为1
    * 情形7：行长度为大于1的整数，列长度为大于1的整数，行列长度不相等
    * 情形8：行长度为大于1的整数，列长度为大于1的整数，行列长度相等
    *
    * 以上划分考虑了边界情况，覆盖了所有等价类。
    * */
    //情形1：行长度为0，列长度为0
    //输入： board = [0][0]
    //预期输出：ArrayIndexOutOfBoundsException
    @Test
    public void testGameOfLifeCase1() {
        int[][] board = new int[0][0];
        Solution solution = new Solution();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            solution.gameOfLife(board);
        });
    }

    //情形2：行长度为0，列长度非0
    //输入： board = [0][5]
    //预期输出：ArrayIndexOutOfBoundsException
    @Test
    public void testGameOfLifeCase2() {
        int[][] board = new int[0][5];
        Solution solution = new Solution();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            solution.gameOfLife(board);
        });
    }

    //情形3：行长度非0，列长度为0
    //输入： board = [5][0]
    //预期输出：[5][0]
    @Test
    public void testGameOfLifeCase3() {
        int[][] board = new int[5][0];
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[5][0];
        assertArrayEquals(expected, board);
    }

    //情形4：行长度为1，列长度为1
    //输入： board = [[1]]
    //预期输出：[[0]]
    @Test
    public void testGameOfLifeCase4() {
        int[][] board = new int[1][1];
        board[0][0] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[1][1];
        expected[0][0] = 0;
        assertArrayEquals(expected, board);
    }

    //情形5：行长度为1，列长度为大于1的整数
    //输入： board = [[1,0,1,1]]
    //预期输出：[[0,0,0,0]]
    @Test
    public void testGameOfLifeCase5() {
        int[][] board = new int[1][4];
        board[0][0] = 1;
        board[0][1] = 0;
        board[0][2] = 1;
        board[0][3] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[1][4];
        expected[0][0] = 0;
        expected[0][1] = 0;
        expected[0][2] = 0;
        expected[0][3] = 0;
        assertArrayEquals(expected, board);
    }

    //情形6：行长度为大于1的整数，列长度为1
    //输入： board = [[1],[0],[1],[1]]
    //预期输出：[[0],[0],[0],[0]]
    @Test
    public void testGameOfLifeCase6() {
        int[][] board = new int[4][1];
        board[0][0] = 1;
        board[1][0] = 0;
        board[2][0] = 1;
        board[3][0] = 1;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[4][1];
        expected[0][0] = 0;
        expected[1][0] = 0;
        expected[2][0] = 0;
        expected[3][0] = 0;
        assertArrayEquals(expected, board);
    }

    //情形7：行长度为大于1的整数，列长度为大于1的整数，行列长度不相等
    //输入： board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    //预期输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    @Test
    public void testGameOfLifeCase7() {
        int[][] board = new int[4][3];
        board[0][0] = 0;
        board[0][1] = 1;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[3][0] = 0;
        board[3][1] = 0;
        board[3][2] = 0;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[4][3];
        expected[0][0] = 0;
        expected[0][1] = 0;
        expected[0][2] = 0;
        expected[1][0] = 1;
        expected[1][1] = 0;
        expected[1][2] = 1;
        expected[2][0] = 0;
        expected[2][1] = 1;
        expected[2][2] = 1;
        expected[3][0] = 0;
        expected[3][1] = 1;
        expected[3][2] = 0;
        assertArrayEquals(expected, board);
    }

    //情形7：行长度为大于1的整数，列长度为大于1的整数，行列长度相等
    //输入： board = [[1,1],[1,0]]
    //预期输出：[[1,1],[1,1]]
    @Test
    public void testGameOfLifeCase8() {
        int[][] board = new int[2][2];
        board[0][0] = 1;
        board[0][1] = 1;
        board[1][0] = 1;
        board[1][1] = 0;
        Solution solution = new Solution();
        solution.gameOfLife(board);
        int[][] expected = new int[2][2];
        expected[0][0] = 1;
        expected[0][1] = 1;
        expected[1][0] = 1;
        expected[1][1] = 1;
        assertArrayEquals(expected, board);
    }

}