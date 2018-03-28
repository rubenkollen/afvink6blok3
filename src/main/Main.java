package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {
public static String PATHWAY;
public static String sequentie = "";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String leesBestand(String bestandsNaam){
		    JFileChooser fileChooser;
    fileChooser = new JFileChooser();
        File selectedFile;
        int reply = fileChooser.showOpenDialog(null);                       //openen van bestand + lezen
        selectedFile = fileChooser.getSelectedFile();
        PATHWAY = selectedFile.toString();

        
        BufferedReader br = null;
	FileReader fr = null;
        
        try{
        fr = new FileReader(PATHWAY);
	br = new BufferedReader(fr);
        String sCurrentLine;
	while ((sCurrentLine = br.readLine()) != null) {
            if (sCurrentLine.startsWith(">")){
                sequentie = "";
        }
            else
                sequentie += sCurrentLine;
        }	
        } catch (IOException e) {
        e.printStackTrace();}
        return sequentie;
		
	} 
	
	public static double bepaalGCpercentage(String seq){
		return 0;
		
	}
	
	public static void schrijfHTMLrapport(String bestandsNaam, String seq, double GCPercentage){
		
	}

}
