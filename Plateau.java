import java.util.ArrayList;

/**
 * Cette classe permet de créer un plateau de jeu pour le jeu d'échec.
 * Elle contient une liste de pièces sur le plateau de jeu et l'ensemble des
 * méthodes utiles pour connaître l'état du plateau, ainsi que d'interagir avec.
 * 
 */
public class Plateau {
    private ArrayList<Piece> pieces;

    /**
     * Constructeur par défaut de la classe Plateau.
     * Il permet de créer un plateau de jeu avec les pièces à leur position de
     * départ.
     */
    public Plateau() {
        pieces = new ArrayList<Piece>();
        pieces.add(new Tour("A1", "B"));
        pieces.add(new Cavalier("B1", "B"));
        pieces.add(new Fou("C1", "B"));
        pieces.add(new Dame("D1", "B"));
        pieces.add(new Roi("E1", "B"));
        pieces.add(new Fou("F1", "B"));
        pieces.add(new Cavalier("G1", "B"));
        pieces.add(new Tour("H1", "B"));
        for (int i = 0; i < 8; i++) {
            this.pieces.add(new PionBlanc((char) ('A' + i) + "2"));
        }
        pieces.add(new Tour("A8", "N"));
        pieces.add(new Cavalier("B8", "N"));
        pieces.add(new Fou("C8", "N"));
        pieces.add(new Dame("D8", "N"));
        pieces.add(new Roi("E8", "N"));
        pieces.add(new Fou("F8", "N"));
        pieces.add(new Cavalier("G8", "N"));
        pieces.add(new Tour("H8", "N"));
        for (int i = 0; i < 8; i++) {
            this.pieces.add(new PionNoir((char) ('A' + i) + "7"));
        }
    }

    /**
     * Retourne la pièce se trouvant aux coordonnées données en paramètre si elle
     * existe sinon retourne null.
     * 
     * @param x l'abscisse de la case
     * @param y l'ordonnée de la case
     * @return la pièce se trouvant aux coordonnées données en paramètre
     */
    public Piece getCase(int x, int y) {
        for (Piece p : this.pieces) {
            if (p.getPosition().getX() == x && p.getPosition().getY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * Retourne la pièce se trouvant à la position donnée en paramètre si elle
     * existe sinon retourne null.
     * 
     * @param p la position de la case
     * @return la pièce se trouvant à la position donnée en paramètre
     */
    public Piece getCase(Position p) {
        for (Piece piece : this.pieces) {
            if (piece.getPosition().equals(p)) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Retourne la pièce se trouvant à la position donnée en paramètre si elle
     * existe sinon retourne null. La position est donnée sous forme de chaîne de
     * caractères.
     * 
     * @param p la position de la case sous forme de chaîne de caractères
     * @return la pièce se trouvant à la position donnée en paramètre
     */
    public Piece getCase(String p) {
        for (Piece piece : this.pieces) {
            if (piece.getPosition().toString().equals(p)) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Retourne une chaine de caractères représentant l'état du plateau de jeu.
     * Les pièces sont représentées par leur nom court.
     * 
     * @return une chaine de caractères représentant l'état du plateau de jeu
     */
    public String toString() {
        String affichage = "";

        for (int i = 7; i >= 0; i--) {
            affichage += " ";
            for (int j = 0; j < 8; j++) {
                affichage += "|---";
            }

            affichage += "|\n" + (i + 1);

            for (int j = 0; j < 8; j++) {
                if (this.getCase(j, i) != null) {
                    affichage += "|" + this.getCase(j, i).getNomCourt();
                } else {
                    affichage += "|   ";
                }
            }
            affichage += "|" + (i + 1) + "\n";
        }
        affichage += " ";
        for (int j = 0; j < 8; j++) {
            affichage += "|---";
        }
        affichage += "|\n   A   B   C   D   E   F   G   H\n";
        return affichage;
    }

    /**
     * Retourne une liste de pièces contenant toutes les pièces du plateau.
     * 
     * @return liste de pièces
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Retourne une liste de pièces contenant toutes les pièces blanches du plateau.
     * 
     * @return liste de pièces blanches
     */
    public ArrayList<Piece> getPiecesBlanches() {
        ArrayList<Piece> piecesBlanches = new ArrayList<Piece>();
        for (Piece p : this.pieces) {
            if (p.getCouleur() == "B") {
                piecesBlanches.add(p);
            }
        }
        return piecesBlanches;
    }

    /**
     * Retourne une liste de pièces contenant toutes les pièces noires du plateau.
     * 
     * @return liste de pièces noires
     */
    public ArrayList<Piece> getPiecesNoires() {
        ArrayList<Piece> piecesNoires = new ArrayList<Piece>();
        for (Piece p : this.pieces) {
            if (p.getCouleur() == "N") {
                piecesNoires.add(p);
            }
        }
        return piecesNoires;
    }

    /**
     * Méthodes deplacer permettant de déplacer une pièce d'une case à une autre.
     * Si la case d'arrivée est occupée par une pièce adverse, celle-ci est retirée.
     * 
     * @param from case de départ
     * @param to   case d'arrivée
     */
    public boolean deplacer(Position from, Position to) {
        Piece piecefrom = this.getCase(from);
        Piece pieceto = this.getCase(to);
        if (piecefrom != null) {
            ArrayList<Position> deplacementPossible = piecefrom.getDeplacementPossible(this);
            if (deplacementPossible.contains(to)) {
                if (pieceto != null && !(pieceto.getCouleur().equals(piecefrom.getCouleur()))) {
                    if (this.pieces.remove(pieceto)) {
                        System.out.println("Pièce adverse retirée");
                    } else {
                        System.out.println("Pièce non retirée");
                    }
                }
                piecefrom.setPosition(to);
                return true;
            } else {
                System.out.println("Déplacement non valide");
                return false;
            }
        } else {
            System.out.println("Pas de pièce sur cette case");
            return false;
        }
    }

    /**
     * méthode getRoi permettant de récupérer le roi d'une couleur donnée.
     * 
     * @param couleur couleur du roi recherché
     * @return le roi recherché
     */
    public Piece getRoi(String couleur) {
        int index = -1;
        ArrayList<Piece> liste_piece = (couleur == "B") ? this.getPiecesBlanches() : this.getPiecesNoires();
        for (Piece piece : liste_piece) {
            if (piece instanceof Roi) {
                index = liste_piece.indexOf(piece);
                break;
            }
        }
        return (index != -1) ? liste_piece.get(index) : null;
    }

    /**
     * Méthode estEchec permettant de savoir si un roi est en échec.
     * 
     * @param couleur couleur du roi
     * @return true si le roi est en échec, false sinon
     */
    public boolean estEchec(String couleur) {
        ArrayList<Piece> pieces_adverse = (couleur.equals("B")) ? this.getPiecesNoires() : this.getPiecesBlanches();
        Position roi = this.getRoi(couleur).getPosition();
        boolean echec = false;
        for (Piece piece : pieces_adverse) {
            if (piece.getDeplacementPossible(this).contains(roi)) {
                echec = true;
                break;
            }
        }
        return echec;
    }

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        System.out.print(plateau);
        plateau.deplacer(new Position("A6"), new Position("B7"));
        System.out.print(plateau);
        plateau.deplacer(new Position("B7"), new Position("B6"));
        System.out.print(plateau);
        System.out.println(plateau.getRoi("B"));
    }
}
