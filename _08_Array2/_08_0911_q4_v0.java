package _08_Array2;

public class _08_0911_q4_v0 {

	public static void main(String[] args) {
		// 2차원 배열 문제4 풀이
		int[][] a= new int[5][5];
		int num = 1;
		int row = a.length;
		int col = a[0].length;
		
		num=1;
		for (int i=0; i < row+col-1; i++) {
			for (int j=0; j < row; j++) {
				int column = i-j;
				System.out.print("a["+j+"]["+column+"]="+num+"\t");
				if (column > -1 && column < col) {
					a[j][column] = num++;
				}
			}
			System.out.println();
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
				a[i][j]= 0;
			}
			System.out.println();
		}
		System.out.println("---------문제4");

	}

}
