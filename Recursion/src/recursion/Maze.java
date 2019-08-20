package recursion;

public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组,模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板,1表示
        map[3][1] = 1;
        map[3][2] = 1;


        //制造死路
        map[3][3] = 1;
        map[3][4] = 1;
        map[3][5] = 1;

        setWay(map,1,1);

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * map[i][j]为2时表示通路可以走,3表示该点已经走过但是走不通
     * 在走迷宫时,需要一个策略(方法)下->右->上->左,如果该点走不通,再回溯
     *
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路, 就返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { //如果当前这个点还没有走过
                //按照下->右->上->左 走
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay(map, i+1, j )) {
                    return true;
                } else if (setWay(map, i , j+1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                }else {
                    //说明该点是3
                    map[i][j]=3;
                    return false;
                }
            } else{ //如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }


}
