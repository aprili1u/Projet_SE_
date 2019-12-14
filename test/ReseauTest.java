import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ReseauTest {

    @org.junit.jupiter.api.Test
    void simpleTest() {
        System.out.println("Hello world");
        Reseau r = new Reseau();
        System.out.println("Arcs: " + r.getArcs());
        System.out.println("Noeuds: " + r.getNoeuds());
        System.out.println("Paquets: " + r.getPaquets());
        Noeud n0 = new Noeud(0);
        Noeud n1 = new Noeud(1);
        Noeud n2 = new Noeud(2);
        Noeud n3 = new Noeud(3);
        Noeud n4 = new Noeud(4);
        Noeud n5 = new Noeud(5);
        Noeud n6 = new Noeud(6);
        Noeud n7 = new Noeud(7);
        r.addNoeud(n0);
        r.addNoeud(n1);
        r.addNoeud(n2);
        r.addNoeud(n3);
        r.addNoeud(n4);
        r.addNoeud(n5);
        r.addNoeud(n6);
        r.addNoeud(n7);
        Arc a0 = new Arc(n0, n1, 1, 1);
        Arc a1 = new Arc(n0, n2, 1, 1);
        Arc a2 = new Arc(n2, n4, 1, 1);
        Arc a3 = new Arc(n4, n5, 1, 1);
        Arc a4 = new Arc(n6, n7, 1, 1);
        Arc a5 = new Arc(n2, n6, 1, 3);
        Arc a6 = new Arc(n5, n7, 1, 1);
        r.addArc(a0);
        r.addArc(a1);
        r.addArc(a2);
        r.addArc(a3);
        r.addArc(a4);
        r.addArc(a5);
        r.addArc(a6);
        Paquet p = new Paquet(1, n0, n7, 1, new ArrayList<Noeud>());
        r.addPaquet(p);
        /*System.out.println("Arcs: " + r.getArcs());
        System.out.println("Noeuds: " + r.getNoeuds());
        System.out.println("Paquets: " + r.getPaquets());*/
        System.out.println("Matrice d'adjacence:");
        r.printMatrix(r.arcToMatrix());
        ArrayList<Noeud> path = r.plusCourtChemin(p);
        System.out.println("Path:");
        //System.out.println(path.toString());
        if(path == null) {
            System.out.println("Pas de chemin possible");
            return;
        }
        for(Noeud node : path.subList(0, path.size()-1)) {
            System.out.print(node.getID());
            System.out.print(" <- ");
        }
        System.out.println(path.get(path.size()-1).getID());
    }
}
