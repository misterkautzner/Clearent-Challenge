import java.util.ArrayList;

public class Wallet implements IHasInterest{
	double interest;
	ArrayList<Card> cards;
	
	@Override
	public void calculateInterest() {
		double totalCardInterest = 0;
		for (Card card : cards) {
			card.calculateInterest();
			totalCardInterest += card.getInterest();
		}
		setInterest(totalCardInterest);
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
}
