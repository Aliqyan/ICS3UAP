import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = Integer.parseInt(keyboard.nextLine());
		String phrase = keyboard.nextLine();
		int[] arr = new int[n];

		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt((phrase.split(" ")[i]));

		}
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		int count = 0;
		for(int i =0; i<n; i++){
			for(int j=i+1; j<n; j++){
				solutions.add(arr[i] + arr[j]);
				count ++;
			}
		}
		int counter = 1;
		int counter2 = 0;
		for(int i = 0; i< solutions.size(); i++){
			int cur = solutions.get(i);
			int temp = 1;
			for(int j = i+1; j<solutions.size(); j++){
				if(cur == solutions.get(j)) temp ++;
			}
						
			if(counter < temp){
				counter = temp;
				
			}
			
			
		}
		
		for(int i = 0; i< solutions.size(); i++){
			int cur = solutions.get(i);
			int temp = 1;
			for(int j = i+1; j<solutions.size(); j++){
				if(cur == solutions.get(j)) temp ++;
			}
						
			if(counter == temp){
				counter2 ++;
				
			}
			
			
		}
		
		if(counter2 == 0) counter2 = 1;
		System.out.println(counter + " " + counter2);
		
		
	}
	
	
}
