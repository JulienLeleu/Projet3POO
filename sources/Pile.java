/** L'interface Pile definit le comportement de toute pile. */
public interface Pile<E> {

    /** Nombre maximal d'éléments pouvant être placés dans les instances 
     * des classes implémentant Pile (constante de classe) */
     int MAX_ELEMENTS = 12 ;

    /** Teste si la pile est vide */
    boolean vide() ;
    /** Teste si la pile est pleine */
    boolean pleine () ;
    /** Teste si on peut empiler <code>x</code> sur la pile */
    boolean peutEmpiler (E x) ;
    /** Renvoie la valeur de l'objet sur le sommet de la pile */
    E sommet() ;
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et
     * l'enlève de la pile*/
    E depile() ;
    /** Ajoute un objet sur le sommet de la pile */
    void empile(E x) ;
    /** Vide la pile */
    void vider() ;
    /** Compte le nombre d'éléments présents dans la pile */
    int nbElements() ;
    /** Déplace un élément de la pile courante vers la pile spécifiée */
    void deplacerUnElementVers(Pile<E> p) ;
    /** Chaîne contenant tous les éléments <b>depuis le sommet</b> */
    String toString() ;
}
