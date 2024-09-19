package _08_Array2;

import java.util.Arrays;

public class _08_0911_q6 {

	public static void main(String[] args) {
		// 2차원 배열 문제6 풀이
		int[][] a= {{1,2,3,4,5},
				    {6,7,8,9,10},
				    {11,12,13,14,15},
				    {16,17,18,19,20},
				    {21,22,23,24,25}};

		int row = a.length;
		int col = a[0].length;
		int x = 0, y = 0;
		int col_l = 0, col_r = col-1;
		int row_u = 0, row_d = row-1;
		int [][] b= new int [row][col];
		
		while (true) {
			for (x=col_l; x <= col_r-1 && col_l < col_r; x++) b[y][x+1] = a[y][x];

			for (y=row_u; y <= row_d-1 && row_u < row_d; y++) b[y+1][x] = a[y][x];

			for (x=col_r; x >= col_l+1 && col_r > col_l; x--) b[y][x-1] = a[y][x];
			
			for (y=row_d; y >= row_u+1 && row_d > row_u; y--) b[y-1][x] = a[y][x];
			
			col_l++; col_r--;
			row_u++; row_d--; 
			y = row_u; x = col_l;
			
			if (col_l == col_r && row_u == row_d && b[y][x]==0) b[y][x] = a[y][x];
			if (col_l > col_r && row_u > row_d ) {
				break;
			}
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------문제5");
		
		int [][] c = Arrays.copyOf(a, row);    // 2차원 [배열복사]는 row수 넣어야함
		for (int i=0; i<c.length; i++) {
			for (int j=0; j<c[0].length; j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		
		for (int i=0; i < row; i++) Arrays.fill(c[i], -1); // 2차원 [배열 채우기]는 row수 만큼 채워야 함
		System.out.println("---------문제x");
		for (int i=0; i<c.length; i++) {
			for (int j=0; j<c[0].length; j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
