public class MonstreCostaud  implements IMonstre{

    private int _ptsDeVie;

    public MonstreCostaud(int ptsDeVie)
    {
        _ptsDeVie = ptsDeVie;
    }
    @Override
    public boolean EstVivant() {
        return _ptsDeVie > 0;
    }

    @Override
    public void PerdsUnCombat(int nb) {
        _ptsDeVie -= nb;

    }
}
