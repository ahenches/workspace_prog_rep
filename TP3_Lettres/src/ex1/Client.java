package ex1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hey");
		BAL c = new BAL();
		Producteur p1 = new Producteur(c, "test");
		Consommateur c1 = new Consommateur(c);
		
		p1.start(); c1.start();
		

	}

}
