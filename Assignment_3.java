
public class Assignment_3 {
	/***
	 * 
	 * @param args
	 * 
	 * Decks of Cards
Understand the Class and Problem
We endeavor to set up some classes that can be used in future programs that involve playing 
card games with a human, or simulating card games entirely by a computer.  There are three  
basic classes we'll need this week:

Card:  A class like the one presented in the modules, but with a few changes.
Hand:  A class that represents the cards held by a single player.
Deck:  A class that represents the source of the cards for dealing and, as the game 
progresses, the place from which players can receive new cards (say, as they pick 
cards "from the deck" or when future hands are to be dealt from the same deck).  
Recall this picture, which relates the Deck to the various Hands that it creates through 
the process called "dealing".
Here  are eight cards, each of which contains both a value 
('A', '2', '3', ... 'T', 'J', 'Q',' K') and a suit (spades ♠, hearts ♥, diamonds ♦, clubs ♣)

Card: The Card class has two obvious members:  value (a char)  and suit (an enum).  
But we add a new boolean, errorFlag, which can inform a client that a card is in an 
illegal state. We'll want the usual constructors, mutators, accessors and toString() 
methods for the class.  We only allow standard cards, like ('A', clubs), ('9', hearts) and 
('T', diamonds), no jokers or other special cards.

Hand:  As you can see, a Hand object usually contains several cards, so we'll need an 
array of Card objects (myArray) as the principal member of the Hand class.  Since each 
game deals a different number of cards into its players hands, and even within a game 
the number of cards in a hand will increase or decrease, we must keep track of this with 
an int value (numCards).  We'll need constructors, mutators, etc., of course.  We'll also 
want a way for the hand to receive a card (from the deck or somewhere else), and play a 
card (to the table or to another player).  These two methods will be called takeCard() 
and playCard(), respectively.  Since this class has no information about the game being 
played, it always puts new cards received by takeCard() into the next available location of 
the array (index position numCards) and plays a card via playCard() from the highest occupied 
location (index position numCards - 1).  The client game application would somehow prepare this 
highest position with the correct card to be played before calling Hand's playCard() method.  
This detail is not our concern.

Deck: A Deck object is the source of all cards.  It's where the dealer gets cards to deal, 
and if a player takes an individual card after the deal, he takes it from the Deck object.  
Naturally, the primary member here is an array of Card objects, much like Hand.  We'll call 
this member cards[].  A deck normally consists of a single pack of cards: 52 cards (four 
suits of 13 values each).  However, some games use two, three or more packs.  If a card game 
requires two packs, then the deck will consist of two full 52-card packs:  104 cards.  (Many 
games throw away some cards before beginning.  For example Pinochle wants all cards with 
values 8-and-below to be taken out of the deck, but we will not trouble ourselves with this 
complexity.)  A newly instantiated deck will have a multiple of 52 cards and will contain 
all the standard cards, so the number of cards in a newly instantiated deck will be 52, 104, 
156, ...,  i.e., numPacks × 52.

Clearly, we need an int like Hand's numCards, to keep track of how many cards are actually 
in the cards[] array.  To this end, we'll use topCard (not numCards), since a deck typically 
removes and delivers cards to players from the top-of-the-deck, and this is a convenient 
variable to use for the number of cards as well as the position of the top of the deck. 

There are a few other useful members (numPacks, for example).  In addition to the the usual 
constructors and accessors, we'll want a dealCard() to return and remove the card at the top 
of the deck (which may be received by a client and added to some player's hand), and a 
shuffle() to re-order the cards in a random fashion.  Also, we'll need to restock the deck 
(init()) to the original full condition in preparation for a fresh deal (we would certainly 
not want to re-instantiate a new deck when we have a perfectly good one available:  garbage 
collection, done by us or by the operating system, is a resource we do not abuse).

**There will be one main class and three other classes.  Put everything that is needed for 
*testing in one main().  Submit only one .txt file that has all classes and output.
	 */

	public static void main(String[] args) {
		
	}
	//Phase one card class Raul
	static class Card{
		//holds the suit data
		public enum Suit { 
			clubs, diamonds, hearts, spades 
			};
		public enum State{
			deleted,active;
		};
		public static char[] VALID_VALUES1 = {
			'2','3','4','5','6','7','8',
			'9','T','J','Q','K','A','X'
		};
		//private variables
		private char value;
		private Suit suit;
		private State state1;
		private boolean errorFlag;
		//Constructor that sets suit and value for card
		public Card(char value, Suit suit){
			set(value,suit);
		}
		//default card no values set if data is bad
		//set data if errorFlag is true using mutator
		//no values set if data is bad
		public Card() {
			this('A', Suit.spades);
		}
		//mutator that accepts valid values
		public boolean set(char value, Suit suit){
			errorFlag = true;
			char upVal1 = Character.toUpperCase(value);
			if (testValue(upVal1)) {
				errorFlag = false;//false if card is valid
				this.value = upVal1;
				this.suit = suit;
			} else {}
			return !errorFlag;
		}
		//returns the state of the card
		public State getState() {
			return state1;
		}
		//set the state for the card 
		public void setState(State state1) {
			this.state1 = state1;
		}
		//return the suit
		public Suit getSuit() {
			return suit;
		}
		//return card value
		public char getValue() {
			return value;
		}
		//error flag
		public boolean getErrorFlag() {
			return errorFlag;
		}
		//Checks if two cards are equal
		public boolean equals(Card card1) {
			return (card1.getState() == state1 &&
					card1.getSuit() == suit &&
					card1.getValue() == value);
		}
		//checks if the card is valid
		private boolean testValue(char upVal1){
			for(char c1 : VALID_VALUES1) {
				if(upVal1 == c1) {
					return true;
				}
			}
			return false;
		}
		//provides clean representation of the card
		public String toString() {
			//returns the string
			String A_str;
			//checks for errorFlag if true and prints 
			//invalid card type
			if(errorFlag == true) {
				A_str = "** invalid **";
			} 
			else if (state1 == State.deleted) {
				A_str = "( deleted )";
			} 
			else {
				if (value == 'X') {
					A_str = "Joker " + (suit.ordinal() + 1);
				} 
				else {
					A_str = value + " of " + suit;
				}
			}
			return A_str;
		}
	}
	
	class Hand{
		
	}
	class Deck{
		
	}

}
