/** Un DisqueHanoi est un objet implémentant simultanément les
 * interfaces suivantes : <UL><LI><code>Disque</code> : les disques
 * ont un diamètre spécifique</LI>
 * <LI><code>Comparable&lt;Disque&gt;</code> : les disques peuvent
 * être comparés les uns aux autres</LI></UL>
 */
public class DisqueHanoi implements Disque, Comparable<Disque> {
    // le diamètre du disque
    private int diametre = 1 ;

    /** On construit une instance de DisqueHanoi en spécifiant son diamètre
     * @param d entier positif donnant le diamètre du disque */
    public DisqueHanoi(int d) { 
	diametre = d ;
    }

    /** Affichage élémentaire d'un disque
     *  @return une chaîne donnant la valeur du diamètre */
    public String toString() { 
	return "" + diametre ; 
    }

    ////////////////////////////////////////////////////////////////
    //
    // ICI COMMENCE L'IMPLEMENTATION DE L'INTERFACE Disque
    //

    /** Retourne le diamètre du disque */
    public int diametre() { 
	return diametre ; 
    }

    ////////////////////////////////////////////////////////////////
    //
    // ICI COMMENCE L'IMPLEMENTATION DE L'INTERFACE Comparable
    //

    /** Compare l'instance courante à un autre Disque.
     * @param o un objet qui doit implémenter l'interface <code>Disque</code>
     * @return un nombre négatif si <code>o</code> est plus grand que l'instance
     * courante, positif s'il est plus petit, 0 en cas d'égalité. 
     * @see java.lang.Comparable
     */
    public int compareTo(Disque o) {
	return (diametre - o.diametre()) ;       
    }
}
