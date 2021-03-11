/**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

//class Exclusion{}

public class Affichage extends Thread{
	//static Exclusion exclusionImpression = new Exclusion();
	static semaphoreBinaire semaphoreB = new semaphoreBinaire(1);
	String texte; 

	public Affichage (String txt){
		texte=txt;
	}
	
	public synchronized void run(){
		//synchronized(exclusionImpression){
		semaphoreB.syncWait();
			for (int i=0; i<texte.length(); i++){
			    System.out.print(texte.charAt(i));
			    try {sleep(100);} catch(InterruptedException e){}
			}
		semaphoreB.syncSignal();
		//}
	}
}
