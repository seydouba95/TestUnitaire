public class MainTest {
    public static void main(String[] args) throws Exception {
        Ihm ihm = new Ihm(new ConsoleDeSortie(), new De(), new FournisseurMeteo() , new FabriqueDeMonstres());
        ihm.Demarre();


    }
}
