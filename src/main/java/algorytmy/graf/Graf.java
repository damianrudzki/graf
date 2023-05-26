package algorytmy.graf;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graf {
    private LinkedList<Wierzcholek> wierzcholki;

    public Graf() {
        this.wierzcholki = new LinkedList<>();
    }

    public void dodajWierzcholek(String nazwa) {
        this.wierzcholki.add(new Wierzcholek(nazwa));
    }

    public List<Wierzcholek> getWierzcholki() {
        return wierzcholki;
    }

    public LinkedList<Wierzcholek> zwrocLiczbeWierzcholkow() {
        return this.wierzcholki;
    }

    public static Graf stworzGraf(int rozmiar) {
        Graf graf = new Graf();
        Random random = new Random();

        // Dodaj wierzcholki
        for (int i = 0; i < rozmiar; i++) {
            graf.dodajWierzcholek("V" + i);
        }

        // Dodaj krawedzie
        for (Wierzcholek v : graf.getWierzcholki()) {
            int maxEdgesPerVertex = 5;
            int iloscKrawedzi = 1 + random.nextInt(maxEdgesPerVertex);


            for (int i = 0; i < iloscKrawedzi; i++) {
                Wierzcholek nowyWierzcholek;
                do {
                    nowyWierzcholek = graf.getWierzcholki().get(random.nextInt(rozmiar));
                } while (nowyWierzcholek == v || v.hasEdgeWith(nowyWierzcholek));

                v.dodajKrawedz(nowyWierzcholek, random.nextInt(100));  // Random weight for this edge
            }
        }

        return graf;
    }
}
