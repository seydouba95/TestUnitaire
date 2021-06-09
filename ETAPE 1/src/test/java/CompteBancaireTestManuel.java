
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CompteBancaire Tester.
 *
 * @author <Seydou Ba>
 * @version 1.0
 * @since <pre>May 30, 2021</pre>
 */
public class CompteBancaireTestManuel {


    /** somme versee est positive
     * donc le versement est effectuee
     * la somme du compte augmente
     */

    /**
     * Method: verser(double x)
     */
    @Test
    public void testVerser1() {

        //Arrange
        CompteBancaire cpt = new CompteBancaire(5000.0);
        double montant_a_verser = 1000.0;
        double excepted = 6000.0;

        //Act
        assertEquals(true, cpt.verser(montant_a_verser));

        //Assert
        assertEquals(excepted, cpt.getSolde(), 0);
    }

    /**
     * somme versee est negative
     * donc la somme dans le compte ne change pas
     */
    @Test
    public void testVerser2() {

        //Arrange
        CompteBancaire cpt = new CompteBancaire(6500.0);
        double montant_a_verser = -2000.0;
        double excepted = 6500.0;

        //Act
        assertEquals(false, cpt.verser(montant_a_verser));

        //Assert
        assertEquals(excepted, cpt.getSolde(), 0);

    }

    /** somme dans le compte est superieur  à la somme retiree
     * retrait effectuee
     * solde diminue
     */

    /**
     * Method: retirer(double x)
     */
    @Test
    public void testRetirer1() {

        //Arrange
        CompteBancaire cpt = new CompteBancaire(23000.0);
        double montant_a_retirer = 17500.0;
        double excepted = 5500.0;

        //Act
        assertEquals(true, cpt.retirer(montant_a_retirer));

        //Assert
        assertEquals(excepted, cpt.getSolde(), 0);

    }


    /**
     * somme dans le compte est egale  à la somme retiree
     * retrait effectuee
     * solde diminue
     */
    @Test
    public void testRetirer2() {

        //Arrange
        CompteBancaire cpt = new CompteBancaire(26000.0);
        double montant_a_retirer = 26000.0;
        double excepted = 0.0;

        //Act
        assertEquals(true, cpt.retirer(montant_a_retirer));

        //Assert
        assertEquals(excepted, cpt.getSolde(), 0);

    }


    /**
     * somme dans le compte est inferieur à la somme retiree
     * donc on ne pourra pas effectuer le retrait
     * solde dans le compte ne change pas
     */
    @Test
    public void testRetirer3() {

        //Arrange
        CompteBancaire cpt = new CompteBancaire(29000.0);
        double montant_a_retirer = 30000.0;
        double excepted = 29000.0;

        //Act
        assertEquals(false, cpt.retirer(montant_a_retirer));

        //Assert
        assertEquals(excepted, cpt.getSolde(), 0);

    }


    /** la somme viree existe dans le compte et le compte a de l'argent
     * donc le virement effectue et solde diminue
     * solde dans l'autre compte augmente
     */

    /**
     * Method: virerArgent(CompteBancaire c, double montant)
     */

    @Test
    public void testVirement1() {

        //Arrange
        CompteBancaire cpt1 = new CompteBancaire(63000.0);
        CompteBancaire cpt2 = new CompteBancaire(43000.0);
        double montant_a_virer = 28000.0;
        double excepted_solde_cpt1 = 35000.0;
        double excepted_solde_cpt2 = 71000.0;

        //Act
        assertEquals(true, cpt1.virerArgent(cpt2, montant_a_virer));

        //Assert
        assertEquals(excepted_solde_cpt1, cpt1.getSolde(), 0);
        assertEquals(excepted_solde_cpt2, cpt2.getSolde(), 0);

    }


    /**
     * la somme souhaite viree est superieur au solde du compte
     * donc le virement ne sera pas effectue et solde ne change pas
     * solde dans l'autre compte aussi ne varie pas
     */
    @Test
    public void testVirement2() {

        //Arrange
        CompteBancaire cpt1 = new CompteBancaire(63000.0);
        CompteBancaire cpt2 = new CompteBancaire(43000.0);
        double montant_a_virer = 88000.0;
        double excepted_solde_cpt1 = 63000.0;
        double excepted_solde_cpt2 = 43000.0;

        //Act
        assertEquals(false, cpt1.virerArgent(cpt2, montant_a_virer));

        //Assert
        assertEquals(excepted_solde_cpt1, cpt1.getSolde(), 0);
        assertEquals(excepted_solde_cpt2, cpt2.getSolde(), 0);

    }

    /**
     * le solde dans le compte est nul
     * donc le virement ne sera pas effectue et solde ne change pas
     * solde dans l'autre compte ne change pas
     */
    @Test
    public void testVirement3() {

        //Arrange
        CompteBancaire cpt1 = new CompteBancaire(0.0);
        CompteBancaire cpt2 = new CompteBancaire(43000.0);
        double montant_a_virer = 8000.0;
        double excepted_solde_cpt1 = 0.0;
        double excepted_solde_cpt2 = 43000.0;

        //Act
        assertEquals(false, cpt1.virerArgent(cpt2, montant_a_virer));

        //Assert
        assertEquals(excepted_solde_cpt1, cpt1.getSolde(), 0);
        assertEquals(excepted_solde_cpt2, cpt2.getSolde(), 0);

    }


} 
