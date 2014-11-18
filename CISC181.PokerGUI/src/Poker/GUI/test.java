package Poker.GUI;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JRadioButtonMenuItem rdbtnmntmCardJoker = new JRadioButtonMenuItem("5 Card Joker");
		rdbtnmntmCardJoker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//restart the game!
			}
		});
		mnGame.add(rdbtnmntmCardJoker);
		
		JRadioButtonMenuItem rdbtnmntmCardStud = new JRadioButtonMenuItem("5 Card Stud");
		mnGame.add(rdbtnmntmCardStud);
	
		ButtonGroup menuGroup = new ButtonGroup();
		menuGroup.add(rdbtnmntmCardStud);
		menuGroup.add(rdbtnmntmCardJoker);
		
	}

}
