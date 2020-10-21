public class PalindromeInteger {
    
    public static void main(String[] args) {
        PalindromeInteger obj = new PalindromeInteger();
        System.out.println(obj.isPalindrome(12344321));
    }
    
    boolean isPalindrome(int x){
        int numDigits = 0;
        int tempX = x;
        while(x != 0){
            numDigits++;
            x /= 10;
        }
        int mask = (int) Math.pow(10, numDigits - 1);
        for(int i=0;i<numDigits / 2;i++){
            int msb = tempX / mask;
            int lsb = tempX % 10;
            if(msb != lsb)
                return false;
            tempX -= msb * mask;
            mask /= 100;
            tempX /= 10;
        }
        return true;
    }
    
}
