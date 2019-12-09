import java.util.ArrayList;

public class Reseau {
	private ArrayList<Paquet> paquets;
	private ArrayList<Arc> arcs;
	private ArrayList<Noeud> noeuds;
	private int temps;
	private int tauxActualisation;
	
	public Reseau() {
		// Constructeur
		this.paquets = new ArrayList<Paquet>();
		this.arcs = new ArrayList<Arc>();
		this.noeuds = new ArrayList<Noeud>();
	}
	
	private int[][] arcToMatrix() {
		// Construction de la matrice d'adjacence
		int n = this.arcs.size();
		int adjacentMatrix[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Arc arc = new Arc(this.noeuds.get(i), this.noeuds.get(j), 1, 1);
				for(Arc a : this.arcs) {
					if (a == arc) {
						adjacentMatrix[i][j] = 1;
					}
				}
				adjacentMatrix[i][j] = 0;
			}
		}
		return adjacentMatrix;
	}
	
	private void addPaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		this.paquets.add(paquet);
	}
	
	private void addArc(Arc arc) {
		// Mise a jour de arcs[]
		this.arcs.add(arc);
	}
	
	private void addNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		this.noeuds.add(noeud);
	}

	private void removePaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		for(int i=0; i<paquets.size(); i++) {
			if(paquets.get(i) == paquet) {
				this.paquets.remove(i);
				return;
			}
		}
		return;
	}
	
	private void removeArc(Arc arc) {
		// Mise a jour de arcs[]
		for(int i=0; i<arcs.size(); i++) {
			if(arcs.get(i) == arc) {
				this.arcs.remove(i);
				return;
			}
		}
		return;
	}
	
	private void removeNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		for(int i=0; i<noeuds.size(); i++) {
			if(noeuds.get(i) == noeud) {
				this.noeuds.remove(i);
				return;
			}
		}
		return;
	}
	
	private void tic() {
		// Ecoulement du temps
		this.temps++;
	}
	
	private void deplacerPaquet(Paquet paquet, int path[]) {
		// Mise a jour arcs[], noeuds[] et paquets[]
		return;
	}
	
	private int[] plusCourtChemin(Paquet paquet) {
		// Calcul du plus court chemin
		int n = this.arcs.size();
		Noeud dep = paquet.getNoeudDepart();
		Noeud dest = paquet.getNoeudDestination();
		int nullMatrix[][] = new int[n][n];
		return new int[2];
	}
}
