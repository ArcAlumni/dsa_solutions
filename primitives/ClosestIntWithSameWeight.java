public class ClosestIntWithSameWeight {
    
    /**
        To find the closest weight integer. Weight is number of set bits.
    */
    
    public static void main(String[] args) {
        ClosestIntWithSameWeight c = new ClosestIntWithSameWeight();
        System.out.println(c.closestIntWithSameWeight(23));
    }
    
    // if next bits are different 
    // swap the bits
    int closestIntWithSameWeight(int x){
        for(int i=0;i<31;i++){
            if( ((x >> i) & 1) != ((x >> i + 1) & 1) ){
                int mask = (1 << i) | (1 << i + 1);
                return x ^ mask;
            }    
        }
        throw new RuntimeException("Invalid integer");
    }
    int lowestBitSet(int x){
      return  x & ~(x-1);
    }
    int lowestBitNotSet(int x){
      return ~x & (x+1);
    }
    
    int closestIntWithSameWeight2(int x){
        int ns = lowestBitNotSet(x);
        int s = lowestBitSet(x);
        if (ns>s){
           x|=ns;
           x^=ns>>1;
        }
        else{
           x^=s;
           x|=s>>1;
        }
        return x;
    }
    
}
