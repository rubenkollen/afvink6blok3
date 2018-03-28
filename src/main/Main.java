package main;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String leesBestand(String bestandsNaam){
		return bestandsNaam;
	} 
	
	public static double bepaalGCpercentage(String seq){
		int GC = 0;
		for(int i = 0; i < seq.length(); i++){
			if(seq.charAt(i) == 'G' || seq.charAt(i) == 'C'){
				GC++;
			}
		}
		return (double)(GC/seq.length());
		
	}
	
	public static void schrijfHTMLrapport(String bestandsNaam, String seq, double GCPercentage){
		
	}

}
