import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println("希尔排序");

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        ShellSort1(arr);
//        ShellSort2(arr);
    }

    // 希尔排序 - 交换法
    public static void ShellSort1(int[] arr) {
        System.out.println("交换法 希尔排序");

        int temp = 0;
        int count = 0;

        // gap为步长，为了保证每一组都只有两个元素，便于交换，所以是除以二取整
        // 最后gap为1的时候就是最后一次排序，接下来gap/2为零，退出循环
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // i初始等于步长，i-步长就是j的初始值，每次递增1
            for (int i = gap; i < arr.length; i++) {
                // 最后为什么要减去步长？因为要退出循环  0 1 2 3 4 5 6 7 8 9
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序 - 移动法
    public static void ShellSort2(int[] arr) {
        System.out.println("移动法 希尔排序");

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 存储临时变量
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        System.out.println(i);
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
