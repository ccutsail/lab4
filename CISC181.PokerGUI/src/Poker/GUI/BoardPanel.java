package Poker.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import poker.Card;
import PokerEngineTest.Hands.Rule;

/**
 * Board panel with the community cards and general information.
 * 
 */
public class BoardPanel extends JPanel {

	/** The maximum number of community cards. */
	private static final int NO_OF_CARDS = 5;

	/** The control panel. */
	private final ControlPanel controlPanel;

	/** Labels with the community cards. */
	private  JLabel[] cardLabels;

	/** Label with a custom message. */
	private final JLabel messageLabel;

	/**
	 * Constructor.
	 * 
	 * @param controlPanel
	 *            The control panel.
	 */
	public BoardPanel(ControlPanel controlPanel, Rule rle) {
		this.controlPanel = controlPanel;

		setBorder(UIConstants.PANEL_BORDER);
		setBackground(Color.red);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		if (rle.GetCommunityCardsCount() > 0) {

			// The five card positions.
			cardLabels = new JLabel[NO_OF_CARDS];
			for (int i = 0; i < 5; i++) {
				cardLabels[i] = new JLabel(
						ResourceManager.getIcon("/img/card_placeholder.png"));
				gc.gridx = i;
				gc.gridy = 2;
				gc.gridwidth = 1;
				gc.gridheight = 1;
				gc.anchor = GridBagConstraints.CENTER;
				gc.fill = GridBagConstraints.NONE;
				gc.weightx = 0.0;
				gc.weighty = 0.0;
				gc.insets = new Insets(5, 1, 5, 1);
				add(cardLabels[i], gc);
			}
		}

		// Message label.
		messageLabel = new JLabel();
		messageLabel.setForeground(Color.YELLOW);
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 5;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(0, 0, 0, 0);
		add(messageLabel, gc);

		// Control panel.
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 5;
		gc.gridheight = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		add(controlPanel, gc);

		setPreferredSize(new Dimension(400, 270));

		if (rle.GetCommunityCardsCount() > 0) {
			updatePanel(null);	
		}
		
	}

	/**
	 * Updates the current hand status.
	 */
	public void updatePanel(List<Card> cards) {
		System.out.println("Herexx");
		int noOfCards = (cards == null) ? 0 : cards.size();
		for (int i = 0; i < NO_OF_CARDS; i++) {
			if (i < noOfCards) {
				cardLabels[i]
						.setIcon(ResourceManager.getCardImage(cards.get(i)));
			} else {
				cardLabels[i].setIcon(ResourceManager
						.getIcon("/img/card_placeholder.png"));
			}
		}
	}

	/**
	 * Sets a custom message.
	 * 
	 * @param message
	 *            The message.
	 */
	public void setMessage(String message) {
		if (message.length() == 0) {
			messageLabel.setText(" ");
		} else {
			messageLabel.setText(message);
		}
	}

	/**
	 * Waits for the user to continue.
	 */
	public void waitForUserInput() {
		controlPanel.waitForUserInput();
	}

}