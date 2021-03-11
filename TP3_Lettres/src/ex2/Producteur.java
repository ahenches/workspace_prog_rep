package ex2;

public class Producteur extends Thread {
	private BAL bal;
	private String message;
	
	public Producteur(BAL c, String m){
		this.bal = c;
		this.message = m;
	}
	
	public void run(){
		int i = 1;
		while(true){
			message = Clavier.lireString();
			try {
				bal.setMail(message);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (message.equals("Q")  || message.equals("q")){
				
				break;
			}
			else {
				System.out.println("Message envoyé n°: "+i+": "+message);
				try {sleep(100);}
				catch(InterruptedException e){};
			}
			i++;
			
		}
		System.out.println("Le producteur est a la retraite à 35 ans");
	}

}
