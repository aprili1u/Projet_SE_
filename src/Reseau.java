public class Reseau {
	private Paquet paquets[];
	private Arc arcs[];
	private Noeud noeuds[];
	private int temps;
	private int tauxActualisation;
	
	public Reseau() {
		// Constructeur
		Paquet paquets[] = new Paquet[];
		Arc arcs[] = new Arc[];
		Noeud noeuds[] = new Noeud[];
	}
	
	private int[][] arcToMatrix() {
		// Construction de la matrice d'adjacence
		n = this.arcs.length;
		int adjacentMatrix[n][n] = new int[n][n];
		for i in range(n):
			for j in range(n):
				Arc arc = new Arc(i, j);
				if(arc in this.arcs[]) {
					adjacentMatrix[i][j] = 1;
				}
				adjacentMatrix[i][j] = 0;
		return adjacentMatrix;
	}
	
	private void addPaquet(Paquet paquet) {
		// Mise à jour de paquets[]
		this.paquets.append(paquet);
	}
	
	private void addArc(Arc arc) {
		// Mise à jour de arcs[]
		this.arcs.append(arc);
	}
	
	private void addNoeud(Noeud noeud) {
		// Mise à jour de noeuds[]
		this.noeuds.append(noeud);
	}
	
	private void removePaquet(Paquet paquet) {
		// Mise à jour de paquets[]
		for i, p in enumerate(paquets) {
			if(p == paquet) {
				this.paquets.pop(i);
				return;
			}
		}
		return;
	}
	
	private void removeArc(Arc arc) {
		// Mise à jour de arcs[]
		for i, a in enumerate(arcs) {
			if(a == arc) {
				this.arcs.pop(i);
				return;
			}
		}
		return;
	}
	
	private void removeNoeud(Noeud noeud) {
		// Mise à jour de noeuds[]
		for i, n in enumerate(noeud) {
			if(n == noeud) {
				this.noeuds.pop(i);
				return;
			}
		}
		return;
	}
	
	private void tic() {
		// Écoulement du temps
		this.temps++;
	}
	
	private void deplacerPaquet(Paquet paquet, int path[]) {
		// Mise à jour arcs[], noeuds[] et paquets[]
		return;
	}
	
	private int[] plusCourtChemin(Paquet paquet) {
		// Calcul du plus court chemin
		return path;
	}
}
