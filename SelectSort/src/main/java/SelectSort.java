public class SelectSort {
    public static void main(String[] args) {
        System.out.println("选择排序");
        // 测试数组
        int[] arr = {101, 1, 119, 34};

        for (int i = 0; i < arr.length - 1; i++) {
            // 首先设定开头就是最小值
            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                // 如果不是最小值，保存
                // 这里必须是min而不能是arr[i]，如果是后者，那么排序不能保证最终保存的是后面一串中的最小的
                // 只有实时更新最小的数，并且用最小的那个数做比较，才行，体会体会
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            // 如果后面没有比开头小的数，再做交换也没有意义，因为是自己和自己交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
        // 看看是否排序成功
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
