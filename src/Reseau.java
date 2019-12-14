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

	public ArrayList<Paquet> getPaquets() {
		return this.paquets;
	}

	public ArrayList<Arc> getArcs() {
		return this.arcs;
	}

	public ArrayList<Noeud> getNoeuds() {
		return this.noeuds;
	}

	public void addPaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		this.paquets.add(paquet);
	}

	public void addArc(Arc arc) {
		// Mise a jour de arcs[]
		this.arcs.add(arc);
	}

	public void addNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		this.noeuds.add(noeud);
	}

	public void removePaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		for(int i=0; i<paquets.size(); i++) {
			if(paquets.get(i) == paquet) {
				this.paquets.remove(i);
				return;
			}
		}
		return;
	}

	public void removeArc(Arc arc) {
		// Mise a jour de arcs[]
		for(int i=0; i<arcs.size(); i++) {
			if(arcs.get(i) == arc) {
				this.arcs.remove(i);
				return;
			}
		}
		return;
	}

	public void removeNoeud(Noeud noeud) {
		// Mise a jour de noeuds[]
		for(int i=0; i<noeuds.size(); i++) {
			if(noeuds.get(i) == noeud) {
				this.noeuds.remove(i);
				return;
			}
		}
		return;
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
			//System.out.println(node.getID());
			weights[node.getID()] = -1;
			//System.out.println(weights[node.getID()]);
		}
		/*for(int i : weights) {
			System.out.println(i);
		}*/
		for(Noeud node : this.noeuds) {
			predecessors[node.getID()] = null;
		}
		weights[dep.getID()] = 0;
		for(Noeud node : getAfterNeighbours(dep)) {
			weights[node.getID()] = getArcFromNodes(dep, node).getLongueur();
			predecessors[node.getID()] = dep;
		}
		/*for(int i : weights) {
			System.out.println(i);
		}*/
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
				int weight = weights[node.getID()];
				if (!visitedNodes.contains(node) && weight >= 0 && weight < min && (node != dep || loop == 0)) {
					minNode = node;
					min = weights[node.getID()];
				}
			}
			if(minNode == null) {
				return null;
			}
			visitedNodes.add(minNode);
			/*if(minNode != dest) {
				System.out.println(minNode.getID());
				int cmpt = 0;
				int size = getAfterNeighbours(minNode).size();
				for (Noeud node : getAfterNeighbours(minNode)) {
					if (visitedNodes.contains(node)) {
						cmpt++;
					}
				}
				if (cmpt == size) {
					return null;
				}
			}*/
			for (Noeud node : getAfterNeighbours(minNode)) {
				minNodeWeight = weights[minNode.getID()];
				currentNodeWeight = weights[node.getID()];
				additionalWeight = getArcFromNodes(minNode, node).getLongueur();
				if (currentNodeWeight == -1 || currentNodeWeight > minNodeWeight + additionalWeight) {
					weights[node.getID()] = minNodeWeight + additionalWeight;
					predecessors[node.getID()] = minNode;
				}
			}
			loop++;
		}
		Noeud current = dest;
		Noeud predecessor;
		while(current != dep) {
			path.add(current);
			predecessor = predecessors[current.getID()];
			current = predecessor;
		}
		path.add(dep);
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
		return;
	}

	public void refresh() {
		// Mise à jour générale
		for(Arc a : this.arcs) {
			a.refresh();
		}
		this.temps++;
	}
}
