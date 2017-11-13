public class Card {
	public enum Suit {Club, Diamond, Heart, Spade}
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s, int r) {
		suit = s;
		rank = r;
	}	
	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard() {
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		switch(getSuit()) {
		case 1:
			System.out.print("Clubs ");
			break;
		case 2:
			System.out.print("Diamonds ");
			break;
		case 3:
			System.out.print("Hearts ");
			break;
		case 4:
			System.out.print("Spades ");
			break;
		default:
			System.out.print("N/A ");
		}
		
		switch(getRank()) {
		case 1:
			System.out.println("Ace");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		case 11:
			System.out.println("Jack");
			break;
		case 12:
			System.out.println("Queen");
			break;
		case 13:
			System.out.println("King");
			break;
		default:
			System.out.println("N/A");
		}

	}
	
	public enum getSuit() {
		return Suit;
	}
	
	public int getRank() {
		return rank;
	}
}