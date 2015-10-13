public class AffichageSimple implements Affichage {
	
	public AffichageSimple() {}
	
	public String affichage_tableau(Disque [] d, int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += d[i] + " " ;
		return s + "\n" ;
	}
}
