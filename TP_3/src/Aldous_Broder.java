import java.util.ArrayList;

public class Aldous_Broder {
    static ArrayList<Arc> generateTree(Graph g, Integer s) {
        ArrayList<Arc> randomArcTree = new ArrayList<>();
        ArrayList<Integer> marquage = new ArrayList<>();
        int i = 0;
        s = (int) Math.random() * (g.order - 1) + 1;
        while (marquage.size() < 10000) {
            if (g.outNeighbours(s).size() != 0 && marquage.contains(s) == false) {
                int v = (int) Math.random() * (g.outNeighbours(s).size() - 1) + 1;
                marquage.add(s);
                randomArcTree.add(g.outNeighbours(s).get(v));
                s=v;
                System.out.println("salut le s");
            }
            System.out.println("i : " + i);
            i++;
        }
        return randomArcTree;
    }
}
