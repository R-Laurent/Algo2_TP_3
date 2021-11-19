import java.util.ArrayList;
import java.util.HashSet;

public class BreadthFirstSearch {

    static ArrayList<Arc> generateTree(Graph g, Integer s){
        HashSet<Integer> marquage = new HashSet<>();
        ArrayList<Arc> randomArcTree = new ArrayList<>();
        ArrayList<Integer> file = new ArrayList<>();
        file.add(s);
        marquage.add(s);
        int i=0;
        while (file.size() != 0){
            int e = file.get(0);
            file.remove(0);
            for (int j=0;j<g.outNeighbours(e).size();j++){
                if (marquage.contains(g.outNeighbours(e).get(j).getDest()) == false){
                randomArcTree.add(g.outNeighbours(e).get(j));
                file.add(g.outNeighbours(e).get(j).getDest());
                marquage.add(g.outNeighbours(e).get(j).getDest());}
            }
            i++;
        }
        return randomArcTree;
    }
}
