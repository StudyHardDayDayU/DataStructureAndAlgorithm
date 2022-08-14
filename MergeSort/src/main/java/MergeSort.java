import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("归并排序");

        int arr[] = {8,4,5,7,1,3,6,2,0};
        int temp[] = new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));
    }


    // 归并排序 - 入口
    public static void mergeSort(int arr[], int left, int right, int temp[]) {
        if (left < right) {
            // 这是中间的索引
            int mid = (right + left) / 2;
            // 向左递归
            mergeSort(arr, left, mid, temp);
            // 向右递归
            mergeSort(arr, mid + 1, right, temp);

            // 合并
            merge(arr,left,mid,right,temp);
        }
    }


    /**
     * 归并排序 - 合并方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序数列的初始索引
     * @param mid   中间的索引
     * @param right 右边的索引
     * @param temp  临时中转数组
     */
    public static void merge(int arr[], int left, int mid, int right, int temp[]) {
        // 左边的初始索引
        int i = left;
        // 右边有序数列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        // 先把左右两边的有序数列按照规矩填充到temp数组中
        // 知道两边其中之一有一个全部排完
        while (i <= mid && j <= right) {
            // 当前，如果左边的元素小于右边的元素
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        // 上面的循环出来之后，一定有一边是全部遍历完了的
        // 接下来把另一边剩下的所有元素全部拷贝到temp剩下的位置里面
        // 注意有等于号
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        // 现在已经将全部的数据按一定规则拷贝到了temp数组
        // 将temp拷贝回去，更新原数组
        // 注意，不是每次都把全部拷贝过去！！！
        t = 0;
        int tempLeft = left;
        // 注意有等于
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
