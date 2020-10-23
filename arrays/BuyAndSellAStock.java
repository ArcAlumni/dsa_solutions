public class BuyAndSellAStock {
    
    public static void main(String[] args) {
        BuyAndSellAStock obj = new BuyAndSellAStock();
        int[] arr = {12,2,3,9,4,1,5};
        System.out.println(obj.maxProfitOneBuy(arr));
    }
    
    int maxProfitOneBuy(int[] prices){
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for(int price : prices){
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(min, price);
        }        
        return maxProfit;
    }
    
    
    
}
