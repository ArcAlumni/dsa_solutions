import java.util.Arrays;

public class ArrangeEvenOdd {
    
    /**
        Arrange the array such that all even numbers come first
    */
    
    public static void main(String[] args) {
        ArrangeEvenOdd obj = new ArrangeEvenOdd();
        int[] arr = {1,2,3,4,5,6,7};
        obj.evenOdd(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    void evenOdd(int[] arr){
        int i = 0, j = arr.length - 1;
        while(i < j){
            if(arr[i] % 2 == 0){
                i++;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    
}
