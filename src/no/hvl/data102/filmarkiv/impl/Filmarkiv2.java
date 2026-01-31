package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> p = start;

        while (p != null) {
            if (p.data.getFilmnr() == nr) {
                return p.data;
            }
            p = p.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> ny = new LinearNode<>(nyFilm);
        ny.neste = start;
        start = ny;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> p = start;
        LinearNode<Film> forrige = null;

        while (p != null) {
            if (p.data.getFilmnr() == filmnr) {
                if (forrige == null) {
                    start = p.neste;
                } else {
                    forrige.neste = p.neste;
                }
                antall--;
                return true;
            }
            forrige = p;
            p = p.neste;
        }
        return false;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> p = start;

        while (p != null) {
            if (p.data.getSjanger() == sjanger) {
                count++;
            }
            p = p.neste;
        }
        return count;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        int count = 0;
        LinearNode<Film> p = start;

        while (p != null) {
            if (p.data.getTittel().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                count++;
            }
            p = p.neste;
        }

        Film[] resultat = new Film[count];
        p = start;
        int i = 0;

        while (p != null) {
            if (p.data.getTittel().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                resultat[i++] = p.data;
            }
            p = p.neste;
        }

        return resultat;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        int count = 0;
        LinearNode<Film> p = start;

        while (p != null) {
            if (p.data.getProdusent().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                count++;
            }
            p = p.neste;
        }

        Film[] resultat = new Film[count];
        p = start;
        int i = 0;

        while (p != null) {
            if (p.data.getProdusent().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                resultat[i++] = p.data;
            }
            p = p.neste;
        }

        return resultat;
    }
}
