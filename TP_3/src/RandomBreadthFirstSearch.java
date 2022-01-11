import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomBreadthFirstSearch {
    static ArrayList<Arc> generateTree(Graph g, Integer s){
        Random r = new Random();
        s = r.nextInt(g.order);
        System.out.println("s : " + s);
        HashSet<Integer> marquage = new HashSet<>();
        ArrayList<Arc> randomArcTree = new ArrayList<>();
        ArrayList<Integer> file = new ArrayList<>();
        file.add(s);
        marquage.add(s);
        while (file.size() != 0){
            int e = file.get(0);
            List<Arc> eNeighbour = g.outNeighbours(e);
            file.remove(0);
            System.out.println("e : " + e);
            //System.out.println("g.order : " + g.order);
            for (int j=0;j<g.outNeighbours(e).size();j++){
                int k = r.nextInt(eNeighbour.size());
                System.out.println("k : " + k);
                if (marquage.contains(g.outNeighbours(e).get(k).getDest()) == false){
                    randomArcTree.add(g.outNeighbours(e).get(k));
                    file.add(g.outNeighbours(e).get(k).getDest());
                    marquage.add(eNeighbour.get(k).getDest());
                    eNeighbour.remove(k);
                    System.out.println("taille rArctree : " + randomArcTree.size());
                    }
            }
        }
        return randomArcTree;
    }
}