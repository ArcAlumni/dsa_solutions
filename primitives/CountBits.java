public class CountBits {

    // https://leetcode.com/problems/counting-bits/
    // leetcode #338
    // the no of set bits in a number n is,
    // if n is even , is equal to number of set bits in n>>1
    // if n is odd, is equal to number of set bits in (n-1) plus 1.
    public static int[] countBits(int num) {
        int[] arr = new int[num+1];
        arr[0] = 0;
        for(int i = 1; i <= num; i++) {
            if( (i & 1) == 0)
                arr[i] = arr[i>>1];
            else
                arr[i] = arr[i-1] + 1;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int num = 5;
        
        int[] ans = countBits(num);
        
        for(int n : ans)
            System.out.print(n + " ");
    }
}
