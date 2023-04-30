import java.util.ArrayList;

/**
 * Cette classe permet de créer une pièce de type Fou
 * avec comme paramètre sa couleur et sa position.
 * Elle permet de gérer les déplacements possibles du Fou.
 */
public class Fou extends Piece {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe Fou.
     * elle permet de créer un fou blanc en position A1.
     */
    public Fou() {
        super("B", "A1");
    }

    /**
     * constructeur de la classe Fou.
     * elle permet de créer un fou avec comme paramètre sa couleur et
     * sa position sous forme d'objet Position.
     * 
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Fou(Position position, String couleur) {
        super(couleur, position);
    }

    /**
     * constructeur de la classe Fou.
     * elle permet de créer un fou avec comme paramètre sa couleur et
     * sa position sous forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     * @param couleur  couleur de la pièce
     */
    public Fou(String position, String couleur) {
        super(couleur, position);
    }

    // Getters //

    /**
     * méthode qui permet de récupérer le type de la pièce.
     * 
     * @return le type de la pièce
     */
    public String getType() {
        return "fou";
    }

    // Méthodes //

    /**
     * méthode qui permet de récupérer les déplacements possibles du Fou.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> deplacementPossible = new ArrayList<Position>();
        int abscissePiece = this.getPosition().getX();
        int ordonneePiece = this.getPosition().getY();
        int i = 1;
        boolean stop = false;
        while (i <= 7 - abscissePiece && i <= 7 - ordonneePiece && !stop) {
            if (plateau.getCase(abscissePiece + i, ordonneePiece + i) == null) {
                deplacementPossible.add(new Position(abscissePiece + i, ordonneePiece + i));
            } else if (plateau.getCase(abscissePiece + i, ordonneePiece + i).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece + i, ordonneePiece + i));
                stop = true;
            } else {
                stop = true;
            }
            i++;
        }
        i = 1;
        stop = false;
        while (i <= abscissePiece && i <= 7 - ordonneePiece && !stop) {
            if (plateau.getCase(abscissePiece - i, ordonneePiece + i) == null) {
                deplacementPossible.add(new Position(abscissePiece - i, ordonneePiece + i));
            } else if (plateau.getCase(abscissePiece - i, ordonneePiece + i).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece - i, ordonneePiece + i));
                stop = true;
            } else {
                stop = true;
            }
            i++;
        }
        i = 1;
        stop = false;
        while (i <= ordonneePiece && i <= 7 - abscissePiece && !stop) {
            if (plateau.getCase(abscissePiece + i, ordonneePiece - i) == null) {
                deplacementPossible.add(new Position(abscissePiece + i, ordonneePiece - i));
            } else if (plateau.getCase(abscissePiece + i, ordonneePiece - i).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece + i, ordonneePiece - i));
                stop = true;
            } else {
                stop = true;
            }
            i++;
        }
        i = 1;
        stop = false;
        while (i <= abscissePiece && i <= ordonneePiece && !stop) {
            if (plateau.getCase(abscissePiece - i, ordonneePiece - i) == null) {
                deplacementPossible.add(new Position(abscissePiece - i, ordonneePiece - i));
            } else if (plateau.getCase(abscissePiece - i, ordonneePiece - i).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece - i, ordonneePiece - i));
                stop = true;
            } else {
                stop = true;
            }
            i++;
        }
        return deplacementPossible;
    }
}
