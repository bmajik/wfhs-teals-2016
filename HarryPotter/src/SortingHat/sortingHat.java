package SortingHat;

import java.util.ArrayList;
import java.util.Scanner;

public class sortingHat {
	
	 static int g = 0;
	 static int r = 0;
	 static int s = 0;
	 static int h = 0;
	 static int qCount = 0;
	 static String finalQ = "What house do you want to be in?";

	 static ArrayList<questions> q = new ArrayList<questions>();
	
	public sortingHat(ArrayList<questions> q){
		this.q = q;
	}
	
	public static  String sortMe(Scanner userInput){
		sort(userInput);
		return getHouse(userInput);
	}
	
	public static  void sort(Scanner userInput){
		
		while(qCount <= 10){
			System.out.println(getRandom());
			String answer = userInput.next();
			if(answer.equals("A")){
				g++;
			}else if(answer.equals("B")){
				r++;
			}else if(answer.equals("C")){
				s++;
			}else if(answer.equals("D")){
				h++;
			}else{
				System.out.println("Please type A, B, C, or D");
			}
			qCount++;
		}
	}
	
	public static  String getHouse(Scanner userInput){
		int max = Math.max(Math.max(g, r), Math.max(s, h));
		int houseCounter = 0;
		ArrayList<String> ties = new ArrayList<String>();
		String house = "";
		if(max == g){
			houseCounter++;
			house = "Gryffindor";
			ties.add("(A) Gryffindor");
		}else if(max == r){
			houseCounter++;
			house = "Ravenclaw";
			ties.add("(B) Ravenclaw");
		}else if(max == s){
			houseCounter++;
			house = "Slytherian";
			ties.add("(C) Slytherian");
		}else if(max == h){
			houseCounter++;
			house = "Hufflepuff";
			ties.add("(D) Hufflepuff");
		}else {
			System.out.println("Could not determine hosue at this point. Need more time.");
		}
		
		if(houseCounter > 1){
			getFinalQ(userInput, ties);
		}
		return house;
		
	}
	
	public static  void getFinalQ(Scanner userInput, ArrayList<String> ties){
		System.out.print(finalQ);
		for(int i = 0; i < ties.size(); i++){
			System.out.print(" " + ties.get(i));
		}
		String answer = userInput.next();
		if(answer.equals("A")){
			g++;
		}else if(answer.equals("B")){
			r++;
		}else if(answer.equals("C")){
			s++;
		}else if(answer.equals("D")){
			h++;
		}
		getHouse(userInput);
	}
	
	public static  questions getRandom(){
		int r = (int)(Math.random() * q.size());
		questions que = q.get(r);
		q.remove(r);
		return que;
	}
}
