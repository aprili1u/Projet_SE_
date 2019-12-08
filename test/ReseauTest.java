import java.util.ArrayList;

public class ReseauTest {
    public static void main (String args[]) {
        System.out.println("Hello world");
        Reseau r = new Reseau();
        System.out.println("Arcs: " + r.getArcs());
        System.out.println("Noeuds: " + r.getNoeuds());
        System.out.println("Paquets: " + r.getPaquets());
        Noeud n0 = new Noeud(0);
        Noeud n1 = new Noeud(1);
        r.addNoeud(n0);
        r.addNoeud(n1);
        Arc a = new Arc(n0, n1, 1, 1);
        r.addArc(a);
        Paquet p = new Paquet(n0, n1, 1, new ArrayList<Noeud>());
        r.addPaquet(p);
        System.out.println("Arcs: " + r.getArcs());
        System.out.println("Noeuds: " + r.getNoeuds());
        System.out.println("Paquets: " + r.getPaquets());
    }
}
