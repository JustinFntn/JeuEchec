public class Main {

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        System.out.println(plateau);
        System.out.println(plateau.getPiecesBlanches() + "\n" + "\n" +
                plateau.getPiecesNoires());
    }
}
