import java.util.Random;

public class De implements ILanceurDeDe {

    private Random random;

    public De() {
        random = new Random();
    }

    @Override
    public int Lance() {
        int min = 1;
        int max = 7;
        return random.nextInt(max - min + 1) + min;
    }
}
