package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
    Action, Drama, History, Scifi;
}

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int arstall;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {
        this.filmnr = 0;
        this.produsent = "";
        this.tittel = "";
        this.arstall = 0;
        this.sjanger = null;
        this.filmselskap = "";
    }

    public Film(int filmnr, String produsent, String tittel, int arstall, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.arstall = arstall;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public int getArstall() {
        return arstall;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setArstall(int arstall) {
        this.arstall = arstall;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
}
