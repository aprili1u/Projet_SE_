import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Arc {
    private Noeud depart;
    private Noeud fin;
    private int capacite;
    private int longueur;
    private ArrayList<Paquet> listePaquet;
    private ArrayList<Integer> listePosition;

    public Arc(Noeud depart, Noeud fin, int capacite, int longueur) {
        this.depart = depart;
        this.fin = fin;
        this.capacite = 1;
        this.longueur = longueur;
        this.listePaquet=new ArrayList<Paquet>();
        this.listePosition=new ArrayList<Integer>();
    }

    //Renvoie la capacité
    public int getCapacite() {
        return capacite;
    }
    //Renvoie le facteur
    public int getLongueur() {
        return longueur;
    }
    //Renvoie le noeud de départ
    public Noeud getDepart() {
        return depart;
    }
    //Renvoie le noeud de fin
    public Noeud getFin() {
        return fin;
    }
    //Met à jour la capacité
    public void updateCapacite(int newCapacite){
        this.capacite=newCapacite;
    }
    //Met à jour le facteur
    public void updateLongueur(int newLongueur){
        this.longueur=newLongueur;
    }
    //Vérifie si l'arc est plein
    public boolean isFull(){
        return listePaquet.size()<=capacite;
    }
    //vérifie si l'arc est vide
    public boolean isEmpty() { return listePaquet.isEmpty(); }
    //Enlever un paquet
    public Paquet removePaquet(int i) {
        if (!this.isEmpty()) {
            listePosition.remove(i);
            return listePaquet.remove(i);
        }
        else{
            throw (new NoSuchElementException());
        }
    }
    // retourne -1 s'il n'y a rien
    public int refresh(){
        for (int i=0;i<listePosition.size();i++){
            listePosition.set(i,listePosition.get(i)+1);
            if (listePosition.get(i)==longueur){
                return i;
            }
        }
        return -1;
    }
    //ajoute le paquet en vérifiant si l'arc n'est pas plein
    public boolean addPaquet(Paquet p){
        if (!this.isFull()){
            this.listePaquet.add(p);
            this.listePosition.add(1);
            return true;
        }
        else{
            return false;
        }
    }
}

