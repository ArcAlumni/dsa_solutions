class CheckValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			boolean[] visitedRow = new boolean[10];
			boolean[] visitedCol = new boolean[10];
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (visitedRow[(int) board[i][j] - '0'])
						return false;
					visitedRow[(int) board[i][j] - '0'] = true;

				}
				if (board[j][i] != '.') {
					if (visitedCol[(int) board[j][i] - '0'])
						return false;
					visitedCol[(int) board[j][i] - '0'] = true;
				}
			}
		}

		for (int i = 2; i < 9; i += 3) {
			for (int j = 2; j < 9; j += 3) {
				if (!checkPartition(board, i - 2, i, j - 2, j))
					return false;
			}
		}

		return true;

	}

	boolean checkPartition(char[][] board, int starti, int endi, int startj, int endj) {
		boolean[] visitedBox = new boolean[10];
		for (int i = starti; i <= endi; i++) {
			for (int j = startj; j <= endj; j++) {
				if (board[i][j] != '.') {
					if (visitedBox[(int) board[i][j] - '0'])
						return false;
					visitedBox[(int) board[i][j] - '0'] = true;

				}
			}
		}
		return true;
	}

}
