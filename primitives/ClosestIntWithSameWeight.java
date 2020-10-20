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
    
}
