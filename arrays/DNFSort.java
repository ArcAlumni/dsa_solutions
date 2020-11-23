import java.util.Arrays;

public class DNFSort {
    
    /**
        Dutch national flag problem
    */
    
    public static void main(String[] args) {
        DNFSort obj = new DNFSort();
        int[] arr = {1,2,0,0,1,1,2,1,0,1,2};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    void sort(int[] arr){
        int i = 0, j = arr.length - 1, k = 0;
        while(k <= j){
            if(arr[k] == 0){
                swap(arr, i, k);
                i++;
                k++;
            }else if(arr[k] == 1){
                k++;
            }else{
                swap(arr, j, k);
                j--;
            }
        }
    }
    
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
