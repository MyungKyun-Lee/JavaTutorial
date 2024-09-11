package _08_Array2;

public class _08_0911_q1_q6 {

	public static void main(String[] args) {
		// 2차원 배열 문제1~6 풀이
		int[][] a= new int[4][5];
		int num = 1;
		int row = a.length;
		int col = a[0].length;
		
		// 문제1---------------------------------
		for (int i=col-1; i>=0; i--) {
			for (int j=0; j<row; j++) {
				a[j][i]=num;
				num++;
			}
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------문제1");
		
		// 문제2---------------------------------
		num=1;
		for (int i=row-1; i>=0; i--) {
			for (int j=col-1; j>=0; j--) {
				a[i][j]=num;
				num++;
			}
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("---------문제2");

		// 문제3---------------------------------
		num=1;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (i%2==0) {
					a[i][j]=num;
				} else {
					a[i][col-j-1]=num;
				}
				num++;
			}
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
				a[i][j]=0;			}
			System.out.println();
		}
		System.out.println("---------문제3");
		
		// 문제4---------------------------------
		num=1;
		for (int i=0; i<col+3; i++) {
			for (int j=0; j<row; j++) {
				int column = i - j;
				if (column > -1 && column < col) {
//					System.out.print("a["+j+"]["+column+"]="+num+"\t");
					a[j][column]=num;
					num++;
				}
			}
//			System.out.println();
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
				a[i][j]=0;
			}
			System.out.println();
		}
		System.out.println("---------문제4");
		
		// 문제5---------------------------------
		num=1;
		int x=0;
		int y=0;
		for (int i=0; i<20; i++) {
			for (int j=0; j<col+row; j++) {
				System.out.print("a["+x+"]["+y+"]="+num+"\t");
				a[x][y]=num;
				num++;
				if (y<col-1) { y++; }
				if (y==col-1 && x<row) { x++; }
			}
			for (int j=0; j<col+row; j++) {
				System.out.print("a["+x+"]["+y+"]="+num+"\t");
				a[x][y]=num;
				num++;
				if (y<col-1) { y++; }
				if (y==col-1 && x<row) { x++; }
			}
			
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
				a[i][j]=0;
			}
			System.out.println();
		}
		System.out.println("---------문제5");
	}

}
