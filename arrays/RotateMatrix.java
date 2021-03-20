class RotateMatrix {

	public void rotateBy90Degree(int n) {

		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < mat.length / 2; i++) {
			for (int j = i; j < mat[0].length - 1 - i; j++) {
				int temp1 = mat[mat.length - 1 - j][i];
				int temp2 = mat[mat.length - 1 - i][mat.length - 1 - j];
				int temp3 = mat[j][mat.length - 1 - i];
				int temp4 = mat[i][j];
				mat[i][j] = temp1;
				mat[mat.length - 1 - j][i] = temp2;
				mat[mat.length - 1 - i][mat.length - 1 - j] = temp3;
				mat[j][mat.length - 1 - i] = temp4;
			}
		}

	}

}
