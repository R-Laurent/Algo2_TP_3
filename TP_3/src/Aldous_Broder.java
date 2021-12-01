import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Aldous_Broder {
    static ArrayList<Arc> generateTree(Graph g, Integer s) {
        ArrayList<Arc> randomArcTree = new ArrayList<>();
        HashSet<Integer> marquage = new HashSet<>();
        int i = 0;
        Random r = new Random();
        s = r.nextInt(g.order);
        //System.out.println("le sommet s du début : " + s);
        marquage.add(s);
        while (marquage.size() < g.order) {
                int v = r.nextInt(g.outNeighbours(s).size());
           // System.out.println("le sommet v  : " + v);
                if (marquage.contains(g.outNeighbours(s).get(v).getDest()) == true){
                    s=g.outNeighbours(s).get(v).getDest();
                }
                else {
                    marquage.add(g.outNeighbours(s).get(v).getDest());
                    randomArcTree.add(g.outNeighbours(s).get(v));
                    s=g.outNeighbours(s).get(v).getDest();
                }
               // System.out.println("avancé : " + marquage.size()+" / " +g.order);
        }
        //System.out.println("c'est fini");
        return randomArcTree;
    }
}