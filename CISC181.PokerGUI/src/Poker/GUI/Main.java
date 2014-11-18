package Poker.GUI;

import java.awt.EventQueue;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.plaf.TableUI;

import pokerAction.Action;
import poker.Card;
import poker.Player;
import poker.Rule;
import poker.Table;
import poker.eGame;
import pokerPlay.Client;

public class Main extends JFrame implements Client {

	/** The table. */
	private TableUI tbl;

	private Map<String, Player> players;

	/** The GridBagConstraints. */
	private GridBagConstraints gc;

	/** The board panel. */
	private BoardPanel boardPanel;

	/** The control panel. */
	private ControlPanel controlPanel;

	/** The player panels. */
	private Map<String, PlayerPanel> playerPanels;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Main window = new Main();
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		tbl = new Table();
		Rule rle = new Rule(eGame.FiveStudTwoJoker);
		PlayGame pGame = new PlayGame(eGame.FiveStudTwoJoker);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(UIConstants.TABLE_COLOR);
		setLayout(new GridBagLayout());
		
		gc = new GridBagConstraints();
		controlPanel = new ControlPanel();

		boardPanel = new BoardPanel(controlPanel, rle);
		addComponent(boardPanel, 1, 1, 1, 1);
		
		players = new LinkedHashMap<String, Player>();
		Player p1 = new Player("Bert", this);
		players.put(p1.GetPlayerID().toString(), p1);

		Player p2 = new Player("Joe", this);
		players.put(p2.GetPlayerID().toString(), p2);

		Player p3 = new Player("Jim", this);
		players.put(p3.GetPlayerID().toString(), p3);

		Player p4 = new Player("Bob", this);
		players.put(p4.GetPlayerID().toString(), p4);
	
        for (Player player : players.values()) {
        	pGame.AddPlayer(player);
        }
        
		playerPanels = new HashMap<String, PlayerPanel>();
		
		int i = 0;
		for (Player player : players.values()) {
			PlayerPanel panel = new PlayerPanel(tbl, rle, player);
			playerPanels.put(player.GetPlayerName(), panel);
			switch (i++) {
			case 0:
				// North position.
				addComponent(panel, 1, 0, 1, 1);
				break;
			case 1:
				// East position.
				addComponent(panel, 2, 1, 1, 1);
				break;
			case 2:
				// South position.
				addComponent(panel, 1, 2, 1, 1);
				break;
			case 3:
				// West position.
				addComponent(panel, 0, 1, 1, 1);
				break;
			default:
				// Do nothing.
			}
		}

		// Show the frame.
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		pGame.run();
		
	}

	private void addComponent(Component component, int x, int y, int width,
			int height) {
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 0.0;
		gc.weighty = 0.0;
		getContentPane().add(component, gc);
	}

	@Override
	public void messageReceived(String message) {
        boardPanel.setMessage(message);
        boardPanel.waitForUserInput();
		
	}

	@Override
	public void joinedTable(List<Player> players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handStarted(Player dealer) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void actorRotated(Player actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerUpdated(Player player) {
		System.out.println("PlayerUpdated in Main");
        PlayerPanel playerPanel = playerPanels.get(player.GetPlayerName());
        if (playerPanel != null) {
            playerPanel.update(player);
        }
		
	}

	@Override
	public void boardUpdated(List<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerActed(Player player) {
		// TODO Auto-generated method stub
		
	}

	public javax.swing.Action act(Set<javax.swing.Action> allowedActions) {
		// TODO Auto-generated method stub
		return null;
	}
}
