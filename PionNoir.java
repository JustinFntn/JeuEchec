import java.util.ArrayList;

/**
 * Cette classe permet de créer une pièce de type Pion et de couleur noire
 * avec comme paramètre sa position.
 * Elle permet de gérer les déplacements possibles d'un pion noir.
 */
public class PionNoir extends Pion {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe PionNoir.
     * elle permet de créer un pion noir en position A8.
     */
    public PionNoir() {
        super("A8", "N");
    }

    /**
     * constructeur de la classe PionNoir.
     * elle permet de créer un pion noir avec comme paramètre sa position sous
     * forme d'objet Position.
     * 
     * @param position la position de la pièce
     */
    public PionNoir(Position position) {
        super(position, "N");
    }

    /**
     * constructeur de la classe PionNoir.
     * elle permet de créer un pion noir avec comme paramètre sa position sous
     * forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     */
    public PionNoir(String position) {
        super(position, "N");
    }

    // Méthodes //

    /**
     * méthode qui permet de récupérer les déplacements possibles d'un pion noir.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> deplacementPossible = new ArrayList<Position>();
        int abscissePiece = this.getPosition().getX();
        int ordonneePiece = this.getPosition().getY();

        if (ordonneePiece == 6) {
            for (int i = 1; i < 3; i++) {
                if (plateau.getCase(abscissePiece, ordonneePiece - i) == null) {
                    deplacementPossible.add(new Position(abscissePiece, ordonneePiece - i));
                }
            }
        } else if (plateau.getCase(abscissePiece, ordonneePiece - 1) == null && ordonneePiece > 0) {
            deplacementPossible.add(new Position(abscissePiece, ordonneePiece - 1));
        }

        if (plateau.getCase(abscissePiece + 1, ordonneePiece - 1) != null) {
            if (plateau.getCase(abscissePiece + 1, ordonneePiece - 1).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece + 1, ordonneePiece - 1));
            }
        }
        if (plateau.getCase(abscissePiece - 1, ordonneePiece - 1) != null) {
            if (plateau.getCase(abscissePiece - 1, ordonneePiece - 1).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece - 1, ordonneePiece - 1));
            }
        }
        return deplacementPossible;
    }
}
