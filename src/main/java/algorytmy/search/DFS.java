package algorytmy.search;

import algorytmy.graf.Graf;
import algorytmy.graf.Krawedz;
import algorytmy.graf.Wierzcholek;

import java.util.Stack;

public class DFS {
    private Graf graf;
    private int minCounter;

    public DFS(Graf graf) {
        this.graf = graf;
        this.minCounter = Integer.MAX_VALUE;
    }

    public void search(Wierzcholek startWierzcholek, Wierzcholek targetWierzcholek) {
        dfs(startWierzcholek, targetWierzcholek, 0);
    }


    private void dfs(Wierzcholek currentWierzcholek, Wierzcholek targetWierzcholek, int counter) {

        currentWierzcholek.setVisited(true);

        if (currentWierzcholek.equals(targetWierzcholek)) {
            if (counter < minCounter) {
                minCounter = counter;
            }
        } else {
            for (Krawedz krawedz : currentWierzcholek.getKrawedzie()) {
                Wierzcholek neighbor = krawedz.getOtherWierzcholek(currentWierzcholek);
                if (!neighbor.isVisited()) {
                    dfs(neighbor, targetWierzcholek, counter + 1);
                }
            }
        }

        currentWierzcholek.setVisited(false);
    }

    public int getCounter() {
        return minCounter;
    }
}