package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 骑士周游问题
 * 1.创建棋盘chessBoard,是一个二维数组
 * 2.将当前位置设置为已经访问,然后根据当前位置,计算马儿还能走那些位置,并放入到一个集合中(ArrayList),最多有8个位置,每走一步,就是使用step+1
 * 3.遍历ArrayList中存放的所有位置,看看哪个可以走通,走通就继续,走不通就回溯
 * 4.判断马儿是否完成了任务,使用step和应该走的步数比较,如果没有达到数量,则表示没有完成任务,将整个棋盘置为0
 * <p>
 * 注意:马儿不同的走法,会得到不同的结果,效率也会有影响(优化)
 * <p>
 * 使用贪心算法队原来的算法优化:
 * 1.ArrayList<Point> ps = next(new Point(column, row));
 * 2.我们对ps中所有的Point的下一步的所有集合的数目,进行非递减排序(可能出现重复的值)
 */
public class HorseChessboard {

    private static int X; //棋盘的列数
    private static int Y; //行数
    //创建数组,标记棋盘各个位置是否被访问过
    private static boolean visited[];
    //使用一个属性,标记是否棋盘所有位置都被访问
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int[] rows : chessboard) {
            System.out.println(Arrays.toString(rows));
        }
    }

    /**
     * 完成其实周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前的位置的行,从0开始
     * @param column     马儿当前位置的列,从0开始
     * @param step       是第几步,初始位置就是第一步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //visited下标表示的是从棋盘(0,0)开始从左往右数,排在第几个
        visited[row * X + column] = true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        //对ps进行排序,排序的规则就是对ps的所有Point对象的下一步的位置的数目,进行非递减排序
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()) {
            //取出下一个可以走的位置
            Point p = ps.remove(0);
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {//说明还没被访问过
                //递归
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        //判断马儿是否完成了任务,使用step和应该走的步数比较
        // 如果没有达到数量,则表示没有完成任务,将整个棋盘置为0
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 根据当前位置(Point对象),计算马儿还能走那些位置(Point),并放入到一个集合中(ArrayList),最多有8个顶点
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿走的这个位置没有越界
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }

    /**
     * 根据当前这一步的所有的下一步的选择位置,进行非递减排序,减少回溯的次数
     * @param ps
     */
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1的下一步的所有位置个数
                int count1 = next(o1).size();
                //获取到o2的下一步的所有位置个数
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}
