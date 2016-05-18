import java.util.*;

public class bracket {
	public static void main(String[] args) {
		// Scanner name = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>() ;
		names.add("Cooper");
		names.add("Jayden");
		names.add("Logan");
		names.add("Josh");
		names.add("Jordan");
		names.add("Allison");
		names.add("Samira");
		names.add("Andrew");
		names.add("Spencer");
		names.add("Wizard Beard");

		int multiplyer = 10;
		System.out.println("Take a bow ");
		RandomBattle2(names, multiplyer);

		System.out.println("CAST!");
		System.out.println();
		System.out.println("Lets check the winner shall we!");
		int rtotal = 0;
		int stotal= 0; 
		int gtotal= 0; 
		int htotal= 0;


		int[] array = scoreing(rtotal,stotal,gtotal,htotal);
		for(int i = 0; i < array.length; i ++){

			System.out.println(array[i]);

		}
		rtotal = array[0];
		stotal= array[1];
		gtotal = array[2];
		htotal = array[3];
		System.out.println("Who is the winners?");
		Scanner scanner = new Scanner(System.in);
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		System.out.println("Two losers need to play rock paper scissors!");
		names.add(scanner.nextLine());
		multiplyer=6;
		RandomBattle2(names, multiplyer);
		array = scoreing(rtotal,stotal,gtotal,htotal);
		for(int i = 0; i < array.length; i ++){

			System.out.println(array[i]);

		}
		rtotal = array[0];
		stotal= array[1];
		gtotal = array[2];
		htotal = array[3];
		System.out.println("Who is the winners?");
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		System.out.println("Two losers need to play rock paper scissors!");
		names.add(scanner.nextLine());
		multiplyer= 4;
		RandomBattle2(names, multiplyer);
		array = scoreing(rtotal,stotal,gtotal,htotal);
		for(int i = 0; i < array.length; i ++){
			System.out.println(array[i]);
		}
		rtotal = array[0];
		stotal= array[1];
		gtotal = array[2];
		htotal = array[3];
		System.out.println("Who is the winners?");
		names.add(scanner.nextLine());
		names.add(scanner.nextLine());
		multiplyer= 2;
		RandomBattle2(names, multiplyer);
		array = scoreing(rtotal,stotal,gtotal,htotal);
		for(int i = 0; i < array.length; i ++){
			System.out.println(array[i]);
		}
		rtotal = array[0];
		stotal= array[1];
		gtotal = array[2];
		htotal = array[3];
		System.out.println("Who is the WINNER?");
		names.add(scanner.nextLine());
		System.out.println("YOUR A WIZARD "+ names.get(0));

	}

	public static void RandomBattle2(ArrayList<String> names, int multiplyer){
		//create new array
		//adds the two random people to the array then prints them out later
		int z = multiplyer;
		int s = names.size()/2;
		for(int i = 0;i < s; i++){
			int x = (int)(Math.random() * z);
			int y = (int)(Math.random() * z);
			while(x == y){
				y = (int)(Math.random() * z);
			}
			System.out.println("------------"); 
			System.out.println(names.get(x));
			System.out.println(names.get(y));
			System.out.println("------------"); 
			names.remove(Math.max(x, y));
			names.remove(Math.min(x, y));
			z-=2;
		}
	}


	public static int[] scoreing(int rtotal, int stotal, int gtotal, int htotal){
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people won from ravenclaw?");
		int r = scanner.nextInt();
		rtotal = rtotal + r;
		//System.out.println(rtotal);
		System.out.println("How many people won from slitherin:");
		int s = scanner.nextInt();
		stotal = stotal + s;
		//System.out.println(stotal);
		System.out.println("How many people won from griffendor?");
		int g = scanner.nextInt();
		gtotal = gtotal + g;
		//System.out.println(gtotal);
		System.out.println("How many people won from hufflepuff?");
		int h = scanner.nextInt();
		htotal = htotal + h;
		//System.out.println(htotal);

		if( (stotal > rtotal)&&(stotal>gtotal)&&(stotal >htotal)){

			System.out.println("Leader in points: slitherin"); 
		}
		if( (rtotal > stotal)&&(rtotal>gtotal)&&(rtotal >htotal)){

			System.out.println("Leader in points: ravenclaw");
		}

		if( (gtotal > rtotal)&&(gtotal>stotal)&&(gtotal >htotal)){

			System.out.println("Leader in points: griffendor");

		}

		if( (htotal > rtotal)&&(htotal>gtotal)&&(htotal >stotal)){

			System.out.println("Leader in points: hufflepuff");

		}
		if((htotal==stotal)&&(htotal==gtotal)&&(htotal==rtotal)){
			System.out.println("IT IS A TIE YOU FILTHY WIZARDS");
		}
		if((htotal==Math.max(gtotal, Math.max(rtotal,stotal)))
				||(gtotal==Math.max(htotal, Math.max(rtotal,stotal)))
				||(stotal==Math.max(gtotal, Math.max(rtotal,htotal)))
				||(rtotal==Math.max(gtotal, Math.max(htotal,stotal)))){
			System.out.println("Its a tie!");
		}
		int[] array = {rtotal, stotal, gtotal, htotal};
		return array;
	}


}
