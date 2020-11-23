import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePrimes {
    
    public static void main(String[] args) {
        GeneratePrimes obj = new GeneratePrimes();
        System.out.println(obj.generatePrimes(200));
    }
    
    ArrayList<Integer> generatePrimes(int n){
        
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[2] = true;

        for(int i=2;i*i<primes.length;i++){
            if(primes[i]){
                int j = i * 2;
                while(j < primes.length){
                    primes[j] = false;
                    j = j + i;
                }
            }
        }
        
        ArrayList<Integer> primeList = new ArrayList<>();
        for(int i=2;i<primes.length;i++){
            if(primes[i])
                primeList.add(i);
        }
        
        return primeList;
    }
    
}
