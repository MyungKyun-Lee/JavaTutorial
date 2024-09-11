package _08_Array2;

public class _test2 {

	public static void main(String[] args) {
		int k,l;
		
		int i=0, j=0;
		int n=5, m=4;
		int [][] a = new int[n+2][m+2];
		int num = 1;
		for(i=0; i<=n+1; i++) {
			for(j=0; j<=m+1; j++) {
				if (i==0 || i==n+1 || j==0 || j==m+1) {
					a[i][j] = -1;
				}
				else {
					a[i][j] = 0;
				}
			}
		}
		
		i=1;
		j=1;
		while(num<n*m) {
			if (a[i][j+1]==0 && a[i-1][j] != 0) {
				a[i][j] = num++;
				j++;
			}
			else if (a[i+1][j] == 0 && a[i][j+1] != 0) {
				a[i][j] = num++;
				i++;
			}
			else if (a[i][j-1] == 0 && a[i+1][j] != 0) {
				a[i][j] = num++;
				j--;
			}
			else if (a[i-1][j] == 0 && a[i][j-1] != 0) {
				a[i][j] = num++;
				i--;
			}
			if (num==n*m) {
				a[i][j]= n*m;
			}
		}
		
		
		for(i=0; i<=n+1; i++) {
			for(j=0; j<=m+1; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
