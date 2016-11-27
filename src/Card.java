
public class Card implements IHasInterest{
	
	double balance;
	double percent_interest;
	double interest;
	
	Card(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void calculateInterest() {
		setInterest(percent_interest*balance);
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getPercent_interest() {
		return percent_interest;
	}
	public void setPercent_interest(double percent_interest) {
		this.percent_interest = percent_interest;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	
}
