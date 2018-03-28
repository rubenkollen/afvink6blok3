package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.swing.JFileChooser;

public class Main {
public static String PATHWAY;
public static String sequentie = "";
public static String bestandsNaam;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String seq = leesBestand();
		schrijfHTMLrapport(bestandsNaam, seq, bepaalGCpercentage(seq));*/

	}
	
	public static String leesBestand(){
		JFileChooser fileChooser;
		fileChooser = new JFileChooser();
        File selectedFile;
        int reply = fileChooser.showOpenDialog(null);                       //openen van bestand + lezen
        selectedFile = fileChooser.getSelectedFile();
        PATHWAY = selectedFile.toString();
        bestandsNaam = PATHWAY.split("/")[PATHWAY.split("/").length-1];
        
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
		double GC = 0;
		for(int i = 0; i < seq.length(); i++){
			if(seq.charAt(i) == 'G' || seq.charAt(i) == 'C'){
				GC++;
			}
		}
		return (double)(GC/seq.length());
		
	}
	
	public static void schrijfHTMLrapport(String bestandsNaam, String seq, double GCPercentage){
		String rapport="";
		rapport += "BestandsNaam: "+bestandsNaam+"\n";
		rapport += "Sequentie: " + seq+"\n";
		rapport += "GCpercentage: "+ GCPercentage+"\n";
		Writer writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rapport.html"), "utf-8"));
			writer.write(rapport);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
