package SortingHat;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		Scanner userInput= new Scanner(System.in);
		questions q15 = new questions("Which of the following would you most hate people to call you?", "Cowardly", "Ignorant", "Ordinary", "Selfish"

	);
	questions q1 = new questions("After you have died, what would you most like people to do when they hear your name?", "Ask for more stories about your adventures", "Think with admiration of your achievements", "I don’t care what people think of me after I’m dead; it’s what they think of me while I’m alive that counts", "Miss you, but smile"
	);
	questions q2 = new questions( "Given the choice, would you rather invent a potion that would guarantee you:", "Glory", "Wisdom", "Power", "Love"
	);
	questions q3 = new questions("How would you like to be known to history?", "The Bold", "The Wise", "The Great", "The Good");
	questions q4 = new questions("You enter an enchanted garden. What would you be most curious to examine first?", "The statue of an old wizard with a strangely twinkling eye", "The silver leafed tree bearing golden apples", "The bubbling pool, in the depths of which something luminous is swirling", "The fat red toadstools that appear to be talking to each other"
	);
	questions q5 = new questions("Four goblets are placed before you. Which would you choose to drink?", "The golden liquid so bright that it hurts the eye, and which makes sunspots dance all around the room", "The foaming, frothing, silvery liquid that sparkles as though containing ground diamonds", "The mysterious black liquid that gleams like ink, and gives off fumes that make you see strange visions", "The smooth, thick, richly purple drink that gives off a delicious smell of chocolate and plums"
	);
	questions q6 = new questions("Once every century, the Flutterby bush produces flowers that adapt their scent to attract the unwary. If it lured you, it would smell of:", "A crackling log fire", "Fresh parchment", "The sea", "Home"
	);
	questions q7 = new questions("Which would you rather be:", "Praised", "Imitated", "Envied", "Liked");
	questions q8 = new questions("What are you most looking forward to learning at Hogwarts?", "Secrets about the castle", "Every area of magic I can", "Hexes and jinxes", "All about magical creatures, and how to befriend/care for them"
	);
	questions q9 = new questions("If you could have any power, which would you choose?", "The power of superhuman strength", "The power to read minds", "The power to change the past", "The power to speak to animals"
	);
	questions q10 = new questions("You and two friends need to cross a bridge guarded by a river troll who insists on fighting one of you before he will let all of you pass. Do you:", "Volunteer to fight", "Attempt to confuse the troll into letting all three of you pass without fighting", "Suggest that all three of you should fight (without telling the troll)", "Suggest drawing lots to decide which of you will fight"
	);
	questions q11 = new questions("Which road tempts you most?", "The twisting, leaf-strewn path through woods", "The cobbled street lined with ancient buildings", "The narrow, dark, lantern-lit alley", "The wide, sunny, grassy lane"
	);
	questions q12 = new questions("Which nightmare would frighten you most?", "An eye at the keyhole of the dark, windowless room in which you are locked", "Standing on top of something very high and realizing suddenly that there are no hand- or footholds, nor any barrier to stop you falling", "Being forced to speak in such a silly voice that hardly anyone can understand you, and everyone laughs at you", "Waking up to find that neither your friends nor your family have any idea who you are"
	);
	questions q13 = new questions("Late at night, walking alone down the street, you hear a peculiar cry that you believe to have a magical source. Do you:", "Draw your wand and stand your ground?", "Withdraw into the shadows to await developments, while mentally reviewing the most appropriate defensive and offensive spells, should trouble occur", "Draw your wand and try to discover the source of the noise", "Proceed with caution, keeping one hand on your concealed wand and an eye out for any disturbance"
	);
	questions q14 = new questions("A Muggle confronts you and says that they are sure you are a witch or wizard. Do you:", "Agree, and walk away, leaving them to wonder whether you are bluffing", "Ask what makes them think so", "Agree, and ask whether they’d like a free sample of a jinx", "Tell them that you are worried about their mental health, and offer to call a doctor"
	);

//	System.out.println(q3);
		ArrayList<questions> q = new ArrayList<>();
		
		q.add(q1);
		q.add(q2);
		q.add(q3);
		q.add(q4);
		q.add(q5);
		q.add(q6);
		q.add(q7);
		q.add(q8);
		q.add(q9);
		q.add(q10);
		q.add(q11);
		q.add(q12);
		q.add(q13);
		q.add(q14);
		q.add(q15);
		
		
		sortingHat sh = new sortingHat(q);
		System.out.println(sortingHat.sortMe(userInput));
	}

}
