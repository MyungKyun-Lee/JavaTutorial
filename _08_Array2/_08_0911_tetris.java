package _08_Array2;

public class _08_0911_tetris {

	public static void main(String[] args) {
		// 2차배열 오른쪽 회전
		int [][] a = {{1,1,0}, {0,1,0}, {0,1,1}};
		int row = a.length;
		int col = a[0].length;
		
		for (int i=0; i<col; i++ ) {
			for (int j=0; j<row; j++)  {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------원본행열");
		
		int [][] b = new int [col][row];
		
		for (int i=0; i<col; i++ ) {
			for (int j=0; j<row; j++)  {
				b[j][col-i-1] = a[i][j]; 
			}
		}
		
		for (int i=0; i<col; i++ ) {
			for (int j=0; j<row; j++)  {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------문제1");
		
		int [][] c = new int [col][row];
		
		for (int i=0; i<col; i++ ) {
			for (int j=0; j<row; j++)  {
				c[col-j-1][i] = a[i][j]; 
			}
		}
		
		for (int i=0; i<col; i++ ) {
			for (int j=0; j<row; j++)  {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------문제2");

	}

}
