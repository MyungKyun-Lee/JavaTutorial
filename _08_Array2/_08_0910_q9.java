package _08_Array2;

import java.util.Random;
import java.util.Scanner;

public class _08_0910_q9 {

	public static void main(String[] args) {
		Random r = new Random();
		
		int[][] b = {{1,1,0,2},{3,2,1,2},{0,0,3,2},{4,4,4,4},{2,4,3,1},{2,4,1,3}};
		int max_x = b[0].length;
		int max_y = b.length;
		
//		int xx=0;
//		int yy=3;
		
		for (int i=0; i<max_y; i++) {
			for (int j=0; j<max_x; j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		
		Scanner in = new Scanner(System.in);
		System.out.print("X좌표를 입력하세요 :");
		int xx = in.nextInt();
		System.out.print("Y좌표를 입력하세요 :");
		int yy = in.nextInt();
		
		int xy = b[yy][xx];
//		if ((b[yy][0]+b[yy][1]+b[yy][2])/xy==3 || (b[yy][1]+b[yy][2]+b[yy][3])/xy==3 ) {
		if ((xy==b[yy][0] && xy==b[yy][1] && xy==b[yy][2]) || (xy==b[yy][1] && xy==b[yy][2] && xy==b[yy][3]) ) {
			for (int y=yy; y>0; y--) {
				b[y][0] = b[y-1][0];
				b[y][1] = b[y-1][1];
				b[y][2] = b[y-1][2];
				b[y][3] = b[y-1][3];
			}
				b[0][0] = r.nextInt(6);
				b[0][1] = r.nextInt(6);
				b[0][2] = r.nextInt(6);
				b[0][3] = r.nextInt(6);
		}
		
		for (int i=0; i<max_y; i++) {
			for (int j=0; j<max_x; j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
