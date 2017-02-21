import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int hour = Integer.parseInt(input.split(":")[0]);
		int min = Integer.parseInt(input.split(":")[1]);
		int minTotal = hour * 60 + min;

		if((minTotal <= 5 *60 || minTotal >= 10*60) && (minTotal <= 13 *60 || minTotal >= 19*60)){
			System.out.printf("%02d" + ":" + "%02d",(hour + 2)%24 , min);
		}else if((minTotal <= 8 *60 && minTotal > 7*60) || (minTotal <= 17 *60 && minTotal >= 15*60)){
			System.out.printf( "%02d" + ":" + "%02d", hour + 4, min);
		}else if(minTotal >= 13*60){
			 minTotal = 10 * 60 + 120 - (10*60 - minTotal)/2;
			System.out.printf("%02d" + ":" + "%02d",minTotal/60, minTotal % 60);
		}else{
			minTotal = 10 * 60 + 120 - (10*60 - minTotal)/2;
			System.out.printf("%02d" + ":" + "%02d",minTotal/60, minTotal % 60);
		}
			
		
	}
}
