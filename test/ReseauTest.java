import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ReseauTest {

    /*@org.junit.jupiter.api.Test
    public void plusCourtCheminTest() {
        //System.out.println("Hello world");
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
        System.out.println("Arcs: " + r.getArcs());
        System.out.println("Noeuds: " + r.getNoeuds());
        System.out.println("Paquets: " + r.getPaquets());
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
            System.out.print(" -> ");
        }
        System.out.println(path.get(path.size()-1).getID());

        r.removeNoeud(n5);

        path = r.plusCourtChemin(p);
        System.out.println("Path:");
        //System.out.println(path.toString());
        if(path == null) {
            System.out.println("Pas de chemin possible");
            return;
        }
        for(Noeud node : path.subList(0, path.size()-1)) {
            System.out.print(node.getID());
            System.out.print(" -> ");
        }
        System.out.println(path.get(path.size()-1).getID());
    }*/

    /*@org.junit.jupiter.api.Test
    public void randomPathGenerationTest() {
        //System.out.println("Hello world");
        Reseau r = new Reseau();
        //System.out.println("Arcs: " + r.getArcs());
        //System.out.println("Noeuds: " + r.getNoeuds());
        //System.out.println("Paquets: " + r.getPaquets());
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
        Arc a5 = new Arc(n2, n6, 1, 1);
        Arc a6 = new Arc(n5, n7, 1, 1);
        Arc a7 = new Arc(n1, n6, 1, 1);
        Arc a8 = new Arc(n2, n3, 1, 1);
        Arc a9 = new Arc(n3, n5, 1, 1);
        r.addArc(a0);
        r.addArc(a1);
        r.addArc(a2);
        r.addArc(a3);
        r.addArc(a4);
        r.addArc(a5);
        r.addArc(a6);
        r.addArc(a7);
        r.addArc(a8);
        r.addArc(a9);
        Paquet p = new Paquet(1, n0, n7, 1, new ArrayList<Noeud>());
        r.addPaquet(p);
        //System.out.println("Arcs: " + r.getArcs());
        //System.out.println("Noeuds: " + r.getNoeuds());
        //System.out.println("Paquets: " + r.getPaquets());
        //System.out.println("Matrice d'adjacence:");
        //r.printMatrix(r.arcToMatrix());
        for(int i=0; i<5; i++) {
            ArrayList<Noeud> path = r.randomPath(p);
            System.out.println("Path:");
            //System.out.println(path.toString());
            if (path == null) {
                System.out.println("Pas de chemin possible");
                return;
            }
            for (Noeud node : path.subList(0, path.size() - 1)) {
                System.out.print(node.getID());
                System.out.print(" -> ");
            }
            System.out.println(path.get(path.size() - 1).getID());
            System.out.println("");
        }
    }*/

    /*@org.junit.jupiter.api.Test
    void trajetPaquetTest() throws InterruptedException {
        Reseau r = new Reseau();
        Noeud n0 = new Noeud(0);
        Noeud n1 = new Noeud(1);
        r.addNoeud(n0);
        r.addNoeud(n1);
        Arc a0 = new Arc(n0, n1, 1, 1);
        r.addArc(a0);
        ArrayList<Noeud> path = new ArrayList<>();
        path.add(n0);
        path.add(n1);
        Paquet p0 = new Paquet(0, n0, n1, 50, path);
        r.addPaquet(p0);
        while(p0.getNoeudPosition() != p0.getNoeudDestination()) {
            System.out.println("Temps: " + r.getTemps());
            System.out.println("Position courante: " + p0.getNoeudPosition().getID());
            System.out.println("Queue n0: "+ n0.getQueue());
            System.out.println("Size n0: " + n0.getQueue().size());
            System.out.println("Queue n1: "+ n1.getQueue());
            System.out.println("Size n1: " + n1.getQueue().size());
            System.out.println("Arc: " + a0.getListePaquet());
            System.out.println("Position: " + a0.getListePosition());
            System.out.println("Longueur: " + a0.getLongueur());
            System.out.println("");
            r.refreshNoeuds();
            Thread.sleep(1000);
            System.out.println("Temps: " + r.getTemps());
            System.out.println("Position courante: " + p0.getNoeudPosition().getID());
            System.out.println("Queue n0: "+ n0.getQueue());
            System.out.println("Size n0: " + n0.getQueue().size());
            System.out.println("Queue n1: "+ n1.getQueue());
            System.out.println("Size n1: " + n1.getQueue().size());
            System.out.println("Arc: " + a0.getListePaquet());
            System.out.println("Position: " + a0.getListePosition());
            System.out.println("Longueur: " + a0.getLongueur());
            System.out.println("");
            r.refreshArcs();
            Thread.sleep(1000);
        }
        System.out.println("Temps: " + r.getTemps());
        System.out.println("Position courante: " + p0.getNoeudPosition().getID());
        System.out.println("Queue n0: "+ n0.getQueue());
        System.out.println("Size n0: " + n0.getQueue().size());
        System.out.println("Queue n1: "+ n1.getQueue());
        System.out.println("Size n1: " + n1.getQueue().size());
        System.out.println("Arc: " + a0.getListePaquet());
        System.out.println("Position: " + a0.getListePosition());
        System.out.println("Longueur: " + a0.getLongueur());
        System.out.println("");
    }*/

    @org.junit.jupiter.api.Test
    public void randomPathUseTest() throws InterruptedException {
        Reseau r = new Reseau();
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
        Arc a0 = new Arc(0, n0, n1, 1, 1);
        Arc a1 = new Arc(1, n0, n2, 1, 1);
        Arc a2 = new Arc(2, n2, n4, 1, 1);
        Arc a3 = new Arc(3, n4, n5, 1, 1);
        Arc a4 = new Arc(4, n6, n7, 1, 1);
        Arc a5 = new Arc(5, n2, n6, 1, 1);
        Arc a6 = new Arc(6, n5, n7, 1, 1);
        Arc a7 = new Arc(7, n1, n6, 1, 1);
        Arc a8 = new Arc(8, n2, n3, 1, 1);
        Arc a9 = new Arc(9, n3, n5, 1, 1);
        r.addArc(a0);
        r.addArc(a1);
        r.addArc(a2);
        r.addArc(a3);
        r.addArc(a4);
        r.addArc(a5);
        r.addArc(a6);
        r.addArc(a7);
        r.addArc(a8);
        r.addArc(a9);
        Paquet p0 = new Paquet(0, n0, n7, 1, new ArrayList<>());
        ArrayList<Noeud> path0 = r.plusCourtChemin(p0);
        p0.setTrajet(path0);
        Paquet p1 = new Paquet(1, n2, n5, 1, new ArrayList<>());
        ArrayList<Noeud> path1 = r.plusCourtChemin(p1);
        p1.setTrajet(path1);
        Paquet p2 = new Paquet(2, n2, n6, 1, new ArrayList<>());
        ArrayList<Noeud> path2 = r.plusCourtChemin(p2);
        p2.setTrajet(path2);
        r.addPaquet(p0);
        r.addPaquet(p1);
        r.addPaquet(p2);
        System.out.println("Path p0:");
        if (path0 == null) {
            System.out.println("Pas de chemin possible");
            return;
        }
        for (Noeud node : path0.subList(0, path0.size() - 1)) {
            System.out.print(node.getID());
            System.out.print(" -> ");
        }
        System.out.println(path0.get(path0.size() - 1).getID());
        System.out.println("Path p1:");
        if (path1 == null) {
            System.out.println("Pas de chemin possible");
            return;
        }
        for (Noeud node : path1.subList(0, path1.size() - 1)) {
            System.out.print(node.getID());
            System.out.print(" -> ");
        }
        System.out.println(path1.get(path1.size() - 1).getID());
        System.out.println("Path p2:");
        if (path2 == null) {
            System.out.println("Pas de chemin possible");
            return;
        }
        for (Noeud node : path2.subList(0, path2.size() - 1)) {
            System.out.print(node.getID());
            System.out.print(" -> ");
        }
        System.out.println(path2.get(path2.size() - 1).getID());
        System.out.println("");
        while(r.getPaquets().size() != 0) {
            System.out.println("Temps: " + r.getTemps());
            if(p0.getNoeudPosition() == p0.getNoeudDestination()){
                System.out.println("Position courante p0: Arrivé");
            } else{
                System.out.println("Position courante p0: " + p0.getNoeudPosition().getID());
            }
            if(p1.getNoeudPosition() == p1.getNoeudDestination()){
                System.out.println("Position courante p1: Arrivé");
            } else{
                System.out.println("Position courante p1: " + p1.getNoeudPosition().getID());
            }
            if(p2.getNoeudPosition() == p2.getNoeudDestination()){
                System.out.println("Position courante p2: Arrivé");
            } else{
                System.out.println("Position courante p2: " + p2.getNoeudPosition().getID());
            }
            /*System.out.println("Size n0: " + n0.getQueue().size());
            System.out.println("Size n1: " + n1.getQueue().size());
            System.out.println("Size n2: " + n2.getQueue().size());
            System.out.println("Size n3: " + n3.getQueue().size());
            System.out.println("Size n4: " + n4.getQueue().size());
            System.out.println("Size n5: " + n5.getQueue().size());
            System.out.println("Size n6: " + n6.getQueue().size());
            System.out.println("Size n7: " + n7.getQueue().size());
            System.out.println("Size a0: " + a0.getListePaquet().size());
            System.out.println("Size a1: " + a1.getListePaquet().size());
            System.out.println("Size a2: " + a2.getListePaquet().size());
            System.out.println("Size a3: " + a3.getListePaquet().size());
            System.out.println("Size a4: " + a4.getListePaquet().size());
            System.out.println("Size a5: " + a5.getListePaquet().size());
            System.out.println("Size a6: " + a6.getListePaquet().size());
            System.out.println("Size a7: " + a7.getListePaquet().size());
            System.out.println("Size a8: " + a8.getListePaquet().size());
            System.out.println("Size a9: " + a9.getListePaquet().size());*/
            System.out.println("");
            //r.refreshNoeuds();
            r.refresh();
            /*Thread.sleep(1000);
            System.out.println("Position courante p0: " + p0.getNoeudPosition().getID());
            System.out.println("Position courante p1: " + p1.getNoeudPosition().getID());
            System.out.println("Size n0: " + n0.getQueue().size());
            System.out.println("Size n1: " + n1.getQueue().size());
            System.out.println("Size n2: " + n2.getQueue().size());
            System.out.println("Size n3: " + n3.getQueue().size());
            System.out.println("Size n4: " + n4.getQueue().size());
            System.out.println("Size n5: " + n5.getQueue().size());
            System.out.println("Size n6: " + n6.getQueue().size());
            System.out.println("Size n7: " + n7.getQueue().size());
            System.out.println("Size a0: " + a0.getListePaquet().size());
            System.out.println("Size a1: " + a1.getListePaquet().size());
            System.out.println("Size a2: " + a2.getListePaquet().size());
            System.out.println("Size a3: " + a3.getListePaquet().size());
            System.out.println("Size a4: " + a4.getListePaquet().size());
            System.out.println("Size a5: " + a5.getListePaquet().size());
            System.out.println("Size a6: " + a6.getListePaquet().size());
            System.out.println("Size a7: " + a7.getListePaquet().size());
            System.out.println("Size a8: " + a8.getListePaquet().size());
            System.out.println("Size a9: " + a9.getListePaquet().size());
            System.out.println("");
            r.refreshArcs();
            Thread.sleep(1000);*/
        }
        System.out.println("Temps: " + r.getTemps());
        if(p0.getNoeudPosition() == p0.getNoeudDestination()){
            System.out.println("Position courante p0: Arrivé");
        } else{
            System.out.println("Position courante p0: " + p0.getNoeudPosition().getID());
        }
        if(p1.getNoeudPosition() == p1.getNoeudDestination()){
            System.out.println("Position courante p1: Arrivé");
        } else{
            System.out.println("Position courante p1: " + p1.getNoeudPosition().getID());
        }
        if(p2.getNoeudPosition() == p2.getNoeudDestination()){
            System.out.println("Position courante p2: Arrivé");
        } else{
            System.out.println("Position courante p2: " + p2.getNoeudPosition().getID());
        }
        /*System.out.println("Size n0: " + n0.getQueue().size());
        System.out.println("Size n1: " + n1.getQueue().size());
        System.out.println("Size n2: " + n2.getQueue().size());
        System.out.println("Size n3: " + n3.getQueue().size());
        System.out.println("Size n4: " + n4.getQueue().size());
        System.out.println("Size n5: " + n5.getQueue().size());
        System.out.println("Size n6: " + n6.getQueue().size());
        System.out.println("Size n7: " + n7.getQueue().size());
        System.out.println("Size a0: " + a0.getListePaquet().size());
        System.out.println("Size a1: " + a1.getListePaquet().size());
        System.out.println("Size a2: " + a2.getListePaquet().size());
        System.out.println("Size a3: " + a3.getListePaquet().size());
        System.out.println("Size a4: " + a4.getListePaquet().size());
        System.out.println("Size a5: " + a5.getListePaquet().size());
        System.out.println("Size a6: " + a6.getListePaquet().size());
        System.out.println("Size a7: " + a7.getListePaquet().size());
        System.out.println("Size a8: " + a8.getListePaquet().size());
        System.out.println("Size a9: " + a9.getListePaquet().size());*/
        System.out.println("");
    }

    /*@org.junit.jupiter.api.Test
    public void runTest() throws InterruptedException {
        Reseau r = new Reseau();
        r.run();
    }*/

}
