import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CompteBancaireTestAutomatic {

    private CompteBancaire compteBancaireUnderTest;

    @Before
    public void setUp() {
        compteBancaireUnderTest = new CompteBancaire(0.0);
    }

    @Test
    public void testVerser() {
        // Setup

        // Run the test
        final boolean result = compteBancaireUnderTest.verser(0.0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testRetirer() {
        // Setup

        // Run the test
        final boolean result = compteBancaireUnderTest.retirer(0.0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testAfficher() {
        // Setup

        // Run the test
        compteBancaireUnderTest.afficher();

        // Verify the results
    }

    @Test
    public void testVirerArgent() {
        // Setup
        final CompteBancaire c = new CompteBancaire(0.0);

        // Run the test
        final boolean result = compteBancaireUnderTest.virerArgent(c, 0.0);

        // Verify the results
        assertTrue(result);
    }
}
