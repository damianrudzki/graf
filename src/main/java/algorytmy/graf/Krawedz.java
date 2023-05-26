package algorytmy.graf;

public class Krawedz {
    private Wierzcholek start;
    private Wierzcholek end;
    private int weight;

    public Krawedz(Wierzcholek start, Wierzcholek end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Wierzcholek getStart() {
        return this.start;
    }

    public Wierzcholek getEnd() {
        return this.end;
    }

    public int getWeight() {
        return this.weight;
    }

    public Wierzcholek getOtherWierzcholek(Wierzcholek current) {
        return current.equals(start) ? end : start;
    }
}
