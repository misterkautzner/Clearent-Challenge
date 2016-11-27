import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class InterestTests {

	@Test
	public void test1() {
		Person person = new Person();
		Wallet wallet = new Wallet();
		Card card1 = new VisaCard(100);
		Card card2 = new MCCard(100);
		Card card3 = new DiscoverCard(100);
		
		ArrayList<Card> wallet1Cards = new ArrayList<Card>();
		wallet1Cards.add(card1);
		wallet1Cards.add(card2);
		wallet1Cards.add(card3);
		wallet.setCards(wallet1Cards);
		
		ArrayList<Wallet> person1Wallets = new ArrayList<Wallet>();
		person1Wallets.add(wallet);
		person.setWallets(person1Wallets);
		
		person.calculateInterest();
		
		// person
		assertEquals(16.00, person.getInterest(), 0.00);
		// Visa
		assertEquals(10.00, card1.getInterest(), 0.00);
		// MC
		assertEquals(5.00, card2.getInterest(), 0.00);
		// Discover
		assertEquals(1.00, card3.getInterest(), 0.00);
	}
	
	
	@Test
	public void test2() {
		Person person = new Person();
		
		Wallet wallet1 = new Wallet();
		Card wallet1Card1 = new VisaCard(100);
		Card wallet1Card2 = new DiscoverCard(100);
		
		Wallet wallet2 = new Wallet();
		Card wallet2Card = new MCCard(100);
		
		ArrayList<Card> wallet1Cards = new ArrayList<Card>();
		wallet1Cards.add(wallet1Card1);
		wallet1Cards.add(wallet1Card2);
		wallet1.setCards(wallet1Cards);
		
		ArrayList<Card> wallet2Cards = new ArrayList<Card>();
		wallet2Cards.add(wallet2Card);
		wallet2.setCards(wallet2Cards);
		
		ArrayList<Wallet> personWallets = new ArrayList<Wallet>();
		personWallets.add(wallet1);
		personWallets.add(wallet2);
		person.setWallets(personWallets);
		
		person.calculateInterest();
		
		// person
		assertEquals(16.00, person.getInterest(), 0.00);
		// wallet 1 (Visa and Discover)
		assertEquals(11.00, wallet1.getInterest(), 0.00);
		// wallet 2 (MC)
		assertEquals(5.00, wallet2.getInterest(), 0.00);
	}
	
	
	@Test
	public void test3() {
		Person person1 = new Person();
		Wallet person1Wallet = new Wallet();
		Card p1wCard1 = new MCCard(100);
		Card p1wCard2 = new VisaCard(100);
		Card p1wCard3 = new DiscoverCard(100);
		
		Person person2 = new Person();
		Wallet person2Wallet = new Wallet();
		Card p2wCard1 = new VisaCard(100);
		Card p2wCard2 = new MCCard(100);
		
		ArrayList<Card> p1wCards = new ArrayList<Card>();
		p1wCards.add(p1wCard1);
		p1wCards.add(p1wCard2);
		p1wCards.add(p1wCard3);
		person1Wallet.setCards(p1wCards);
		
		ArrayList<Card> p2wCards = new ArrayList<Card>();
		p2wCards.add(p2wCard1);
		p2wCards.add(p2wCard2);
		person2Wallet.setCards(p2wCards);
		
		ArrayList<Wallet> person1Wallets = new ArrayList<Wallet>();
		person1Wallets.add(person1Wallet);
		person1.setWallets(person1Wallets);
		
		ArrayList<Wallet> person2Wallets = new ArrayList<Wallet>();
		person2Wallets.add(person2Wallet);
		person2.setWallets(person2Wallets);
		
		person1.calculateInterest();
		person2.calculateInterest();
		
		// person 1 (One of each card)
		assertEquals(16.00, person1.getInterest(), 0.00);
		// person 1 wallet (One of each card)
		assertEquals(16.00, person1Wallet.getInterest(), 0.00);
		
		// person 2 (Visa and MC)
		assertEquals(15.00, person2.getInterest(), 0.00);
		// person 2 wallet (Visa and MC)
		assertEquals(15.00, person2Wallet.getInterest(), 0.00);
	}


}
