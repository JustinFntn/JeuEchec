import java.util.ArrayList;

/**
 * Cette classe permet de créer une pièce de type Roi
 * avec comme paramètre sa couleur et sa position.
 * Elle permet de gérer les déplacements possibles du Roi.
 */
public class Roi extends Piece {

    // Constructeurs //

    /**
     * constructeur par défaut de la classe Roi.
     * elle permet de créer un roi blanc en position A1.
     */
    public Roi() {
        super("B", "A1");
    }

    /**
     * constructeur de la classe Roi.
     * elle permet de créer un roi avec comme paramètre sa couleur et
     * sa position sous forme d'objet Position.
     * 
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Roi(Position position, String couleur) {
        super(couleur, position);
    }

    /**
     * constructeur de la classe Roi.
     * elle permet de créer un roi avec comme paramètre sa couleur et
     * sa position sous forme de chaîne de caractères.
     * 
     * @param position position de la pièce
     * @param couleur  couleur de la pièce
     */
    public Roi(String position, String couleur) {
        super(couleur, position);
    }

    // Getters //

    /**
     * méthode qui permet de récupérer le type de la pièce.
     * 
     * @return le type de la pièce
     */
    public String getType() {
        return "roi";
    }

    // Méthodes //

    /**
     * méthode qui permet de récupérer les déplacements possibles du Roi.
     * 
     * @param plateau plateau de jeu
     * @return l'arraylist des déplacements possibles de la pièce
     */
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> deplacementPossible = new ArrayList<Position>();
        int abscissePiece = this.getPosition().getX();
        int ordonneePiece = this.getPosition().getY();
        for (int i = abscissePiece - 1; i <= abscissePiece + 1; i++) {
            for (int j = ordonneePiece - 1; j <= ordonneePiece + 1; j++) {
                if ((i >= 0 && i <= 7 && j >= 0 && j <= 7) && (plateau.getCase(i, j) == null
                        || plateau.getCase(i, j).getCouleur() != this.getCouleur()))
                    deplacementPossible.add(new Position(i, j));
            }
        }
        return deplacementPossible;
    }

    public static void main(String[] args) {
        Roi roi = new Roi();
        System.out.println(roi.equals(roi));
    }
}