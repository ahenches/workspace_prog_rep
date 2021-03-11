package ex1;

public class Consommateur extends Thread {
	private BAL bal;
	private String message;
	
	public Consommateur(BAL c){
		this.bal = c;
		message = "";
	}
	
	public void run(){
		while(true){
			message = bal.getMail();
			try {sleep(1000);}
			catch(InterruptedException e){};
			if (message.equals("Q")  || message.equals("q"))
				break;
			else {
				System.out.println("Message reçu : " + message);
			}
		}
		System.out.println("Plus rien ne peut être consommé");
	}

}
