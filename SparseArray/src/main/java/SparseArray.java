public class SparseArray {
    public static void main(String[] args) {
//        创建一个二维数组作为棋盘
//        初始化棋盘
//        白棋用1表示，黑棋用2表示
//        int chess[][] = new int[11][11];
//        chess[1][2] = 1 ;
//        chess[2][2] = 1 ;
//        chess[2][3] = 2 ;
//        chess[4][5] = 2 ;
//        chess[5][5] = 2 ;
        int[][] chess = new int[3][5];
        chess[0][3] = 3;
        chess[1][2] = 2;
        System.out.println("创建初始棋盘");

//        遍历打印棋盘
        for (int[] row:chess) {
            for (int data:row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

//        1.遍历棋盘，得到数据个数
        int sum = 0 ;
        int rows = 0 ;
        int columns = 0 ;
        for (int[] row:chess) {
            for (int data:row) {
                if (data != 0) {
                    sum++;
                }
                columns++;
            }
            rows++;
        }
        columns = columns/rows;
        System.out.println(rows);
        System.out.println(columns);

//        2.知道棋盘中有用数据个数之后，创建稀疏数组
        int[][] SparseArray = new int[sum+1][3];
        SparseArray[0][0] = rows;
        SparseArray[0][1] = columns;
        SparseArray[0][2] = sum;



//        3.遍历棋盘，向棋盘中存入数据
        int count =1;
        for (int i=0; i<rows ; i++) {
            for (int j=0; j<columns ; j++) {
                if (chess[i][j]!=0) {
                    SparseArray[count][0] = i;
                    SparseArray[count][1] = j;
                    SparseArray[count][2] = chess[i][j];
                    count++;
                }
            }
        }

//        打印最后的稀疏数组出来看看
        for (int[] row:SparseArray) {
            for (int data:row) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }

        System.out.println("-----------------------------------------");

        //    将稀疏数组还原成最初的数组
        int array[][] = new int[SparseArray[0][0]][SparseArray[0][1]];
        for (int i=1 ; i<SparseArray[0][2]+1 ; i++){
            array[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
        }

        for (int[] row:array) {
            for (int data:row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

    }
}
