import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Jeu {

    //modification mineure : retrait de l'attribut heros
    public Heros heros;
    private IFournisseurMeteo _fournisseurMeteo;

    //modification majeure
    private IFabriqueDeMonstres _fabriqueDeMonstres;


    public Jeu(IFournisseurMeteo fournisseurMeteo, IFabriqueDeMonstres iFabriqueDeMonstres) {
        heros = new Heros(15);
        this._fournisseurMeteo = fournisseurMeteo;
        this._fabriqueDeMonstres = iFabriqueDeMonstres;
    }

            public Resultat Tour(int deHeros, int deMonstre) {
                if (GagneLeCombat(deHeros, deMonstre)) {
                    heros.GagneUnCombat();
                    return Resultat.Gagne;
                } else {
                    Meteo temps = _fournisseurMeteo.QuelTempsFaitIl();
                    if (temps == Meteo.Tempete)
                        heros.PerdsUnCombat(2 * (deMonstre - deHeros));
                    else
                        heros.PerdsUnCombat(deMonstre - deHeros);
                    return Resultat.Perdu;
                }
            }

            //modification mineure retrait de la fonction GagneLeCombat
            private boolean GagneLeCombat(int de1, int de2) {
                return de1 >= de2;
            }

            //modification mineure : ajout de la methode EstTermine
            public boolean EstTermine() {
                return heros.PointDeVies <= 0  ;
            }


        }


