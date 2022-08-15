import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("二分查找");

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};

//        int index = binarySearch(arr, 0, arr.length - 1, 11);
        ArrayList<Integer> index = fartherBinarySearch(arr, 0, arr.length - 1, 1000);

        System.out.println(index.toString());
    }


    /**
     * @param arr       目标数组
     * @param left      左指针
     * @param right     右指针
     * @param findValue 需要查找的值
     * @return 如果找到，返回其在数组中的下标，如果没有找到，返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findValue) {

        // 里面没有要找的数就会左右指针溢出
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 如果中间值比查找的值要小
        // 向右递归
        if (midValue < findValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        }
        // 向左递归
        else if (midValue > findValue) {
            return binarySearch(arr, left, mid - 1, findValue);
        }
        // 如果正好找到了
        else {
            return mid;
        }
    }


    /*
     * 思考一个情况，数组中有多个相同的值，而要查找的恰好是他
     * 那么如果将所有值都查找到，并且返回他们的下标？
     *
     * 思路分析：
     * 1. 找到元素后，当前下标为mid，不要急着返回，接着走
     * 2. 分别向左右扫描，记住一定要是左右，1,2,2,2,1，比如这种情况就是特例。
     * 3. 对应下标加入到集合并返回
     * */
    public static ArrayList<Integer> fartherBinarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 如果中间值比查找的值要小
        // 向右递归
        if (midValue < findValue) {
            return fartherBinarySearch(arr, mid + 1, right, findValue);
        }
        // 向左递归
        else if (midValue > findValue) {
            return fartherBinarySearch(arr, left, mid - 1, findValue);
        }
        // 如果正好找到了
        else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            System.out.println(mid);
            arrayList.add(mid);

            // 向左扫描
            for (int temp = mid - 1; temp > 0 && arr[temp] == findValue; temp--) {
                if (temp < 0) {
                    break;
                }
                arrayList.add(temp);
            }

            // 向右扫描
            for (int temp = mid + 1; temp < arr.length - 1 && arr[temp] == findValue; temp++) {
                if (temp > arr.length - 1) {
                    break;
                }
                arrayList.add(temp);
            }

            return arrayList;
        }
    }
}
