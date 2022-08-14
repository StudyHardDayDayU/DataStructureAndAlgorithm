public class LinearSearch {
    public static void main(String[] args) {
        System.out.println("线性查找");

        int arr[] = {123,564,67,2,4,674,431,4,56,9674,31,3525,2};

        
    }

    public static int linearSearch(int arr[],int value){
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] == value){
                return i;
            }
        }

        return -1;
    }
}
