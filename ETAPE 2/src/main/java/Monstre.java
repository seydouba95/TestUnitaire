public class Monstre implements IMonstre{

    private boolean est_vivant;

    public Monstre(){
        est_vivant = true;
    }
    @Override
    public boolean EstVivant() {
        return est_vivant;
    }

    @Override
    public void PerdsUnCombat(int nb) {
          est_vivant = false;
    }
}
