package _08_Array2;

public class _test {

	public static void main(String[] args) {
        int[][] a = {
                {1, 1, 13, 4},
                {1, 1, 1, 4},
                {14, 13, 13, 45},
                {14, 17, 13, 19},
                {14, 22, 13, 24},
                {1, 2, 3, 4}
            };

            for (int i = 1; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == a[i - 1][j] && a[i][j] == a[i + 1][j]) {
                        System.out.println(" x: " + (i-1) + " y: " + j + "" + " = " + a[i][j] );
                        System.out.println(" x: " + i + " y: " + j + "" + " = " + a[i][j] );
                        System.out.println(" x: " + (i+1) + " y: " + j + "" + " = " + a[i][j] );
                    }
                }
            }

	}

}
