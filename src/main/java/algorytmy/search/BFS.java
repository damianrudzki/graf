package algorytmy.search;

import algorytmy.graf.Graf;
import algorytmy.graf.Krawedz;
import algorytmy.graf.Wierzcholek;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Graf graf;
    private int counter;

    public BFS(Graf graf) {
        this.graf = graf;
        this.counter = 0;
    }

    public void szukaj(Wierzcholek startWierzcholek, Wierzcholek targetWierzcholek) {
        Queue<Wierzcholek> queue = new LinkedList<>();
        startWierzcholek.setVisited(true);
        queue.add(startWierzcholek);

        while (!queue.isEmpty()) {
            Wierzcholek actualWierzcholek = queue.remove();
            counter++;

            if (actualWierzcholek == targetWierzcholek) {
                break;
            }

            for (Krawedz krawedz : actualWierzcholek.getKrawedzie()) {
                Wierzcholek v = krawedz.getOtherWierzcholek(actualWierzcholek);
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }


    public int getCounter() {
        return counter;
    }
}
