package _08_Array2;

import java.util.Arrays;

public class _08_0911_q5_v2 {

	public static void main(String[] args) {
		// 2차원 배열 문제5 풀이
		int[][] a= new int[6][5];
		int num = 1;
		int row = a.length;
		int col = a[0].length;

		num=1;
		int y=0;
		int x=0;
		int col_l=0, col_r=col-1;
		int row_u=0, row_d=row-1;

		while (num < col*row) {
			if (y == row_u && x < col_r ) {
//				System.out.println("1a["+y+"]["+x+"]="+num+"\t");
				a[y][x] = num;
				x++;
			} 
			else if (x == col_r && y < row_d) {
//				System.out.println("2a["+y+"]["+x+"]="+num+"\t");
				a[y][x] = num;
				y++;
			} 
			else if (y == row_d && x > col_l) {
//				System.out.println("3a["+y+"]["+x+"]="+num+"\t");
				a[y][x] = num;
				x--;
			} 
			else if (x == col_l && y > row_u) {
//			System.out.println("4a["+y+"]["+x+"]="+num+"\t");
				a[y][x] = num;
				y--;
			}
			num++;
			if (x == col_l && y == row_u) {
				col_l++; row_u++;
				col_r--; row_d--;
				x++; y++;
			}
			if (num == row*col) {
				a[y][x]= row*col;
			}
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
				a[i][j]= 0;
			}
			System.out.println();
		}
		System.out.println("---------문제5");
	}

}
