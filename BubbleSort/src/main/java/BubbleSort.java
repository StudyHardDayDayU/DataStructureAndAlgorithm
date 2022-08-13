public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("冒泡排序");

        int array[] = {3,9,-1,10,-2};

        // 优化
        boolean isNecessary = true;

        for (int i=0 ; i<array.length ; i++){
            for (int j=0 ; j<(array.length - 1 ) ; j++){
                if (array[j]>array[j+1]){
//                    如果发生交换
                    System.out.println("1");
                    isNecessary = false;
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;                                             
                }
            }

//             如果一次交换都没有发生，直接跳过
            if (isNecessary){
                break;
            } else{
                isNecessary = false;
            }

        }


        for (int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }
}
