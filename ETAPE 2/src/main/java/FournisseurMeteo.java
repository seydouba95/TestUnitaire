import java.util.Random;

public class FournisseurMeteo implements IFournisseurMeteo {

    private Random _random;

    public FournisseurMeteo() {
        _random = new Random();
    }


    @Override
    public Meteo QuelTempsFaitIl() {

        int min = 0;
        int max = 21;
        int tirage = _random.nextInt(max - min + 1) + min;
        if (tirage < 10)
            return Meteo.Soleil;
        if (tirage < 20)
            return Meteo.Pluie;
        return Meteo.Tempete;
    }
}
