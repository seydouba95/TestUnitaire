import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Ihm Tester.
 *
 * @author <Seydou Ba>
 * @version 1.0
 * @since <pre>May 31, 2021</pre>
 */
@ExtendWith(MockitoExtension.class)
public class IhmTest {

    @Mock
    IFournisseurMeteo fournisseurMeteo = mock(FournisseurMeteo.class);
    ;
    ILanceurDeDe lanceurDeDeMock = mock(De.class);
    IFabriqueDeMonstres fabriqueDeMonstres = mock(FabriqueDeMonstres.class);

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void jeuGagne() throws Exception {

        //Arrange
        FausseConsole fausseConsole = new FausseConsole();
        Ihm ihm = new Ihm(fausseConsole, lanceurDeDeMock, fournisseurMeteo,fabriqueDeMonstres);
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);
        when(fournisseurMeteo.QuelTempsFaitIl()).thenReturn(Meteo.Pluie);

        //sur les 17 lancers , il gagne 9 fois et a perdu 8 fois
        when(lanceurDeDeMock.Lance()).thenReturn(4, 5, 1, 1, 4, 3, 5, 6,
                6, 6, 1, 2, 4, 2, 3, 2,
                6, 4, 5, 1, 1, 4, 3, 5,
                6, 6, 6, 1, 2, 4, 2, 3, 2, 6);
        //Act
        ihm.Demarre();

        //Assert
        String resultat = fausseConsole.StringBuilder.toString();
        resultat.startsWith("A l'attaque : points/vie 0/15");
        resultat.endsWith("Combat perdu : points/vie 9/0");
        //System.out.println(resultat.toString());
        //System.out.println(resultat.length());
        Assert.assertEquals("A l'attaque : points/vie 0/15", resultat.substring(0, 29));
        Assert.assertEquals("Combat perdu : points/vie 9/0", resultat.substring(512, 541));
    }

    @Test
    public void jeuPerdu() throws Exception {

        FausseConsole fausseConsole = new FausseConsole();
        Ihm ihm = new Ihm(fausseConsole, lanceurDeDeMock, fournisseurMeteo,fabriqueDeMonstres);
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);
        when(fournisseurMeteo.QuelTempsFaitIl()).thenReturn(Meteo.Soleil);

        //sur les 17 lancers , il gagne 7 fois et a perdu 10 fois
        when(lanceurDeDeMock.Lance()).thenReturn(4, 5, 1, 2, 4, 3, 5, 6,
                6, 6, 1, 2, 4, 2, 3, 2,
                6, 4, 5, 1, 1, 4, 3, 5,
                1, 6, 6, 1, 2, 4, 2, 3, 2, 6);

        //Act
        ihm.Demarre();

        //Assert
        String resultat = fausseConsole.StringBuilder.toString();
        resultat.startsWith("A l'attaque : points/vie 0/15");
        resultat.endsWith("Combat perdu : points/vie 7/-1");
        //System.out.println(resultat.toString());
        //System.out.println(resultat.length());
        Assert.assertEquals("A l'attaque : points/vie 0/15", resultat.substring(0, 29));
        Assert.assertEquals("Combat perdu : points/vie 7/-1", resultat.substring(452, 482));

    }


} 
