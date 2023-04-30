import java.util.ArrayList;

/**
 * Classe abstraite destinée à représenter l'ensemble des pièces.
 * Elle contient les méthodes et attributs communs à toutes les pièces du jeu
 * d'échec.
 */
public abstract class Piece {
    // attributs //

    private String couleur;
    private Position position;

    public abstract ArrayList<Position> getDeplacementPossible(Plateau plateau);

    // Constructeurs //

    /**
     * constructeur par défaut de la classe Piece.
     * elle permet de créer une pièce de couleur blanche et en
     * position A1.
     */
    public Piece() {
        this.couleur = "B";
        this.position = new Position(0, 1);
    }

    /**
     * constructeur par copie de la classe Piece.
     * elle permet de créer une pièce en copiant une autre pièce.
     * 
     * @param p la pièce à copier
     */
    public Piece(Piece p) {
        this.couleur = p.getCouleur();
        this.position = new Position(p.getPosition());
    }

    /**
     * constructeur de la classe Piece.
     * elle permet de créer une pièce avec comme paramètre sa couleur et des
     * coordonnées pour la position.
     * 
     * @param couleur la couleur de la pièce
     * @param x       l'abscisse de la pièce
     * @param y       l'ordonnée de la pièce
     */
    public Piece(String couleur, int x, int y) {
        if ((couleur == "N" || couleur == "B")) {
            this.couleur = couleur;
            this.position = new Position(x, y);
        } else {
            System.out.println("Type de pièce non valide");
        }
    }

    /**
     * constructeur de la classe Piece.
     * elle permet de créer une pièce avec comme paramètre son type, sa couleur et
     * sa position sous forme d'objet Position.
     *
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Piece(String couleur, Position position) {
        if (couleur == "N" || couleur == "B") {
            this.couleur = couleur;
            this.position = new Position(position);
        } else {
            System.out.println("Couleur de pièce non valide");
        }
    }

    /**
     * constructeur de la classe Piece.
     * elle permet de créer une pièce avec comme paramètre son type, sa couleur et
     * sa position sous forme de chaîne de caractères.
     * 
     * @param couleur  la couleur de la pièce
     * @param position la position de la pièce
     */
    public Piece(String couleur, String position) {
        if (couleur == "N" || couleur == "B") {
            this.couleur = couleur;
            this.position = new Position(position);
        } else {
            System.out.println("Couleur de pièce non valide");
        }
    }

    // Getters //

    /**
     * méthode abstraite destinée à retourner le type de la pièce.
     * 
     * @return le type de la pièce
     */
    public abstract String getType();

    /**
     * retourne la couleur de la pièce.
     * 
     * @return la couleur de la pièce
     */
    public String getCouleur() {
        return this.couleur;
    }

    /**
     * retourne la position de la pièce.
     * 
     * @return la position de la pièce
     */
    public Position getPosition() {
        return this.position;
    }

    // Setters //

    /**
     * modifie la couleur de la pièce.
     * 
     * @param couleur la nouvelle couleur de la pièce
     */
    public void setCouleur(String couleur) {
        if (couleur == "N" || couleur == "B") {
            this.couleur = couleur;
        } else {
            System.out.println("Couleur de pièce non valide");
        }
    }

    /**
     * modifie la position de la pièce.
     * 
     * @param position la nouvelle position de la pièce
     */
    public void setPosition(Position position) {
        this.position = new Position(position);
    }

    // Méthodes //

    /**
     * retourne le "nom court" de la pièce.
     * La chaine de caractères retournée est de la forme,
     * 2 premières lettres du type et première lettre de la couleur.
     * 
     * @return une chaîne de caractères représentant le "nom court" de la pièce
     */
    public String getNomCourt() {
        return this.getType().substring(0, 2) + this.couleur;
    }

    /**
     * retourne le "nom long" de la pièce.
     * La chaine de caractères retournée est de la forme,
     * le type et la première lettre de la couleur de la pièce
     * séparés par un underscore.
     * 
     * @return une chaîne de caractères représentant le "nom long" de la pièce
     */
    public String getNomLong() {
        return this.getType() + "_" + this.couleur;
    }

    /**
     * teste l'égalité entre une pièce et un objet passé en paramètre.
     * 
     * @param p vrai si l'objet passé en paramètre est une pièce identique.
     */
    public boolean equals(Object p) {
        if (p instanceof Piece) {
            Piece piece = (Piece) p;
            return (this.getType() == piece.getType() && this.couleur == piece.getCouleur()
                    && this.position.equals(piece.getPosition()));
        } else {
            return false;
        }
    }

    /**
     * retourne une chaîne de caractères représentant la pièce
     * avec son type, sa couleur et sa position.
     * 
     * @return une chaîne de caractères représentant la pièce
     */
    public String toString() {
        return this.getType().toLowerCase() + " " + this.couleur.toLowerCase() + " en " + this.position.toString();
    }

}
