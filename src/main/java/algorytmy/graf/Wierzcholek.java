package algorytmy.graf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Wierzcholek {
    private String nazwa;
    private List<Krawedz> krawedzie;
    private boolean visited;

    public Wierzcholek(String nazwa) {
        this.nazwa = nazwa;
        this.krawedzie = new LinkedList<>();
    }

    public void dodajKrawedz(Wierzcholek other, int weight) {
        this.krawedzie.add(new Krawedz(this, other, weight));
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public List<Krawedz> getKrawedzie() {
        return krawedzie;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean hasEdgeWith(Wierzcholek other) {
        for (Krawedz krawedz : krawedzie) {
            if (krawedz.getOtherWierzcholek(this).equals(other)) {
                return true;
            }
        }
        return false;
    }
    public static Wierzcholek getRandomEndVertex(Graf graf, Wierzcholek startVertex) {
        List<Wierzcholek> vertices = new ArrayList<>(graf.zwrocLiczbeWierzcholkow());
        vertices.remove(startVertex);
        int randomIndex = (int) (Math.random() * vertices.size());
        return vertices.get(randomIndex);
    }


}
