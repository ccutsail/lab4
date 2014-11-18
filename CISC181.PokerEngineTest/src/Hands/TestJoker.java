package Hands;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class TestJoker {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void TestRoyalFlush() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);		
		
		assertEquals("Should be rf:",eHandStrength.RoyalFlush.getHandStrength(),h.getHandStrength());	
		assertEquals("Should be natrual:",1,h.getNatural());
	}
	
	@Test
	public final void TestJokerRoyalFlush() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);				
		
		assertEquals("Should be rf:",eHandStrength.RoyalFlush.getHandStrength(),h.getHandStrength());
		assertEquals("Should not be natrual:",0,h.getNatural());
		
		
	}	

	@Test
	public final void TestJokerFourOfAKind() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.ACE));
		rfHand.add(new Card(eSuit.SPADES,eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS,eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);				
		
		assertEquals("Should be rf:",eHandStrength.FourOfAKind.getHandStrength(),h.getHandStrength());
		assertEquals("Should not be natrual:",0,h.getNatural());
		
		
	}	

	@Test
	public final void TestJokerThreeOfAKind() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.ACE));
		rfHand.add(new Card(eSuit.SPADES,eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS,eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);				
		
		assertEquals("Should be rf:",eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandStrength());
		assertEquals("Should not be natrual:",0,h.getNatural());		
		
	}
	
	@Test
	public final void TestTwoJokersThreeOfAKind() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.ACE));
		rfHand.add(new Card(eSuit.SPADES,eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS,eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);				
		
		assertEquals("Should be rf:",eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandStrength());
		assertEquals("Should not be natrual:",0,h.getNatural());		
		
	}	
	@Test
	public final void TestJokerStraightFlush() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER,eRank.JOKER));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.NINE));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.TEN));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.JACK));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.KING));
		Hand h = Hand.EvalHand(rfHand);				
		
		assertEquals("Should be sf:",eHandStrength.StraightFlush.getHandStrength(),h.getHandStrength());
		assertEquals("Should not be natrual:",0,h.getNatural());		
		
	}	
}










