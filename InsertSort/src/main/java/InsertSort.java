public class InsertSort {
    public static void main(String[] args) {
        System.out.println("插入排序");

        int arr[] = {153, 2, 134, 555, 1346, 464, 486, 56, 7};

        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            // i - 1 就是默认插入前一个位置
            int insertIndex = i - 1;
            int insertValue = arr[i];

            // 如果insetIndex插入位置没有超范围
            // 且待插入的值比插入位置的值要小，则进入
            while ((insertIndex >= 0) && (insertValue < arr[insertIndex])) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // 如果出来了，说明找到了插入的位置，且(insertIndex + 1)就是插入位置
            // 因为insertIndex是插入位置前一个元素的索引嘛
            if (insertIndex + 1 == i) {
                arr[insertIndex + 1] = insertValue;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
