import MG2D.Couleur;
import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.Dessin;
import MG2D.geometrie.Carre;
import MG2D.geometrie.Cercle;
import MG2D.geometrie.Point;
import MG2D.geometrie.Texte;
import MG2D.geometrie.Texture;
import java.util.ArrayList;
import java.awt.Font;

public class MainGraphique {
    private int taille_fenetre;
    private int taille_plateau;
    private int taille_case;
    public Fenetre fenetre;
    private Plateau plateau;

    public MainGraphique() {
        this.taille_fenetre = 800;
        this.taille_plateau = 800;
        this.taille_case = this.taille_plateau / 8;
        this.fenetre = new Fenetre("Echec", taille_fenetre, taille_fenetre);
        this.plateau = new Plateau();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    this.fenetre.ajouter(
                            new Carre(Couleur.GRIS_FONCE, new Point(this.taille_case * i, this.taille_case * j),
                                    this.taille_case,
                                    true));

                } else {
                    this.fenetre.ajouter(
                            new Carre(Couleur.BLANC, new Point(this.taille_case * i, this.taille_case * j),
                                    this.taille_case, true));
                }
                Piece case_courante = this.plateau.getCase(i, j);
                if (case_courante != null) {
                    this.fenetre.ajouter(new Texture("./images/" + case_courante.getNomLong() +
                            ".png",
                            new Point(this.taille_case * i, this.taille_case * j), this.taille_case, this.taille_case));
                }
            }
        }
        this.fenetre.rafraichir();
    }

    public void afficherPosition(Position click) {
        Piece piece_courante = this.plateau.getCase(click.getX(), click.getY());
        if (piece_courante != null) {
            this.ajoutCercle(piece_courante.getDeplacementPossible(this.plateau));
        }
        this.fenetre.rafraichir();
    }

    public void ajoutCercle(ArrayList<Position> position) {
        for (Position pos : position) {
            this.fenetre.ajouter(new Cercle(Couleur.ROUGE, new Carre(
                    new Point(this.taille_case * pos.getX(), this.taille_case * pos.getY()), this.taille_case), false));
        }
    }

    public void miseAjour() {
        ArrayList<Dessin> dessins = this.fenetre.getP().getA();
        ArrayList<Piece> pieces = this.plateau.getPieces();

        for (Dessin dessin : dessins) {
            if (dessin instanceof Cercle) {
                this.fenetre.supprimer(dessin);
            }
            if (dessin instanceof Texture) {
                this.fenetre.supprimer(dessin);
            }
        }
        for (Piece piece : pieces) {
            this.fenetre.ajouter(new Texture("./images/" + piece.getNomLong() +
                    ".png",
                    new Point(this.taille_case * piece.getPosition().getX(),
                            this.taille_case * piece.getPosition().getY()),
                    this.taille_case, this.taille_case));
        }
        this.fenetre.rafraichir();
    }

    public static void main(String[] args) {
        MainGraphique main = new MainGraphique();
        Souris souris = main.fenetre.getSouris();
        Position from = null, to = null, clic = null;
        int tour = 0;
        String couleur[] = { "B", "N" };
        Texte echec = new Texte(Couleur.ROUGE, "Echec", new Font("TimesRoman", Font.BOLD, 100), new Point(400, 400));

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (main.plateau.estEchec(couleur[tour % 2])) {
                main.fenetre.ajouter(echec);
                main.fenetre.rafraichir();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.fenetre.supprimer(echec);
                main.fenetre.rafraichir();
            }
            if (souris.getClicGauche()) {
                clic = new Position((int) souris.getPosition().getX() / main.taille_case,
                        (int) souris.getPosition().getY() / main.taille_case);
                if (from == null) {
                    if (main.plateau.getCase(clic.getX(), clic.getY()) != null) {
                        if (main.plateau.getCase(clic.getX(), clic.getY()).getCouleur().equals(couleur[tour % 2])) {
                            from = clic;
                            main.afficherPosition(from);
                        } else {
                            System.out.println("Ce n'est pas ton tour petit malin !");
                        }
                    } else {
                        System.out.println("Il n'y a pas de pièce ici !");
                    }
                } else {
                    to = clic;
                    if (main.plateau.deplacer(from, to)) {
                        tour++;
                    }
                    from = null;
                    to = null;
                    main.miseAjour();
                    System.out.print(main.plateau);
                }
            }
            souris.reinitialisation();
        }
    }
}
