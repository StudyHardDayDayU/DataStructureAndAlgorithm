import java.util.Arrays;

public class FabonacciSearch {
    public static void main(String[] args) {
        System.out.println("斐波那契查找");

        int maxSize = 20;
        int[] fib = getFib(maxSize);

        int[] arr = {1,8,10,89,1000,1234,2313,5555,11223};

        int index = fibSearch(arr,maxSize,5555);

        System.out.println(index);
    }

    /**
     * 使用斐波那契算法查找一个数
     *
     * @param arr       需要搜寻的数组
     * @param findValue 需要找到的数
     * @param maxSize   斐波那契数组长度
     */
    public static int fibSearch(int[] arr, int maxSize, int findValue) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 斐波那契分割数值的下标
        int mid = 0;
        int f[] = getFib(maxSize);
        // 获取斐波那契分割数的下标
        // 注意，分割数是斐波那契数组中倒数第二个数，因为是分割点！！
        while (high > f[k] - 1) {
            k++;
        }
        // f[k]可能大于a的长度，所以要创建一个长度为f[k]的新数组
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 将多出来的部分用最后一位数填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 持续循环去找需要找到的数
        while (low <= high) {
            // mid新算法，每次都会更新到查找区间的黄金分割点上
            mid = low + f[k - 1] - 1;
            if (findValue < temp[mid]) {
                // 向数组左边查找
                high = mid - 1;
                k--;
            } else if(findValue > temp[mid]) {
                // 向数组右边查找
                low = mid + 1;
                /*
                * 那么这里为什么要减二而不是一呢？
                * 因为黄金分割点是f[k-1],说明前面有这么多个元素
                * 而数组总长度是多少？是f[k]
                * 那么黄金分割点到数组尾部有多少个元素？有f[k]-f[k-1]个
                * 而通过斐波那契数列的特点可以知道，f[k-2] = f[k]-f[k-1]
                * 之后是从上次黄金分割点对应的元素查找到最后一个元素，此时长度就是上面算出来的f[k-2]
                * 那f[k-2]对应的黄金分割点是多少？是斐波那契数列的前一位，即f[k-3]
                * 所以要从f[k-1]跳到f[k-3]，应该减二
                * */
                k -= 2;
            } else {
                // 这个时候，就是找到了
                /*
                * 为什么还要分类返回？因为数组加长过
                * mid有可能会越出原数组
                * */
                if (mid < high){
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    /**
     * 生成一个斐波那契数组
     *
     * @param maxSize 数组中有多少个斐波那契数
     * @return 生成的斐波那契数组
     */
    public static int[] getFib(int maxSize) {
        int[] Fib = new int[maxSize];
        Fib[0] = 1;
        Fib[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            Fib[i] = Fib[i - 1] + Fib[i - 2];
        }

        return Fib;
    }
}
