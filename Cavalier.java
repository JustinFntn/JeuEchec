import java.util.ArrayList;

/**
 * Cette classe permet de créer une pièce de type Cavalier
 * avec comme paramètre sa couleur et sa position.
 * Elle permet de gérer les déplacements possibles du cavalier.
 */
public class Cavalier extends Piece {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe Cavalier.
     * elle permet de créer un cavalier blanc en position A1.
     */
    public Cavalier() {
        super("B", "A1");
    }

    /**
     * constructeur de la classe Cavalier.
     * elle permet de créer un cavalier avec comme paramètre sa couleur et
     * sa position sous forme d'objet Position.
     * 
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Cavalier(Position position, String couleur) {
        super(couleur, position);
    }

    /**
     * constructeur de la classe Cavalier.
     * elle permet de créer un cavalier avec comme paramètre sa couleur et
     * sa position sous forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     * @param couleur  couleur de la pièce
     */
    public Cavalier(String position, String couleur) {
        super(couleur, position);
    }

    // Getters //

    /**
     * méthode qui permet de récupérer le type de la pièce.
     * 
     * @return le type de la pièce
     */
    public String getType() {
        return "cavalier";
    }

    // Méthodes //

    /**
     * méthode qui permet de récupérer les déplacements possibles du Cavalier.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        int abscissePiece = this.getPosition().getX();
        int ordonneePiece = this.getPosition().getY();
        ArrayList<Position> deplacementPossible = new ArrayList<Position>();
        ArrayList<Position> deplacement = new ArrayList<>();
        if (abscissePiece + 2 <= 7 && ordonneePiece + 1 <= 7)
            deplacement.add(new Position(abscissePiece + 2, ordonneePiece + 1));
        if (abscissePiece + 2 <= 7 && ordonneePiece - 1 >= 0)
            deplacement.add(new Position(abscissePiece + 2, ordonneePiece - 1));
        if (abscissePiece + 1 <= 7 && ordonneePiece + 2 <= 7)
            deplacement.add(new Position(abscissePiece + 1, ordonneePiece + 2));
        if (abscissePiece - 1 >= 0 && ordonneePiece + 2 <= 7)
            deplacement.add(new Position(abscissePiece - 1, ordonneePiece + 2));
        if (abscissePiece + 1 <= 7 && ordonneePiece - 2 >= 0)
            deplacement.add(new Position(abscissePiece + 1, ordonneePiece - 2));
        if (abscissePiece - 1 >= 0 && ordonneePiece - 2 >= 0)
            deplacement.add(new Position(abscissePiece - 1, ordonneePiece - 2));
        if (abscissePiece - 2 >= 0 && ordonneePiece - 1 >= 0)
            deplacement.add(new Position(abscissePiece - 2, ordonneePiece - 1));
        if (abscissePiece - 2 >= 0 && ordonneePiece + 1 <= 7)
            deplacement.add(new Position(abscissePiece - 2, ordonneePiece + 1));
        for (Position pos : deplacement) {
            if (pos.getX() >= 0 && pos.getX() <= 7 && pos.getY() >= 0 && pos.getY() <= 7) {
                if (plateau.getCase(pos.getX(), pos.getY()) == null
                        || plateau.getCase(pos.getX(), pos.getY()).getCouleur() != this.getCouleur()) {
                    deplacementPossible.add(pos);
                }
            }
        }
        return deplacementPossible;
    }
}
