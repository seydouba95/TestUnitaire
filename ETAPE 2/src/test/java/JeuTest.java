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
 * Jeu Tester.
 *
 * @author <Seydou Ba>
 * @version 1.0
 * @since <pre>Jun 1, 2021</pre>
 */
@ExtendWith(MockitoExtension.class)
public class JeuTest {
    @Mock
    IFournisseurMeteo fournisseurMeteo = mock(FournisseurMeteo.class);
    @Mock
    IFabriqueDeMonstres fabriqueDeMonstres = mock(FabriqueDeMonstres.class);

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }




    /**
     * Etant donné un tour de jeu, lorsque j'ai un lancer supérieur au second,
     * * alors le résultat est gagné avec un point  et sans perdre de points de vie
     */
    @Test
    public void testGagne1() throws Exception {
//TODO: Test goes here...
        //Arrange
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);
        Jeu jeu = new Jeu(fournisseurMeteo,fabriqueDeMonstres);

        //Act
        var resultat = jeu.Tour(6, 2);

        //Assert
        Assert.assertEquals(resultat, Resultat.Gagne);
        Assert.assertEquals(1, jeu.heros.Points = 1);
        Assert.assertEquals(15, jeu.heros.PointDeVies = 15);

    }

    /**
     * Etant donné un tour de jeu, lorsque j'ai un lancer égal au second,
     * alors le résultat est gagné avec un point et  sans perdre de points de vie
     */

    @Test
    public void testGagne2() throws Exception {
//TODO: Test goes here...
        //Arrange
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);

        Jeu jeu = new Jeu(fournisseurMeteo,fabriqueDeMonstres);

        //Act
        Resultat resultat = jeu.Tour(4, 4);

        //Assert
        Assert.assertEquals(resultat, Resultat.Gagne);
        Assert.assertEquals(2, jeu.heros.Points = 2);
        Assert.assertEquals(15, jeu.heros.PointDeVies = 15);

    }


    /**
     * Etant donné un tour de jeu, lorsque j'ai un lancer inférieur au second et du soleil,
     * alors le résultat est perdu, sans points et en perdant des points de vie
     */

    @Test
    public void testPerdre1() throws Exception {
        //TODO: Test goes here...
        //Arrange
        when(fournisseurMeteo.QuelTempsFaitIl()).thenReturn(Meteo.Soleil);
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);

        Jeu jeu = new Jeu(fournisseurMeteo,fabriqueDeMonstres);

        //Act
        var result = jeu.Tour(1, 4);

        //Assert
        Assert.assertEquals(result, Resultat.Perdu);
        Assert.assertEquals(0, jeu.heros.Points = 0);
        Assert.assertEquals(12, jeu.heros.PointDeVies = 12);

    }


    /**
     * Etant donné un tour de jeu, lorsque j'ai un lancer inférieur au second et de la pluie,
     * alors le résultat est perdu, sans points et en perdant des points de vie
     */

    @Test
    public void testPerdre2() throws Exception {
        //TODO: Test goes here...
        //Arrange
        when(fournisseurMeteo.QuelTempsFaitIl()).thenReturn(Meteo.Pluie);
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);

        Jeu jeu = new Jeu(fournisseurMeteo,fabriqueDeMonstres);

        //Act
        var result = jeu.Tour(1, 4);

        //Assert
        Assert.assertEquals(result, Resultat.Perdu);
        Assert.assertEquals(0, jeu.heros.Points = 0);
        Assert.assertEquals(9, jeu.heros.PointDeVies = 9);

    }

    /**
     * Etant donné un tour de jeu, lorsque j'ai un lancer inférieur au second et de la tempete,
     * alors le résultat est perdu, sans points et en perdant des points de vie
     */

    @Test
    public void testPerdre3() throws Exception {
        //TODO: Test goes here...
        //Arrange
        when(fournisseurMeteo.QuelTempsFaitIl()).thenReturn(Meteo.Tempete);
        when(fabriqueDeMonstres.GetMonstres()).thenReturn(true);

        Jeu jeu = new Jeu(fournisseurMeteo,fabriqueDeMonstres);

        //Act
        var result = jeu.Tour(1, 4);

        //Assert
        Assert.assertEquals(result, Resultat.Perdu);
        Assert.assertEquals(0, jeu.heros.Points = 0);
        Assert.assertEquals(3, jeu.heros.PointDeVies = 3);

    }
} 
