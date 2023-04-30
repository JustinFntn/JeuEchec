/**
 * 
 */
public class Position {
    private int x;
    private int y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(Position p) {
        x = p.getX();
        y = p.getY();
    }

    public Position(int x, int y) {
        if (x >= 0 && y >= 0 && x <= 7 && y <= 7) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Position non valide");
        }
    }

    public Position(String s) {
        if (s.length() == 2) {
            char lettre = s.charAt(0);
            int chiffre = Integer.parseInt(s.substring(1));
            if (lettre >= 'A' && lettre <= 'H' && chiffre >= 1 && chiffre <= 8) {
                this.x = lettre - 'A';
                this.y = chiffre - 1;
            } else {
                System.out.println("Position non valide");
            }
        } else {
            System.out.println("chaîne de caractères non valide");
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        if (x >= 0 && x <= 7) {
            this.x = x;
        } else {
            System.out.println("Position non valide");
        }
    }

    public void setY(int y) {
        if (y >= 0 && y <= 7) {
            this.y = y;
        } else {
            System.out.println("Position non valide");
        }
    }

    public boolean equals(Object p) {
        if (p instanceof Position) {
            return this.x == ((Position) p).getX() && this.y == ((Position) p).getY();
        } else {
            return false;
        }
    }

    public String toString() {
        return "" + (char) (this.x + 'A') + (this.y + 1);
    }
}