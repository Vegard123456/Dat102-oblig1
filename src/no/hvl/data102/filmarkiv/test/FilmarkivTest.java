package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

    private Filmarkiv arkiv;

    @BeforeEach
    void setUp() {
        arkiv = new Filmarkiv(5);

        arkiv.leggTilFilm(new Film(1, "Jon Favreau", "Iron man", 2008, Sjanger.Scifi, "Marvel"));

        arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, Sjanger.Action, "Warner"));
    }

    @Test
    void testFinnFilm() {
        Film f = arkiv.finnFilm(1);
        assertNotNull(f);
        assertEquals("Iron man", f.getTittel());
    }

    @Test
    void testLeggTilFilm() {
        arkiv.leggTilFilm(new Film(3, "Spielberg", "Jaws", 1975, Sjanger.Thriller, "Universal"));
        assertEquals(3, arkiv.antall());
    }

    @Test
    void testSlettFilm() {
        boolean slettet = arkiv.slettFilm(1);
        assertTrue(slettet);
        assertEquals(1, arkiv.antall());
    }

    @Test
    void testSoekTittel() {
        Film[] resultat = arkiv.soekTittel("Iro");
        assertTrue(resultat.length >= 1);
    }

    @Test
    void testAntallSjanger() {
        int ant = arkiv.antall(Sjanger.Scifi);
        assertEquals(1, ant);
    }
}
