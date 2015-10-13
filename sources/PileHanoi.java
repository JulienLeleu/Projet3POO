import java.lang.*;

/** Une implémentation de l'interface Pile utilisant un tableau. À
 * noter : cette classe reste générique. */
public class PileHanoi implements Pile<DisqueHanoi> {

    private DisqueHanoi [] elements ;
    private int nbElem = 0 ;
    private String nom = "la pile" ;
    private Affichage algoAffichage = new AffichageSimple();

    /** Constructeur qui crée une pile vide */
    public PileHanoi() {
		elements = new DisqueHanoi[MAX_ELEMENTS] ;
    }

    /** Constructeur qui crée une pile vide et lui donne un nom */
    public PileHanoi(String nom) {
		elements = new DisqueHanoi[MAX_ELEMENTS] ;
		this.nom = nom ;
    }
    
    public PileHanoi(String nom, Affichage a) {
    	elements = new DisqueHanoi[MAX_ELEMENTS] ;
		this.nom = nom ;
		this.algoAffichage = a;
    }
    
    /** teste si la pile est vide */
    public boolean vide() {
		return (nbElem == 0) ;
    }
    
    /** teste si la pile est pleine */
    public boolean pleine () {
		return (nbElem == MAX_ELEMENTS) ;
    }
    
    /** teste si la pile peut empiler x */
    public boolean peutEmpiler (DisqueHanoi x) {
		return (x!=null && (vide() || (!pleine() && sommet().compareTo(x) > 0)));
    }
    
    /** renvoie la valeur de l'objet sur le sommet de la pile */
    public DisqueHanoi sommet() {
		if (vide())
			return null ;
		else return elements[nbElem-1] ;
		}
		
		/** renvoie la valeur de l'objet sur le sommet de la pile
		 * et l'enlève */
		public DisqueHanoi depile() {
		if (vide())
			return null ;
		nbElem-- ;
		return elements[nbElem] ;
    }
    
    /** ajoute un objet sur le sommet de la pile */
    public void empile(DisqueHanoi o) {
		if (peutEmpiler(o)) {
			elements[nbElem] = o ;
			nbElem++ ;
		}
    }
    
    /** vide la pile */
    public void vider() {
		nbElem = 0 ;
    }
    
    /** compte le nombre d'éléments présents dans la pile */
    public int nbElements() {
		return nbElem ;
    }

    public void deplacerUnElementVers(Pile<DisqueHanoi> p) {
		if (!vide() && p.peutEmpiler(sommet())) {
			p.empile(this.depile()) ;
			if (p instanceof PileHanoi) {
				try {
					Hanoi.affiche();
					new Thread().sleep(100);
				} catch(Exception e){}
				System.out.println("Déplacement de " + nom + " vers "
						   + ((PileHanoi) p).nom()) ;
			}
			
		}
    }
    
    /** affichage */
    public String toString() {
    	Disque [] lesDisques = new Disque[nbElem];
    	for (int i = 0; i < nbElem; i++) {
    		lesDisques[i] = elements[i];
    	}
		/*String s = nom + " : " ;
		for (int i = 0; i<nbElem; i++)
			s += elements[i] + " " ;
		return s + "\n" ;
		*/
		return nom + " : " + algoAffichage.affichage_tableau(lesDisques, nbElem);
    }
    
    //
    // METHODES PROPRES A PileHanoi
    //
		
	public void deplacerDesDisques(int n, Pile dest, Pile interm) {
		if (n!=0) {
				this.deplacerDesDisques(n-1, interm, dest);
				this.deplacerUnElementVers(dest);
				((PileHanoi)interm).deplacerDesDisques(n-1, dest, this);
		}
	}
	
    /** accès au nom de la pile */
    public String nom() { 
    	return nom;
    }
}
