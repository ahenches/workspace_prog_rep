import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Affichage TA = new Affichage("AAA");
		Affichage TB = new Affichage("BB");
		Affichage TC = new Affichage("CCC");
		Affichage TD = new Affichage("DD");
		Affichage TE = new Affichage("EEEE");
		Affichage TF = new Affichage("FFFFFF");
		Affichage TG = new Affichage("GGG");

		TB.start();
		TD.start();
		TC.start();
		TA.start();
		TF.start();
		TG.start();
		TE.start();
	}

}
