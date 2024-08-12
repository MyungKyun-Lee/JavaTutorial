package _03For;
import java.util.Arrays;
import java.util.HashMap;

public class _05_test_for {

	public static void main(String[] args) {
		// 메소드
		String test = "abcdabcd";
		for (int i = 0; i < test.length(); i++) {
			char aaa = test.charAt(i);
			System.out.println(aaa);
		}
				
		
		String[] cars = {"Volvo", "BMW", "Tesla", "Ford", "Fiat", "Mazda", "Audi"};
	    Arrays.sort(cars);
	    for (String i : cars) {
	      System.out.println(i);
	    }
	    
	    // An array storing different ages
	    int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
	    float avg, sum = 0;
	    // Get the length of the array
	    int length = ages.length;
	    // Loop through the elements of the array
	    for (int age : ages) {
	      sum += age;
	    }
	    // Calculate the average by dividing the sum by the length
	    avg = sum / length;
	    // Print the average
	    System.out.println("The average age is: " + avg);
	    
	    
	    // An array storing different ages
	    int ages2[] = {20, 22, 18, 35, 48, 26, 87, 70};
	    float avg2=0, sum2 = 0;
	    // Get the length of the array
//	    int length2 = ages2.length;
	    // Create a 'lowest age' variable and assign the first array element of ages to it
	    int lowestAge = ages2[0];
	    // Loop through the elements of the ages array to find the lowest age
	    for (int age : ages2) {
	      // Check if the current age is smaller than the current 'lowest age'
	      if (lowestAge > age) {
	        // If the smaller age is found, update 'lowest age' with that element
	        lowestAge = age;
	      }
	    }
	    // Output the value of the lowest age
	    System.out.println("The lowest age in the array is: " + lowestAge);
	    
	    // Loop Through a HashMap
	    HashMap<String, String> capitalCities = new HashMap<String, String>();
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    for (String i : capitalCities.keySet()) {
//	      System.out.println(i);
	      System.out.println("key: " + i + "\t value: " + capitalCities.get(i));
	    }
	  
	  
	}

}
