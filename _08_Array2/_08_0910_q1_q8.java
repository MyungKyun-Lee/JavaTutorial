package _08_Array2;

public class _08_0910_q1_q8 {

	public static void main(String[] args) {
		int [][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		// 1.배열 a의 2번째 행의 모든 값을 출력
		for (int i=0; i<a[0].length; i++) {
			System.out.print(a[1][i]+"\t");
		}
		System.out.println();

		// 2.배열 a의 3번째 행에서 짝수의 값만 출력
		for (int i=0; i<a[0].length; i++) {
			if (a[2][i]%2==0) {
				System.out.print(a[2][i]+"\t");
			}
		}
		System.out.println();
		
		// 3.배열의 2열의 모든 값을 행의 순서대로 출력
		for (int i=0; i<a.length; i++) {
				System.out.print(a[i][2]+"\t");
		}
		System.out.println();
		
		// 4.전체배열의 값 중 짝수는 모두 몇개
		int cnt=0;
		for (int i=0; i<a[0].length; i++) {
			for (int j=0; j<a.length; j++)
				if (a[i][j]%2==0) {
					cnt++;
				}
		}
		System.out.println("Odd cnt= "+cnt);
		
		// 5.전체 배열의 값 중 홀수를 0으로 마스킹 하고 출력
		for (int i=0; i<a[0].length; i++) {
			for (int j=0; j<a.length; j++) {
				if (a[i][j]%2==1) {
					System.out.print("0"+"\t");
				} else {
					System.out.print(a[i][j]+"\t");
				}
			}
			System.out.println();
		}
		System.out.println("------");
		
		// 6.배열의 모든 값을 출력, 출력 할때는 행의 번호는 내림차순, 열의 번호도 내림차순으로 출력
		for (int i=a[0].length-1; i>=0; i--) {
			for (int j=a.length-1; j>=0; j--) {
					System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("------ 세로 3연속값 좌표");
		
		int[][] b = {{1,1,0,2},{3,2,1,2},{0,0,3,2},{4,4,4,4},{2,4,3,1},{2,4,1,3}};
		// 7.게임배열에서 같은 번호가 세로로 연속3개 이상이면 제거가 가능, 제거가 가능한 블록의 좌표를 출력
		int [] temp= {-1,1};
		int [][] xy= {{-1,-1},{-1,-1}};

		for (int i=0; i<b[0].length; i++) {
			for (int j=0; j<b.length; j++) {
//				System.out.print(b[j][i]+"\t");
				if (b[j][i]==temp[0]) {
					temp[0]=b[j][i];
					temp[1]++;
					if (temp[1]==3) {
						xy[1][0]=i+1;
						xy[1][1]=j+1;
						System.out.print("연속값="+temp[0]+" ");
						System.out.print("x1,y1=("+xy[0][0]+","+xy[0][1]);
						System.out.println(")\tx3,y3=("+xy[1][0]+","+xy[1][1]+")");
					}
				} else {
					temp[0]=b[j][i];
					temp[1]=1;
					xy[0][0]=i+1;
					xy[0][1]=j+1;
				}
			}
		}
		System.out.println("------ 가로 3연속값 좌표");
		
		temp[0]= -1;
		temp[1]=  1;
		xy[0][0]=-1;
		xy[0][1]=-1;
		xy[1][0]=-1;
		xy[1][1]=-1;
		
		for (int i=0; i<b.length; i++) {
			for (int j=0; j<b[0].length; j++) {
//				System.out.print(b[i][j]+"\t");
				if (b[i][j]==temp[0]) {
					temp[0]=b[i][j];
					temp[1]++;
					if (temp[1]==3) {
						xy[1][0]=i+1;
						xy[1][1]=j+1;
						System.out.print("연속값="+temp[0]+" ");
						System.out.print("x1,y1=("+xy[0][1]+","+xy[0][0]);
						System.out.println(")\tx3,y3=("+xy[1][1]+","+xy[1][0]+")");
					}
				} else {
					temp[0]=b[i][j];
					temp[1]=1;
					xy[0][0]=i+1;
					xy[0][1]=j+1;
				}
			}
		}
		System.out.println("------");
		
	}
}
