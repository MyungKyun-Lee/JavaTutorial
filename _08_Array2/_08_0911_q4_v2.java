package _08_Array2;

public class _08_0911_q4_v2 {

	public static void main(String[] args) {
		// 2차원 배열 문제4 풀이
		int[][] a= new int[4][5];
		int num = 1;
		int row = a.length;
		int col = a[0].length;

		// 0,0
		// 0,1 1,0
		// 0,2 1,1 2,0
		// 0,3 1,2 2,1 3,0
		// 0,4 1,3 2,2 3,1
		//     1,4 2,3 3,2
		//         2,4 3,3
		//             3,4
		
		int y=0, x=0;
		for (int i=0; i<col*row; i++) {

			System.out.println("a["+y+"]["+x+"]="+num+"\t");
			a[y][x]= num++;
			
			x--; y++;
			if (x<0) {x=y; y=0;}
			if (y>=row) {y=0;}
			if (num==15) {x=col-1; y=1;}
			if (num==18) {x=col-1; y=2;}
			if (num==20) {x=col-1; y=3;}
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
