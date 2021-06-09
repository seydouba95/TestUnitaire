public class ConsoleDeSortie implements IConsole {


    @Override
    public void Ecrire(String message) {
        System.out.println(message);
    }

    @Override
    public void EcrireLigne(String message) {
        System.out.println(message);

    }
}
