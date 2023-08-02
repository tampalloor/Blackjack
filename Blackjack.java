package blackjack;
import java.util.Scanner; 
public class Blackjack {
	private static String nameCards= ""; 
	private static int dealersHand;
	private static String dealersCards= ""; 
	private static int hand; 
	private int points;
	public static void dealerCorresponding(int card) {
		switch(card) {
		case 0:
			dealersCards("Ace");
			break;
		case 1:
			dealersCards("Two");
			break; 
		case 2:
			dealersCards("Three");
			break; 
		case 3:
			dealersCards("Four");
			break; 
		case 4:
			dealersCards("Five");
			break; 
		case 5:
			dealersCards("Six");
			break; 
		case 6:
			dealersCards("Seven");
			break; 
		case 7:
			dealersCards("Eight");
			break; 
		case 8:
			dealersCards("Nine");
			break; 
		case 9:
			dealersCards("Ten");
			break; 
		case 10:
			dealersCards("Jack");
			break; 
		case 11:
			dealersCards("Queen");
			break; 
		case 12:
			dealersCards("King");
			break; 
		}
	}
	public static void playerCorresponding(int card) {
		switch(card) {
		case 0:
			playerCards("Ace");
			break;
		case 1:
			playerCards("Two");
			break; 
		case 2:
			playerCards("Three");
			break; 
		case 3:
			playerCards("Four");
			break; 
		case 4:
			playerCards("Five");
			break; 
		case 5:
			playerCards("Six");
			break; 
		case 6:
			playerCards("Seven");
			break; 
		case 7:
			playerCards("Eight");
			break; 
		case 8:
			playerCards("Nine");
			break; 
		case 9:
			playerCards("Ten");
			break; 
		case 10:
			playerCards("Jack");
			break; 
		case 11:
			playerCards("Queen");
			break; 
		case 12:
			playerCards("King");
			break; 
		}
	}
	public static void dealer() {
		 int hand = (int) (Math.random()*(13)); 
		dealerCorresponding(hand);
				
		}
	public static boolean dealerBust(int hand) {
		boolean bust = false; 
		if(hand > 21) {
			formationEnd();
			System.out.println("Dealers hand was a bust! Great Job! Type start to start a new game. ");
			bust = true; 
			Scanner scnr = new Scanner(System.in);
			String input = scnr.nextLine(); 
			input.toLowerCase();
			if(input.equals("start")) {
				reset(); 
			}
		}
		return bust; 
	}
	public static boolean bust(int hand) {
		boolean bust = false;
		if(hand > 21) {
			formationEnd(); 
			System.out.println(hand + " is a Bust! Type start to start a new game. ");
			bust = true; 
			Scanner scnr = new Scanner(System.in);
			String input = scnr.nextLine(); 
			input.toLowerCase();
			if(input.equals("start")) {
				reset(); 
			}
		}
		return bust;
	}
	
	public static void randomCard() {
		int hand = (int) (Math.random()*(13)); 
		playerCorresponding(hand);
	}

		
	
	public static void moveCards() {
		Scanner input = new Scanner(System.in);
		System.out.println("Type Stand to stand.\nHit to add a card.\nDouble to double your bet. ");
		String move = input.nextLine(); 
		System.out.println();
		move = move.toLowerCase();
		if(move.equals("stand")) {
			System.out.println("You chose to stand");
			dealersEnd(); 
			end(dealersHand, hand); 
		}
		else if(move.equals("hit")) {
			randomCard(); 
		}
		else if(move.equals("double")) {
			//TODO MAKE POINTS AND DOUBLE HERE
			//moveCards(); 
		}
		else {
			moveCards(); 
		}
		
	}
	public static void start() {
		new Thread() {
			public void run() {
				dealer();
			}
		}.start();
		new Thread() {
			public void run() {
				randomCard();
			}
		}.start();
	}
	public static void formationEnd() {
		System.out.println("Your hand: ");
		System.out.println(nameCards);
		System.out.println("Total: ");
		System.out.println(hand);

		
		System.out.println("Dealers hand: ");
		System.out.println(dealersCards);
		System.out.println("Total: ");
		System.out.println(dealersHand);
	}
	public static void dealersEnd() {
		while(dealersHand <= 15) {
			dealer(); 
			formationEnd(); 
		}
		
	}
	public static void end(int dealer, int hand) {
		dealersEnd(); 
		Scanner scnr = new Scanner(System.in);
		int dealerDiff = 21 - dealer; 
		int playerDiff = 21 - hand; 
		if(dealerDiff == playerDiff) {	
			System.out.println("Push. You get your points back");
			//TODO ADD POINT SYSTEM TO EVERY BLOCK
		}
		else if(dealerDiff < playerDiff) {
			System.out.println("You lose. So bad. Type start to play again. "); 
			String input = scnr.next(); 
			input = input.toLowerCase();
			if(input.equals("start")) {
				reset(); 
			}
			else {
				System.out.println("BYE BYE ");
			}
		}
		else if(playerDiff < dealerDiff) {
			System.out.println("You win. Bet you can't do it again... Type start to ");
			String input = scnr.next(); 
			input = input.toLowerCase();
			if(input.equals("start")) {
				reset(); 
			}
			else {
				System.out.println("BYE BYE ");
			}
		}
	}
	public static void reset() {
		dealersHand = 0;
		hand = 0; 
		dealersCards = ""; 
		nameCards = ""; 
		start(); 
	}
	public static void dealersCards(String card) {
		card = card.toLowerCase(); 
		if(card.equals("ace")){
			dealersCards = dealersCards.concat("ACE (11) ");
			dealersHand = dealersHand + 11; 
			if(dealersHand > 21) {
				dealersHand = dealersHand - 10; 
				boolean busted = dealerBust(dealersHand);
				if(dealersCards.indexOf("ACE (11) ") != -1) {
					int index = dealersCards.indexOf("ACE (11)");
					//int nameCards = nameCards.subString(nameCards - ));
				}
			}
			bust(dealersHand);
		}
		else if(card.equals("two")) {
			dealersHand = dealersHand + 2;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("2 ");

		}
		else if(card.equals("three")) {
			dealersHand = dealersHand + 3;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("3 ");


		}
		else if(card.equals("four")) {
			dealersHand = dealersHand + 4;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("4 ");


		}
		else if(card.equals("five")) {
			dealersHand = dealersHand + 5;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("5 ");



		}
		else if(card.equals("six")) {
			dealersHand = dealersHand + 6;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("6 ");



		}
		else if(card.equals("seven")) {
			dealersHand = dealersHand + 7;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("7 ");


		}
		else if(card.equals("eight")) {
			dealersHand = dealersHand + 8;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("8 ");


		}
		else if(card.equals("nine")) {
			dealersHand = dealersHand + 9;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("9 ");



		}
		else if(card.equals("ten")) {
			dealersHand = dealersHand + 10;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("10 ");


		}
		else if(card.equals("jack")) {
			dealersHand = dealersHand + 10;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("JACK (10) ");


		}
		else if(card.equals("queen")) {
			dealersHand = dealersHand + 10;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("QUEEN (10) ");



		}
		else if(card.equals("king")) {
			dealersHand = dealersHand + 10;
			boolean busted = dealerBust(dealersHand);
			dealersCards = dealersCards.concat("KING (10) ");
		}
	}
	public static void playerCards(String card) {
		card = card.toLowerCase(); 
		if(card.equals("ace")){
			nameCards = nameCards.concat("ACE (11) ");
			hand = hand + 11;
			boolean busted = bust(hand);
			formation();
			if(!busted) {
				moveCards(); 
			}
			if(hand > 21) {
				hand = hand - 10; 
				formation();
				if(nameCards.indexOf("ACE (11) ") != -1) {
					int index = nameCards.indexOf("ACE (11)");
					//int nameCards = nameCards.subString(nameCards - ));
				}
			}
		}
		else if(card.equals("two")) {
			hand = hand + 2;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("2 ");
			formation();
			if(!busted) {
				moveCards(); 
			}
		}
		else if(card.equals("three")) {
			hand = hand + 3;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("3 ");
			formation();
			if(!busted) {
				moveCards(); 
			}
		}
		else if(card.equals("four")) {
			hand = hand + 4;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("4 ");
			formation();
			if(!busted) {
				moveCards(); 
			}
		}
		else if(card.equals("five")) {
			hand = hand + 5;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("5 ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("six")) {
			hand = hand + 6;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("6 ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("seven")) {
			hand = hand + 7;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("7 ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("eight")) {
			hand = hand + 8;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("8 ");
			formation();
			if(!busted) {
				moveCards(); 
			}
		}
		else if(card.equals("nine")) {
			hand = hand + 9;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("9 ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("ten")) {
			hand = hand + 10;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("10 ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("jack")) {
			hand = hand + 10;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("JACK (10) ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("queen")) {
			hand = hand + 10;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("QUEEN (10) ");
			formation();
			if(!busted) {
				moveCards(); 
			}

		}
		else if(card.equals("king")) {
			hand = hand + 10;
			boolean busted = bust(hand);
			nameCards = nameCards.concat("KING (10) ");
			formation();
			if(!busted) {
				moveCards(); 
			}
		}
		
	}
	public static void formation() {
		System.out.println("Your hand: ");
		System.out.println(nameCards);
		System.out.println("Total: ");
		System.out.println(hand);

		
		System.out.println("Dealers hand: ");
		System.out.println(dealersCards);
		System.out.println("Total: ");
		System.out.println(dealersHand);
		
		moveCards(); 
	}
	public static int points(String card) {
		return 0; 
	}
	public static void main(String[] args) { 
		reset();  
	}

}
