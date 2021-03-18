public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 7, 8, 8, 8 };

        int num = 7;

        System.out.println(findIdx(arr, num, true));
        System.out.println(findIdx(arr, num, false));

    }

    public static int findIdx(int[] arr, int num, boolean findMinIdx) {

        int start = 0, end = arr.length - 1, idx = 0;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (num == arr[mid]) {
                idx = mid;
                if (findMinIdx)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return idx;
    }

}
