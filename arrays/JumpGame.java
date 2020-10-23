public class JumpGame {
    
    /**
        Can reach end of array. Jump based on current value of 'i'
    */
    
    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
        int[] arr = {3,2,0,0,6,7,8};
        System.out.println(obj.jumpGame(arr));
    }
    
    boolean jumpGame(int[] arr){
        int maxSoFar = 0;
        for(int i=0;i<=maxSoFar && maxSoFar < arr.length-1;i++){
            int currMax = i + arr[i];
            if(currMax > maxSoFar)
                maxSoFar = currMax;
        }
        return maxSoFar >= arr.length - 1;
    }
    
}
