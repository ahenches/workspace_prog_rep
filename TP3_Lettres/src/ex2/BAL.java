package ex2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public  class BAL {

    // plus prosaïquement, une boulangerie est une file d'attente de 20 cases
    private BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(20) ;
    
    // on peut y déposer du pain, mais le boulanger n'est pas patient
    // si le panier de vente est plein, il s'en va
    public  boolean setMail(String string)  throws InterruptedException {
       return queue.offer(string,  200, TimeUnit.MILLISECONDS) ;
   }

    // on peut en acheter, et le client n'est pas plus patient
    // que le boulanger
    public String getMail ()  throws InterruptedException {
       return queue.poll(200, TimeUnit.MILLISECONDS) ;
   }

    // on peut interroger le stock
    public  int getStock() {
       return queue.size() ;
   }
}