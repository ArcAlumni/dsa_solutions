public class CoinChange {

	public void numberOfWaysToMakeChange(int[] coins, int amount){
		
		int[][] ways = new int[coins.length + 1][amount + 1];	// add 1 for zero amount as base case
		
		dp[0][0] = 1; // there is one way to make zero amount with zero coins
		
		for(int i=1;i<dp.length;i++){
			dp[i][0] = 1; // there is always 1 way to make 0 amount
			for(int j=1;j<dp[0].length;j++){
				if(j >= coins[i - 1]){ // when amount is greater than coin
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];	// when coin not choosed + (coin choosed so add) optimized value for the balance amount
				} else{
					dp[i][j] = dp[i - 1][j]; // coin is greater than amt, so not possible to add it to change
				}
			}
		}
		
		return dp[coins.length][amount];
	}

}
