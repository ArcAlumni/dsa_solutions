public class BuyAndSellStock {

	public static void main(String[] args) {
		BuyAndSellStock obj = new BuyAndSellStock();
		int[] arr = { 12, 2, 3, 9, 4, 1, 5 };
		System.out.println(obj.maxProfitOneBuy(arr));
	}

	int maxProfitOneBuy(int[] prices) {
		int min = Integer.MAX_VALUE, maxProfit = 0;
		for (int price : prices) {
			maxProfit = Math.max(maxProfit, price - min);
			min = Math.min(min, price);
		}
		return maxProfit;
	}

	public int maxProfitAtmostTwoBuys(int[] prices) {

		int[] firstBuyMax = new int[prices.length];
		int minSoFar = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			minSoFar = Math.min(minSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
			firstBuyMax[i] = maxProfit;
		}

		int maxSoFar = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i >= 0; i--) {
			maxSoFar = Math.max(maxSoFar, prices[i]);
			maxProfit = Math.max(maxProfit, maxSoFar - prices[i] + firstBuyMax[i]);
		}

		return maxProfit;
	}

}
