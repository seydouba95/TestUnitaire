public class Heros {

    public int PointDeVies;
    public int Points;

    public Heros(int pointDeVies) {
        PointDeVies = pointDeVies;
    }

    public void GagneUnCombat() {
        Points++;
    }

    public void PerdsUnCombat(int nombreDeViesPerdus) {
        PointDeVies -= nombreDeViesPerdus;
    }
}
