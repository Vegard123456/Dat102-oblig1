package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        filmarkiv.leggTilFilm(new Film(1, "The Matrix", 1999, "Lana Wachowski", Sjanger.Action, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(2, "Inception", 2010, "Christopher Nolan", Sjanger.Action, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(3, "Titanic", 1997, "James Cameron", Sjanger.Drama, "20th Century Fox"));
    }
}
