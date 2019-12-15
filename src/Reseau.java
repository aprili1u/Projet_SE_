import java.util.ArrayList;
import java.util.Collections;

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
		this.temps = 0;
		this.tauxActualisation = 1;
	}

	public ArrayList<Paquet> getPaquets() {
		return this.paquets;
	}

	public ArrayList<Arc> getArcs() { return this.arcs; }

	public ArrayList<Noeud> getNoeuds() {
		return this.noeuds;
	}

	public void addPaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		assert(!this.paquets.contains(paquet));
		for(Paquet p : this.paquets) {
			assert(p.getId() != p.getId());
		}
		this.paquets.add(paquet);
	}

	public void addArc(Arc arc) {
		// Mise a jour de arcs[]
		assert(!this.arcs.contains(arc));
		for(Arc a : this.arcs) {
			assert(a.getDepart() != arc.getDepart() || a.getFin() != arc.getFin());
			//assert(a.getID() != arc.getID());
		}
		this.arcs.add(arc);
	}

	public void addNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		assert(!this.noeuds.contains(noeud));
		for(Noeud n : this.noeuds) {
			assert(n.getID() != noeud.getID());
		}
		this.noeuds.add(noeud);
	}

	public void removePaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		assert(this.paquets.contains(paquet));
		this.paquets.remove(paquet);
	}

	public void removeArc(Arc arc) {
		// Mise a jour de arcs[]
		assert(this.arcs.contains(arc));
		this.arcs.remove(arc);
	}

	public void removeNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		assert(this.noeuds.contains(noeud));
		this.noeuds.remove(noeud);
		for(Arc a : getBeforeArcsFromNode(noeud)) {
			this.removeArc(a);
		}
		for(Arc a : getAfterArcsFromNode(noeud)) {
			this.removeArc(a);
		}
	}

	public Arc getArcFromNodes(Noeud depart, Noeud fin) {
		for(Arc a : this.arcs) {
			if(a.getDepart() == depart && a.getFin() == fin) {
				return a;
			}
		}
		return null;
	}

	public ArrayList<Arc> getAfterArcsFromNode(Noeud depart) {
		ArrayList<Arc> relatedArcs = new ArrayList<Arc>();
		for(Arc a : this.arcs) {
			if(a.getDepart() == depart) {
				relatedArcs.add(a);
			}
		}
		return relatedArcs;
	}

	public ArrayList<Arc> getBeforeArcsFromNode(Noeud fin) {
		ArrayList<Arc> relatedArcs = new ArrayList<Arc>();
		for(Arc a : this.arcs) {
			if(a.getFin() == fin) {
				relatedArcs.add(a);
			}
		}
		return relatedArcs;
	}

	public ArrayList<Noeud> getAfterNeighbours(Noeud node) {
		ArrayList<Noeud> neighbours = new ArrayList<Noeud>();
		for(Arc a : getAfterArcsFromNode(node)) {
			neighbours.add(a.getFin());
		}
		return neighbours;
	}

	public ArrayList<Noeud> getBeforeNeighbours(Noeud node) {
		ArrayList<Noeud> neighbours = new ArrayList<Noeud>();
		for(Arc a : getBeforeArcsFromNode(node)) {
			neighbours.add(a.getDepart());
		}
		return neighbours;
	}

	public ArrayList<Noeud> plusCourtChemin(Paquet paquet) {
		// Calcul du plus court chemin
		Noeud dep = paquet.getNoeudDepart();
		Noeud dest = paquet.getNoeudDestination();

		if(getAfterNeighbours(dep).isEmpty() || getBeforeNeighbours(dest).isEmpty()) {
			return null;
		}

		int n = this.noeuds.size();
		int weights[] = new int[n];
		Noeud predecessors[] = new Noeud[n];
		int adjacentMatrix[][] = arcToMatrix();
		ArrayList<Noeud> visitedNodes = new ArrayList<Noeud>();
		ArrayList<Noeud> path = new ArrayList<Noeud>();

		for(Noeud node : this.noeuds) {
			weights[this.noeuds.indexOf(node)] = -1;
		}
		for(Noeud node : this.noeuds) {
			predecessors[this.noeuds.indexOf(node)] = null;
		}
		weights[dep.getID()] = 0;
		for(Noeud node : getAfterNeighbours(dep)) {
			weights[node.getID()] = getArcFromNodes(dep, node).getLongueur();
			predecessors[this.noeuds.indexOf(node)] = dep;
		}

		int min;
		Noeud minNode = null;
		int minNodeWeight;
		int currentNodeWeight;
		int additionalWeight;
		int loop = 0;

		while(minNode != dest) {
			minNode = null;
			min = 1000000000;

			for (Noeud node : this.noeuds) {
				int weight = weights[this.noeuds.indexOf(node)];
				if (!visitedNodes.contains(node) && weight >= 0 && weight < min && (node != dep || loop == 0)) {
					minNode = node;
					min = weights[this.noeuds.indexOf(node)];
				}
			}
			if(minNode == null) {
				return null;
			}
			visitedNodes.add(minNode);

			for (Noeud node : getAfterNeighbours(minNode)) {
				minNodeWeight = weights[this.noeuds.indexOf(minNode)];
				currentNodeWeight = weights[this.noeuds.indexOf(node)];
				additionalWeight = getArcFromNodes(minNode, node).getLongueur();
				if (currentNodeWeight == -1 || currentNodeWeight > minNodeWeight + additionalWeight) {
					weights[this.noeuds.indexOf(node)] = minNodeWeight + additionalWeight;
					predecessors[this.noeuds.indexOf(node)] = minNode;
				}
			}
			loop++;
		}

		Noeud current = dest;
		Noeud predecessor;
		while(current != dep) {
			path.add(current);
			predecessor = predecessors[this.noeuds.indexOf(current)];
			current = predecessor;
		}
		path.add(dep);
		Collections.reverse(path);
		return path;
	}

	public int[][] arcToMatrix() {
		// Construction de la matrice d'adjacence
		int n = this.noeuds.size();
		int adjacentMatrix[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Arc arc = new Arc(this.noeuds.get(i), this.noeuds.get(j), 1, 1);
				for(Arc a : this.arcs) {
					if (a.getDepart() == arc.getDepart() && a.getFin() == arc.getFin()) {
						adjacentMatrix[i][j] = 1;
					}
				}
			}
		}
		return adjacentMatrix;
	}

	public void printMatrix(int[][] m) {
		int n = m.length;
		System.out.print("[ ");
		for(int i=0; i<n; i++) {
			for(int e : m[i]) {
				System.out.print(e + " ");
			}
			if(i < n - 1) {
				System.out.print("\n  ");
			}
		}
		System.out.print("]\n");
	}

	public void deplacerPaquet(Paquet paquet, int path[]) {
		// Mise a jour arcs[], noeuds[] et paquets[]
		// Probleme: comment metre a jour la position du paquet dans l'arc sans
		// avoir acces a la taille de l'arc
	}

	public void refresh() {
		// Mise à jour générale
		for(Arc a : this.arcs) {
			a.refresh();
		}
		this.temps++;
	}

	public void run() throws InterruptedException {
		// Fonction principale appelée par l'interface graphique
		while(true) {
			this.refresh();
			System.out.println("Loop");
			Thread.sleep(this.tauxActualisation);
		}
	}
}
