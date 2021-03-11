import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable {
	static semaphore semaphore = new semaphore(2);
	private Color myColor = Color.black;
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
    
    UnMobile(int telleLargeur, int telleHauteur) {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
    }

    public void run() {
    	int debSectionCritique = saLargeur/3;
    	int finSectionCritique = (2*saLargeur)/3;
    	while(true){
		for (sonDebDessin=0; sonDebDessin < debSectionCritique - sonPas - sonCote; sonDebDessin+= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		// Début Section Critique
		semaphore.syncWait();
		myColor = Color.red;
		for (; sonDebDessin < finSectionCritique - sonPas - sonCote; sonDebDessin+= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		myColor = Color.black;
		semaphore.syncSignal();
		// Fin Section Critique
		for (; sonDebDessin < saLargeur - sonPas - sonCote; sonDebDessin+= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		
		for (; sonDebDessin > finSectionCritique + sonPas; sonDebDessin-= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		// Début Section Critique
		semaphore.syncWait();
		myColor = Color.red;
		for (; sonDebDessin > debSectionCritique + sonPas; sonDebDessin-= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		myColor = Color.black;
		semaphore.syncSignal();
		// Fin Section Critique
		for (; sonDebDessin > 0 + sonPas; sonDebDessin-= sonPas) {
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		
		
    	}
    }

    public void paintComponent(Graphics telCG) {
		super.paintComponent(telCG);
		telCG.setColor(myColor);
		telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}