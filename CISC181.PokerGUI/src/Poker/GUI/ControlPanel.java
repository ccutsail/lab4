package Poker.GUI;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pokerAction.Action.*;
import pokerAction.Action;


//import pokerAction.Actions.*;
 
public class ControlPanel extends JPanel  implements ActionListener {

    /** The Check button. */
	private final JButton btnDeal;
	private final JButton btnStart;
	private final JButton btnEnd;
	
	private final JButton btnContinue;
	private final JButton btnLeave;
	private final JButton btnSit;
	private final JButton btnDraw;
	private final JButton btnDiscard;
	private final JButton btnFold;
	
	
	
    private final Object monitor = new Object();
    
	private javax.swing.Action selectedAction;
    
	/**
	 * Create the panel.
	 */
	public ControlPanel() {
		
        setBackground(Color.blue);
        btnDeal = createActionButton(selectedAction.DEAL);
        btnStart = createActionButton(selectedAction.START);
        btnEnd = createActionButton(selectedAction.END);
        btnContinue = createActionButton(selectedAction.CONTINUE);
        btnLeave= createActionButton(selectedAction.LEAVE);
        btnSit= createActionButton(selectedAction.SIT);
        btnDraw= createActionButton(selectedAction.DRAW);
        btnDiscard= createActionButton(selectedAction.DISCARD);
        btnFold= createActionButton(selectedAction.FOLD);

	}
	
    /**
     * Waits for the user to click the Continue button.
     */
	public void waitForUserInput() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                removeAll();
                add(btnContinue);
                repaint();
            }
        });
        Set<javax.swing.Action> allowedActions = new java.util.HashSet<>();
        allowedActions.add(javax.swing.Action.CONTINUE);
        getUserInput(allowedActions.contains(CONTINUE));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnDeal) {
            selectedAction = selectedAction.DEAL;
        } else if (source == btnStart) {
            selectedAction = selectedAction.START;
        } else if (source == btnEnd) {
            selectedAction = selectedAction.END;
        }
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }
    
    
    public javax.swing.Action getUserInput(final Set<javax.swing.Action> allowedActions) {
    	System.out.println("Here");
        selectedAction = null;
        while (selectedAction == null) {
            // Show the buttons for the allowed actions.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    removeAll();
                    if (allowedActions.contains(selectedAction.CONTINUE)) {
                        add(btnContinue);
                    } else {
                        if (allowedActions.contains(selectedAction.LEAVE)) {
                            add(btnLeave);
                        }
                        if (allowedActions.contains(selectedAction.SIT)) {
                            add(btnSit);
                        }
                        if (allowedActions.contains(selectedAction.DRAW)) {
                            add(btnDraw);
                        }
                        if (allowedActions.contains(selectedAction.DISCARD)) {
                            add(btnDiscard);
                        }                        
                        if (allowedActions.contains(selectedAction.FOLD)) {
                            add(btnFold);
                        }
                    }
                    repaint();
                }
            });
            
            // Wait for the user to select an action.
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    // Ignore.
                }
            }
            

        }
        
        return selectedAction;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private JButton createActionButton(javax.swing.Action action) {
        String label = (String) action.getValue(label);
        JButton button = new JButton(label);
        button.setMnemonic(label.charAt(0));
        button.setSize(100, 30);
        button.addActionListener(this);
        return button;
    }

}
