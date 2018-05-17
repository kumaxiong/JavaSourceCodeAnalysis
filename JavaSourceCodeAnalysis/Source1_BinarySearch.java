public class Source1_BinarySearch {
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {

        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = a[mid];
            // 小于 lo 指向中间，大于hi指向中间,等于直接返回
            if (midValue < key)
                low = mid + 1;
            else if (midValue > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static int binarySearch_Recursive(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int result = -1;
        if (low <= high) {
            int mid = (low + high) >>> 1;
            int midValue = a[mid];
            if(midValue < key)
                result = binarySearch_Recursive(a,mid +1,high + 1,key);
            else if  (midValue > key)
                result = binarySearch_Recursive(a,low,mid + 1 -1,key);
            else
                return mid;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearch_Recursive(a, 0, a.length, 11);
        System.out.println(index);
    }
}
