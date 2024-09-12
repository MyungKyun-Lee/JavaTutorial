package _08_Array2;

public class _test3 {

	public static void main(String[] args) {

		int [][] a = new int [5][3];
		int num = 1;
		int sum = 0;
		int row_max = a.length;
		int col_max = a[0].length;

		for (int round = 0; round < (row_max+col_max)/2; round++) {
			if (round % 2 == 0) {
				sum = round;  
				for (int i = round/2; i < row_max-(round/2); i++) {
					for (int j = round/2; j < col_max-(round/2); j++) { 
//						System.out.println("a["+i+"]["+j+"] sum["+sum+"] round["+round+"] num["+num+"]");
						if (i + j == sum && num <= row_max*col_max) { 
							a[i][j] = num;
							num++;
							sum++;
						}
					}
				}
			}
			if (round % 2 == 1) {
				sum = (row_max-1-(round/2))+(col_max-2-(round/2));
				for (int i = row_max-(round/2)-1; i >= (round/2)+1; i--) {
					for (int j = col_max-(round/2)-1; j >= (round/2); j--) {
//						System.out.println("a["+i+"]["+j+"] sum["+sum+"] round["+round+"] num["+num+"]");
						if (i + j == sum && num <= row_max*col_max) {
							a[i][j] = num;
							num++;
							sum--;
						}
					}
				}
			}
		}
				
				
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
