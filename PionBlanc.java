import java.util.ArrayList;

/**
 * Cette classe permet de créer une pièce de type Pion et de couleur blanche
 * avec comme paramètre sa position.
 * Elle permet de gérer les déplacements possibles d'un pion blanc.
 */
public class PionBlanc extends Pion {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe PionBlanc.
     * elle permet de créer un pion blanc en position A1.
     */
    public PionBlanc() {
        super();
    }

    /**
     * constructeur de la classe PionBlanc.
     * elle permet de créer un pion blanc avec comme paramètre sa position sous
     * forme d'objet Position.
     * 
     * @param position la position de la pièce
     */
    public PionBlanc(Position position) {
        super(position, "B");
    }

    /**
     * constructeur de la classe PionBlanc.
     * elle permet de créer un pion blanc avec comme paramètre sa position sous
     * forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     */
    public PionBlanc(String position) {
        super(position, "B");
    }

    // Méthodes //

    /**
     * méthode qui permet de récupérer les déplacements possibles d'un pion blanc.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> deplacementPossible = new ArrayList<Position>();
        int abscissePiece = this.getPosition().getX();
        int ordonneePiece = this.getPosition().getY();

        if (ordonneePiece == 1) {
            for (int i = 1; i < 3; i++) {
                if (plateau.getCase(abscissePiece, ordonneePiece + i) == null) {
                    deplacementPossible.add(new Position(abscissePiece, ordonneePiece + i));
                }
            }
        } else if (plateau.getCase(abscissePiece, ordonneePiece + 1) == null && ordonneePiece < 7) {
            deplacementPossible.add(new Position(abscissePiece, ordonneePiece + 1));
        }

        if (plateau.getCase(abscissePiece + 1, ordonneePiece + 1) != null) {
            if (plateau.getCase(abscissePiece + 1, ordonneePiece + 1).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece + 1, ordonneePiece + 1));
            }
        }
        if (plateau.getCase(abscissePiece - 1, ordonneePiece + 1) != null) {
            if (plateau.getCase(abscissePiece - 1, ordonneePiece + 1).getCouleur() != this.getCouleur()) {
                deplacementPossible.add(new Position(abscissePiece - 1, ordonneePiece + 1));
            }
        }
        return deplacementPossible;
    }

}
