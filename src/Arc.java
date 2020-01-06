import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Arc {
    private int ID;
    private Noeud depart;
    private Noeud fin;
    private int capacite;
    private int longueur;
    private ArrayList<Paquet> listePaquet;
    private ArrayList<Integer> listePosition;

    public Arc(int ID, Noeud depart, Noeud fin, int capacite, int longueur) {
        this.ID = ID;
        this.depart = depart;
        this.fin = fin;
        this.capacite = 1;
        this.longueur = longueur;
        this.listePaquet=new ArrayList<Paquet>();
        this.listePosition=new ArrayList<Integer>();
    }

    public int getID() { return this.ID; }

    public ArrayList<Paquet> getListePaquet() { return listePaquet; }

    public ArrayList<Integer> getListePosition() { return listePosition; }

    // Renvoie la capacité
    public int getCapacite() {
        return capacite;
    }

    // Renvoie le facteur
    public int getLongueur() {
        return longueur;
    }

    // Renvoie le noeud de départ
    public Noeud getDepart() {
        return depart;
    }

    // Renvoie le noeud de fin
    public Noeud getFin() {
        return fin;
    }


    public boolean equals(Arc other) {
        return this.ID == other.ID;
    }

    public String toString() {
        return String.valueOf(this.ID);
    }


    // Met à jour la capacité
    public void updateCapacite(int newCapacite){
        this.capacite=newCapacite;
    }

    // Met à jour le facteur
    public void updateLongueur(int newLongueur){
        this.longueur=newLongueur;
    }


    // Vérifie si l'arc est plein
    public boolean isFull(){
        return listePaquet.size()>=capacite;
    }

    // Vérifie si l'arc est vide
    public boolean isEmpty() { return listePaquet.isEmpty(); }


    // Ajoute le paquet en vérifiant si l'arc n'est pas plein
    public boolean addPaquet(Paquet p){
        if (!this.isFull()){
            this.listePaquet.add(p);
            this.listePosition.add(1);
            return true;
        }
        return false;
    }

    // Enlever un paquet
    public Paquet removePaquet(Paquet p) {
        if (!this.isEmpty()) {
            this.listePosition.remove(listePaquet.indexOf(p));
            this.listePaquet.remove(p);
            return p;
        }
        throw (new NoSuchElementException());
    }


    // Retourne null s'il n'y a rien
    public Paquet refresh(){
        for (int i=0;i<listePosition.size();i++){
            listePosition.set(i,listePosition.get(i)+1);
            if (listePosition.get(i) >= longueur) {
                return listePaquet.get(i);
            }
        }
        return null;
    }

}
