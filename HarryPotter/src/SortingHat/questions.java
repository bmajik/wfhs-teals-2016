package SortingHat;

public class questions {

	String q = "";
	String a1 = "";
	String a2 = "";
	String a3 = "";
	String a4 = "";
	
	public questions(String q, String a1, String a2, String a3, String a4){
		this.q = q;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
	}
	@Override
	public String toString(){
		return q + "\n (A)" + a1 + "\n (B)" + a2 + "\n (C)" + a3 + "\n (D)" + a4;
	}
	
	public String question(){
		return q;
	}
	
	public  String answer1(){
		return a1;
	}
	
	public  String answer2(){
		return a2;
	}
	
	public  String answer3(){
		return a3;
	}

	public  String answer4(){
		return a4;
	}	
}
