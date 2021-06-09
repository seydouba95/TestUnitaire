public class FausseConsole implements IConsole {

    public StringBuilder StringBuilder = new StringBuilder();

    @Override
    public void Ecrire(String message) {
        StringBuilder.append(message);

    }

    @Override
    public void EcrireLigne(String message) {
        StringBuilder.append(message);
    }
}