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
		// Mise a jour de paquets[]
		this.paquets.append(paquet);
	}
	
	private void addArc(Arc arc) {
		// Mise a jour de arcs[]
		this.arcs.append(arc);
	}
	
	private void addNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		this.noeuds.append(noeud);
	}
	
	private void removePaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		for(int i=0; i<paquets.length; i++) {
			if(paquets[i] == paquet) {
				this.paquets.pop(i);
				return;
			}
		}
		return;
	}
	
	private void removeArc(Arc arc) {
		// Mise a jour de arcs[]
		for(int i=0; i<arcs.length; i++) {
			if(arcs[i] == arc) {
				this.arcs.pop(i);
				return;
			}
		}
		return;
	}
	
	private void removeNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		for(int i=0; i<noeuds.length; i++) {
			if(noeuds[i] == noeud) {
				this.noeuds.pop(i);
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
		n = this.arcs.length;
		dep = paquet.getNoeudDepart();
		dest = paquet.getNoeudDestination();
		int nullMatrix[n][n] = new int[n][n];
		while()
		return path;
	}
}
