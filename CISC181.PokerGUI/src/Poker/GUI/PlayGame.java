package Poker.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.Player;
import poker.eGame;

public class PlayGame {
	private eGame gme;
	private ArrayList<Player> players = new ArrayList<Player>();

	public PlayGame(eGame gme) {
		this.gme = gme;
	}

	public eGame GetGame() {
		return this.gme;
	}

	public void AddPlayer(Player p) {
		players.add(p);
	}

	public void run() {

		playHand();

	}

	public void playHand() {
		switch (gme) {
		case FiveStudTwoJoker: {

			// Set a new deck d
			Deck d = new Deck(4);
			
			// Reset each player's hand
			for (Player p : players) {
				p.resetHand();
			}

			// Create a hand for each player
			for (Player p : players) {
				Hand h = new Hand(d);
				Hand hand = this.h;
				}
				h.HandleJokerWilds();
				p.SetHand(h);
			}

			// Player has the hand, call the playerUpdated method to set the
			// screen
			for (Player p : players) {
				p.getClient().playerUpdated(p);
				p.getClient().playerActed(p);

			}

		}

		}

	
}
