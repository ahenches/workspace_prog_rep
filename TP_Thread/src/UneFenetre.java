import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener{
	ArrayList<UnMobile> mobiles = new ArrayList<UnMobile>();
	ArrayList<JButton> boutons = new ArrayList<JButton>();
	ArrayList<Thread> threads = new ArrayList<Thread>();
	boolean []isSuspended;
    private final int LARG = 1000, HAUT = 250, NBRLIG = 8, NBRCOL = 2;
    
    public UneFenetre() {
    	Container leConteneur = getContentPane();
    	leConteneur.setLayout (new GridLayout(NBRLIG, NBRCOL));
    	isSuspended = new boolean[NBRLIG];
    	for(int i = 0; i<NBRLIG;i++){
    		UnMobile sonMobile = new UnMobile(LARG, HAUT);
    		JButton sonBouton = new JButton ("Start/Stop");
    		Thread sonThread = new Thread(sonMobile);
    		sonBouton.addActionListener(this);
        	leConteneur.add(sonBouton);
        	leConteneur.add(sonMobile);
    		mobiles.add(sonMobile);
    		boutons.add(sonBouton);
    		threads.add(sonThread);
    		isSuspended[i] = false;
    		sonThread.start();
    	}
		// afficher la fenetre
	    setSize(LARG, HAUT);
	    setVisible(true);
    }

	public void actionPerformed(ActionEvent event) {
		
		int index = boutons.indexOf(event.getSource());
		Thread threadCible = threads.get(index);
		if (isSuspended[index]){
			threadCible.resume();
			isSuspended[index] = false;
		}
		else {
			threadCible.suspend();
			isSuspended[index] = true;
			
		}
		
	}
}
