public class Ihm {
    private IConsole _console;
    private ILanceurDeDe _lanceurDeDe;
    private IFournisseurMeteo _iFournisseurMeteo;
    private IFabriqueDeMonstres _fabriqueDeMonstres;

    public Ihm(IConsole _console, ILanceurDeDe _lanceurDeDe, IFournisseurMeteo _iFournisseurMeteo,
    IFabriqueDeMonstres _fabriqueDeMonstres) {
        this._console = _console;
        this._lanceurDeDe = _lanceurDeDe;
        this._iFournisseurMeteo = _iFournisseurMeteo;
        this._fabriqueDeMonstres = _fabriqueDeMonstres;
    }

    public void Demarre() throws Exception {

        Jeu jeu = new Jeu(_iFournisseurMeteo,_fabriqueDeMonstres);
        _console.EcrireLigne("A l'attaque : points/vie " + jeu.heros.Points + "/" + jeu.heros.PointDeVies);
        while (!jeu.EstTermine()) {
            Resultat resultat = jeu.Tour(_lanceurDeDe.Lance(), _lanceurDeDe.Lance());
            switch (resultat) {
                case Gagne:
                    _console.Ecrire("Monstre battu");
                    break;
                case Perdu:
                    _console.Ecrire("Combat perdu");
                    break;


                default:

                    throw new Exception();
            }
            _console.EcrireLigne(" : points/vie " + jeu.heros.Points + "/" + jeu.heros.PointDeVies);
        }


    }
}
