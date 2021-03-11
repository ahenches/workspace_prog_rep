package ex1;

public class BAL {
	private String message;
	private boolean available = false;
	
	public synchronized String getMail(){
		while (available == false){
			try {wait();}
			catch(InterruptedException e){};
		}
		available = false; notifyAll();
		return message;
	}
	public synchronized void setMail(String m){
		while(available==true){
			try {wait();}
			catch(InterruptedException e){};
		}
		message = m;
		available = true;
		notifyAll();
	}

}
