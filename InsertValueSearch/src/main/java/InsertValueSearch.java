import java.util.ArrayList;

public class InsertValueSearch {
    public static void main(String[] args) {
        System.out.println("插值查找");

        // 初始化一个有序数组
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        arr[78] = 80;
        arr[79] = 80;
        arr[81] = 80;
        arr[82] = 80;

//        int index = insertValueSearch(arr, 0, arr.length - 1, 80);
        ArrayList<Integer> arrayList = BetterInsertValueSearch(arr, 0, arr.length - 1, 80);

        System.out.println(arrayList);
    }


    /**
     * 插值查找函数 - 只能查找一个，如果重复无法返回所有结果
     *
     * @param arr       查找数组
     * @param left      左边的指针
     * @param right     右边的指针
     * @param findValue 需要查找的值
     * @return
     */
    public static int insertValueSearch(int arr[], int left, int right, int findValue) {
        if (left > right || findValue > arr[arr.length - 1] || findValue < arr[0]) {
            return -1;
        }

        // 求出mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        // 向右递归
        if (findValue > midValue) {
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            // 向左递归
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else {
            // 这个时候就是，已经找到了需要查找的值
            return mid;
        }
    }

    /**
     * 插值查找函数 - 可以查找所有符合要求的值
     *
     * @param arr       查找数组
     * @param left      左边的指针
     * @param right     右边的指针
     * @param findValue 需要查找的值
     * @return
     */
    public static ArrayList<Integer> BetterInsertValueSearch(int arr[], int left, int right, int findValue) {
        if (left > right || findValue > arr[arr.length - 1] || findValue < arr[0]) {
            return new ArrayList<Integer>();
        }

        // 求出mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        // 向右递归
        if (findValue > midValue) {
            return BetterInsertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            // 向左递归
            return BetterInsertValueSearch(arr, left, mid - 1, findValue);
        } else {
            // 这个时候就是，已经找到了需要查找的值
            // 先创建一个保存所有值的容器
            ArrayList<Integer> arrayList = new ArrayList<>();
            // 先把当前的值保存
            arrayList.add(mid);

            // 向右扫描
            for (int i = mid + 1; arr[i] == findValue; i++) {
                arrayList.add(i);
            }
            // 向左扫描
            for (int i = mid - 1; arr[i] == findValue; i--) {
                arrayList.add(i);
            }

            return arrayList;
        }
    }

}
