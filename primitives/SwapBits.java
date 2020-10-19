public class SwapBits {
    
    /**
        Swap the i-th and j-th position bits in an integer
    */
    
    public static void main(String[] args) {
        SwapBits p = new SwapBits();
        System.out.println(p.swapBits(73, 1, 6));
    }
    
    // O(1)
    // flip bits if they are different
    long swapBits(long x, int i, int j){
        if(((x >> i) & 1) != ((x >> j) & 1)){ 
            long mask = (1L << i) | (1L << j); // generate mask with set bits
            x ^= mask; // XOR of 1 will flip the bit
        }    
        return x;
    }
    
}
