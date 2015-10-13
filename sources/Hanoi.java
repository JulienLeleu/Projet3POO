/** Programme permettant de manipuler et d'expérimenter le problème
 *  des tours de Hanoï */
public class Hanoi 
{
    // Les trois piles représentant les tours de Hanoï
    private static PileHanoi a, b, c ;

    // Initialisation des tours pour n disques, placés au début en A
    private static void init(int n) 
    {
	a = new PileHanoi("A", new AffichageGraphique("A")) ;
	b = new PileHanoi("B", new AffichageGraphique("B")) ;
	c = new PileHanoi("joli pile", new AffichageGraphique("C")) ;
	for (int i=n; i>0; i--)
	    a.empile(new DisqueHanoi(i)) ;
    }

    // Affichage des trois tours
    public static void affiche() 
    {
		System.out.println(a) ;
		System.out.println(b) ;
		System.out.println(c) ;
    }

    // Pour le mode interactif, le choix de la pile est donné par le joueur
    // en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
    private static PileHanoi analyse(String r) 
    {
	if (r.equalsIgnoreCase("A"))
	    return a;
	else if (r.equalsIgnoreCase("B"))
	    return b;
	else
		return c;
    }
	
	public static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c) {
		a.deplacerDesDisques(a.nbElements(), b, c);
	}
	
    // Méthode principale du programme.
    public static void main (String [] arg) 
    {
	// le nombre de disques (on peut aussi le demander au joueur)
	int nbDisques = 8 ;
	
	// initialisation des piles
	init(nbDisques) ;

	boolean fini = false ;
	String rep ;
	PileHanoi depart, arrivee ;
	if (arg.length > 0 && arg[0].equals("--auto")) {
		affiche();
	    resoudreAuto(a,b,c);
	    affiche();
	}
	else {
		do {
			// on commence par afficher les tours	    
			affiche() ;
			// on demande au joueur la tour de départ (A, B, C)
			System.out.print("Déplacer de : ") ;
			rep = Clavier.readString() ;
			if (rep.equalsIgnoreCase("STOP"))
			fini = true ;
			// on en déduit l'objet correspondant
			depart = analyse(rep);
			if (!fini) 
			{
				// même chose pour la tour d'arrivée
				System.out.print("Vers : ") ;
				rep = Clavier.readString() ;
				if (rep.equalsIgnoreCase("STOP"))
				fini = true ;
				arrivee = analyse(rep) ;
				// on effectue le déplacement si c'est possible
				if (arrivee.peutEmpiler(depart.sommet()))
				depart.deplacerUnElementVers(arrivee) ;
				else
				System.out.println("Impossible !") ;
			}
			// et on continue tant que le joueur n'a pas dit STOP
		} while (!fini) ;
		System.out.println("OK, c'est fini !") ;
	}
    }
}
