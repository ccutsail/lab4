package Poker.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class Poker {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Poker window = new Poker();
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
	public Poker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 423, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel pnlPlayer1 = new JPanel();
		pnlPlayer1.setBounds(20, 11, 389, 109);
		panel.add(pnlPlayer1);
		pnlPlayer1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblCard1 = new JLabel();
		lblCard1.setIcon(new ImageIcon("C:\\Users\\Bert.Gibbons\\WorkspacePoker\\CISC181.PokerGUI\\img\\1.png"));
		
		pnlPlayer1.add(lblCard1);
		
		JLabel lblCard2 = new JLabel();
		lblCard2.setIcon(new ImageIcon("C:\\Users\\Bert.Gibbons\\WorkspacePoker\\CISC181.PokerGUI\\img\\2.png"));
		pnlPlayer1.add(lblCard2);
		
		JLabel lblCard3 = new JLabel();
		lblCard3.setIcon(new ImageIcon("C:\\Users\\Bert.Gibbons\\WorkspacePoker\\CISC181.PokerGUI\\img\\3.png"));
		pnlPlayer1.add(lblCard3);
		
		JLabel lblCard4 = new JLabel();
		lblCard4.setIcon(new ImageIcon("C:\\Users\\Bert.Gibbons\\WorkspacePoker\\CISC181.PokerGUI\\img\\4.png"));
		pnlPlayer1.add(lblCard4);
		
		JLabel lblCard5 = new JLabel();
		lblCard5.setIcon(new ImageIcon("C:\\Users\\Bert.Gibbons\\WorkspacePoker\\CISC181.PokerGUI\\img\\5.png"));
		pnlPlayer1.add(lblCard5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 131, 389, 125);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
