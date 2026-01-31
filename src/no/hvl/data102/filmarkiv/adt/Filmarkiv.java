package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv implements FilmarkivADT {
    private Film[] arkiv;
    private int antall;

    public Filmarkiv(int maksantall) {
        arkiv = new Film[maksantall];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmnr() == nr) {
                return arkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == arkiv.length) {
            utvid();
        }
        arkiv[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmnr() == filmnr) {
                for (int j = i; j < antall; j++) {
                    arkiv[j] = arkiv[j + 1];
                }
                arkiv[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int count = 0;

        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[count++] = arkiv[i];
            }
        }
        return treff;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int count = 0;

        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[count++] = arkiv[i];
            }
        }
        return treff;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;

        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
    }

    private void utvid() {
        Film[] nytab = new Film[arkiv.length * 2];
        int i = 0;
        while (i < arkiv.length) {
            nytab[i] = arkiv[i];
            i++;
        }
        arkiv = nytab;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }
}
