import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * B0344235 簡名浩
 * Try to write some comments for your codes (methods, 10 points)
 * ~~~Card.java~~~
 * 1. 新增 Suit 為列舉型態，其中放入四種花色。
 * 2. suit 原先為整數型態並使用 1～4 來代表四種花色，現在直接使用 Suit 列舉。
 * 3. 建構式：修改第一個傳入的參數為 Suit 列舉。
 * 4. getSuit()：將回傳值型態改為 Suit 列舉。
 * 5. printCard()：由於已將 suit 改為 Suit 列舉型態，故需要把第一個 switch case
 * 				        中的 case 判斷式改為列舉中的四種花色。
 * ~~~Deck.java~~~
 * 1. 新增 usedCard 及 nUsed 分別計算用過的卡片以及使用了幾張卡片。
 * 2. 建構式：由於定義在 Card 的花色改為列舉型態，故需要把第二個迴圈（用來產生花色）
 * 			    的參數改為 Card.Suit i : Card.Suit.values()，代表從第一種花色跑到最後
 * 			    一種花色，最後進行一次洗牌工作（shuffle()）。
 * 3. 新增 shuffle() 洗牌方法：使用 Java 內建的 Random 方法亂數產生一個參數 j 代表隨機
 * 							    挑的一張牌在排組中的位置，然後用 get() 與 add() 把那張牌
 * 							    取出來並放到牌組最後面，最後利用 ArrayList 刪除元素後會
 * 							    自動補上的特性 remove 掉原本的位置，這樣就可以完成洗牌。
 * 4. 新增 getOneCard() 方法：從牌組發一張牌，然後把那張牌紀錄到 usedCard 中，最後
 * 							 nUsed 值加一，紀錄 cards 中的牌發到哪個位置。
 */
public class HW3 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String testn= sc.nextLine(); 
		int nDeck=1;
		//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
		Deck deck=new Deck(nDeck);
		
		//TODO: please check your output, make sure that you print newCard and newCard2 on your screen  (10 points)
		//TODO: please add new fields and methods to Card class (25)
		//Use enumerated type in Card (10 points)
		//Constructor (5 points)
		//printCard (5 points)
		//getSuit (5 points)
		Card newCard=deck.getOneCard();
		newCard.printCard();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		deck.shuffle();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52||checkHash.keySet().size()==50){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
