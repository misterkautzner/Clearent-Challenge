import java.util.ArrayList;

public class Person implements IHasInterest{
	double interest;
	ArrayList<Wallet> wallets;
	
	@Override
	public void calculateInterest() {
		double totalWalletInterest = 0;
		for(Wallet wallet : wallets) {
			wallet.calculateInterest();
			totalWalletInterest += wallet.getInterest();
		}
		setInterest(totalWalletInterest);
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public ArrayList<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(ArrayList<Wallet> wallets) {
		this.wallets = wallets;
	}
	

}
