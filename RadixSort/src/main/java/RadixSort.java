import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        System.out.println("基数排序");

        int arr[] = {53, 3, 542, 748, 14, 214};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]) {
        // 定义桶，十个桶对应0-9十个数
        int bucket[][] = new int[10][arr.length];

        // 记录每个桶中实际存放了多少个数据
        int bucketCounts[] = new int[10];

        // 找到最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 找到最大数的位数
        int maxSize = 1;
        // 方法一
//        for (int i = 1; max > 0; i++) {
//            max = max / 10;
//            maxSize = i;
//        }
        // 方法二
        maxSize = (max + "").length();

        for (int i = 0, n = 1; i < arr.length; i++, n *= 10) {
            // 取出所有数据的某一位，放入对应的桶
            for (int j = 0; j < arr.length; j++) {
                // 取出当前数据的一位
                int digit = arr[j] / n % 10;
                // 放入对应的桶中
                bucket[digit][bucketCounts[digit]] = arr[j];
                bucketCounts[digit]++;
            }
            // 按照顺序，从桶里拿数据填充原数组
            int index = 0;
            for (int k = 0; k < bucketCounts.length; k++) {
                // 如果桶中有数据，就放入
                if (bucketCounts[k] != 0) {
                    for (int l =0 ; l<bucketCounts[k] ; l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                // 把这个桶遍历完成之后，将计数清零
                // 不用把存储桶清零，因为之后重新装填会直接覆盖
                bucketCounts[k] = 0;
            }
        }
    }
}
