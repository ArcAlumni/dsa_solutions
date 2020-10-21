public class BinaryExponentiation {
    
    public static void main(String[] args) {
        BinaryExponentiation b = new BinaryExponentiation();
        System.out.println(b.power(3, 5));
    }
    
    // iterative
    int power(int a, int b){
        int result = 1;
        while(b > 0){
            if((b & 1) == 1) // b is odd, so multiply with another 'a'
                result *= a;
            b >>= 1; // divide 'b' by 2
            a *= a;
        }
        return result;
    }
    
    // recursive
    int powerRec(int a, int b){
        if(b == 0) return 1;
        if(b == 1) return a;
        int localRes = powerRec(a, b >> 1);
        int res = localRes * localRes;
        if((b & 1) == 1) res *= a;
        return res;
    }
    
}
