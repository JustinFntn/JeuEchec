import java.util.ArrayList;

/**
 * Classe abstraite destinée à représenter les pièces de type Pion.
 * Elle contient les méthodes et attributs communs à toutes les pièces de type
 * Pion.
 */
public abstract class Pion extends Piece {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe Pion.
     * elle permet de créer un pion blanc en position A1.
     */
    public Pion() {
        super("B", "A1");
    }

    /**
     * constructeur de la classe Pion.
     * elle permet de créer un pion avec comme paramètre sa couleur et
     * sa position sous forme d'objet Position.
     * 
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Pion(Position position, String couleur) {
        super(couleur, position);
    }

    /**
     * constructeur de la classe Pion.
     * elle permet de créer un pion avec comme paramètre sa couleur et
     * sa position sous forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     * @param couleur  couleur de la pièce
     */
    public Pion(String position, String couleur) {
        super(couleur, position);
    }

    // Getters //

    /**
     * méthode qui permet de récupérer le type de la pièce.
     * 
     * @return le type de la pièce
     */
    public String getType() {
        return "pion";
    }

    // Méthodes //

    /**
     * méthode abstraite destinée à récupérer les déplacements possibles du Pion.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public abstract ArrayList<Position> getDeplacementPossible(Plateau plateau);
}
