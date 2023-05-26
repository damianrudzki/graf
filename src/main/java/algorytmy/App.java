package algorytmy;

import algorytmy.graf.Graf;
import algorytmy.graf.Wierzcholek;
import algorytmy.search.BFS;
import algorytmy.search.DFS;

import java.util.ArrayList;
import java.util.List;

import static algorytmy.graf.Wierzcholek.getRandomEndVertex;

public class App {
    public static void main(String[] args) {
        List<Integer> graphSizes = generateGraphSizes(10, 100, 5);

        for (int size : graphSizes) {
            List<Integer> bfsCounters = new ArrayList<>();
            List<Integer> dfsCounters = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                Graf graf = Graf.stworzGraf(size);
                Wierzcholek startVertex = graf.zwrocLiczbeWierzcholkow().get(0);
                Wierzcholek endVertex = getRandomEndVertex(graf, startVertex);

                BFS bfs = new BFS(graf);
                bfs.szukaj(startVertex, endVertex);
                bfsCounters.add(bfs.getCounter());

                DFS dfs = new DFS(graf);
                dfs.search(startVertex, endVertex);
                dfsCounters.add(dfs.getCounter());

                resetVisitedVertices(graf);
            }

            System.out.println("For a graph of size " + size + ":");
            System.out.println("BFS visited vertices: " + bfsCounters);
            System.out.println("DFS visited vertices: " + dfsCounters);
            System.out.println("--------------------");
        }
    }

    private static List<Integer> generateGraphSizes(int startSize, int endSize, int step) {
        List<Integer> sizes = new ArrayList<>();
        for (int i = startSize; i <= endSize; i += step) {
            sizes.add(i);
        }
        return sizes;
    }


    private static void resetVisitedVertices(Graf graf) {
        for (Wierzcholek v : graf.zwrocLiczbeWierzcholkow()) {
            v.setVisited(false);
        }
    }
}
