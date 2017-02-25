import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = Integer.parseInt(sc.nextLine());
		int num = Integer.parseInt(sc.nextLine());
		int[] arr1 = new int[num]; 
		int[] arr2 = new int[num]; 
		
		String input1 = sc.nextLine();
		String input2 = sc.nextLine();
		for(int i = 0; i<num;i++){
			arr1[i] = Integer.parseInt(input1.split(" ")[i]);
			arr2[i] = Integer.parseInt(input2.split(" ")[i]);
		}
		int answer = 0;
		if(choice == 1){
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			

			int k = 0;
			int j = 0;
			for(int i = 0; i < num; i++){
				if(arr1[k] <= arr2[j]){
					answer += arr1[k];
					k++;
				}
				else{
					answer += arr2[j];
					j++;
				}

			}
		}else if(choice == 2){
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
	

			int k = num-1;
			int j = num-1;
			for(int i = 0; i < num; i++){
				if(arr1[k] >= arr2[j]){
					answer += arr1[k];
					k--;
				}
				else{
					answer += arr2[j];
					j--;
				}

			}
			
		}
		
		System.out.println(answer);
		
	}
}
