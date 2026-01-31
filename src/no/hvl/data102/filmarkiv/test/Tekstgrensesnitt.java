package no.hvl.data102.filmarkiv.test;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

    private Scanner in = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {

        System.out.print("Filmnummer: ");
        int filmnr = Integer.parseInt(in.nextLine());

        System.out.print("Tittel: ");
        String tittel = in.nextLine();

        System.out.print("Produksjonsår: ");
        int aar = Integer.parseInt(in.nextLine());

        System.out.print("Produsent: ");
        String produsent = in.nextLine();

        System.out.print("Filmselskap: ");
        String selskap = in.nextLine();

        System.out.print("Sjanger: ");
        Sjanger sjanger = Sjanger.valueOf(in.nextLine().toUpperCase());

        return new Film(filmnr, tittel, aar, produsent, sjanger, selskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm
    public void skrivUtFilm(Film film) {

        if (film == null) {
            return;
        }

        System.out.println(
                "Filmnr: " + film.getFilmnr() +
                        ", Tittel: " + film.getTittel() +
                        ", År: " + film.getArstall() +
                        ", Produsent: " + film.getProdusent() +
                        ", Sjanger: " + film.getSjanger() +
                        ", Selskap: " + film.getFilmselskap()
        );
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {

        Film[] treff = arkiv.soekTittel(delstreng);

        for (Film film : treff) {
            if (film != null) {
                skrivUtFilm(film);
            }
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {

        Film[] treff = arkiv.soekProdusent(delstreng);

        for (Film film : treff) {
            if (film != null) {
                skrivUtFilm(film);
            }
        }
    }

    // Skriver ut statistikk
    public void skrivUtStatistikk(FilmarkivADT arkiv) {

        System.out.println("Antall filmer totalt: " + arkiv.antall());

        for (Sjanger s : Sjanger.values()) {
            System.out.println(s + ": " + arkiv.antall(s));
        }
    }
}