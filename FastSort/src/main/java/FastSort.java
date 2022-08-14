import java.util.Arrays;

public class FastSort {
    public static void main(String[] args) {
        System.out.println("快速排序");

        int arr[] = {-9, 78, 0, 23, -567, 70};

        FastSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void FastSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot为中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;

        // 循环，将比中轴小的值放到左边，比中轴大的值放到右边，一个分类操作
        // 当l>r的时候，说明已经遍历完了
        while (l < r) {
            // 在中轴左边一直找，直到找到一个大于或者等于pivot的值才退出
            // 为什么要等于？考虑到没有大于的，碰到了pivot
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            // 如果 l>=r 说明 左边全部都是比中轴小的值，右边全是比中轴大的值
            // 这就是最后主要达到的目的
            if (l >= r) {
                break;
            }
            // 如果到这儿，说明碰到了不符合最终要求的数,且左右都有，需要把他们交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            /*
             * 假如左边已经好了，右边还没好，（左边在中轴处了，右边还离得很远）
             * 直接交换，交换之后，就变成了右边好了，左边还没好，开始挪动左边的游标，继续重复交换
             * */
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 考虑这种情况：0 -19 这样经过上面的交换判断之后，变成了-19 0 ，而左右索引在此时相等了,这是不行的。
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            FastSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            FastSort(arr, l, right);
        }

    }
}