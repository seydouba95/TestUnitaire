public class CompteBancaire {
    private double solde;

    //constructeur sans paramatre
    public CompteBancaire() {
        solde = 0.0;
    }

    //constructeur avec parametre le solde du compte
    public CompteBancaire(double somme) {
        solde = somme;
    }

    public double getSolde() {
        return solde;
    }

    //methode verser une somme dans son compte

    public boolean verser(double x) {

        if (x > 0) {
            solde += x;
            return true;
        } else {
            return false;
        }
    }

    //methode retirer une somme dans son compte
    public boolean retirer(double x) {

        if (solde >= x && solde != 0) {
            solde -= x;
            return true;
        } else
            return false;

    }

    //afficher le solde du compte
    public void afficher() {
        System.out.println("le solde de votre compte est : " + getSolde() + "FCFA");
    }


    //methode  virement vers un autre compte bancaire.
    public boolean virerArgent(CompteBancaire c, double montant) {
        if (solde != 0 && solde >= montant) {
            c.verser(montant);
            retirer(montant);
            return true;
        } else
            return false;

    }

}
