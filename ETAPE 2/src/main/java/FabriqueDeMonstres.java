import java.util.Random;

public class FabriqueDeMonstres  implements IFabriqueDeMonstres {
    Random random;


    @Override
    public Object GetMonstres() {
        int min = 1;
        int max = 10;
        int nbMonstres = random.nextInt((max + min) + 1) + min;

        for (int i = 0; i < nbMonstres; i++) {
            if (random.nextInt((0 + 2) + 1) == 0)
                return new Monstre();
            else {
                int nbPtsDeVie = random.nextInt((1 + 10) + 1) + 1;
                return new MonstreCostaud(nbPtsDeVie);
            }
        }
        return new Monstre();
    }
    }
