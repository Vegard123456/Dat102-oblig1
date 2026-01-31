package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){

    }
}
