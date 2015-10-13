/** L'interface Affichage permet de dissocier la manipulation des disques 
 * dans les piles (algorithme de résolution, vérification des contraintes)
 * de leur affichage (mode texte plus ou moins sophistiqué, mode graphique, ...)
 */
public interface Affichage 
{
    /** Méthode construisant une chaîne qui correspond à la façon dont
     * on veut afficher les n premiers éléments du tableau de disques */
    String affichage_tableau(Disque [] d, int n) ;
}
