import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Reseau {
	private ArrayList<Paquet> paquets;
	private ArrayList<Arc> arcs;
	private ArrayList<Noeud> noeuds;
	private int temps;
	private int tauxActualisation;
	
	public Reseau() {
		// Constructeur
		this.paquets = new ArrayList<>();
		this.arcs = new ArrayList<>();
		this.noeuds = new ArrayList<>();
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

	public int getTemps() { return this.temps; }

	public void addPaquet(Paquet paquet) {
		// Mise a jour de paquets[]
		assert(!this.paquets.contains(paquet));
		for(Paquet p : this.paquets) {
			assert(paquet.getId() != p.getId());
		}
		this.paquets.add(paquet);
		for(Noeud noeud : this.noeuds) {
			if(noeud == paquet.getNoeudDepart()) {
				noeud.enterPaquet(paquet);
				return;
			}
		}
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
			assert(!n.getID().equals(noeud.getID()));
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
		ArrayList<Arc> relatedArcs = new ArrayList<>();
		for(Arc a : this.arcs) {
			if(a.getDepart() == depart) {
				relatedArcs.add(a);
			}
		}
		return relatedArcs;
	}

	public ArrayList<Arc> getBeforeArcsFromNode(Noeud fin) {
		ArrayList<Arc> relatedArcs = new ArrayList<>();
		for(Arc a : this.arcs) {
			if(a.getFin() == fin) {
				relatedArcs.add(a);
			}
		}
		return relatedArcs;
	}

	public ArrayList<Noeud> getAfterNeighbours(Noeud node) {
		ArrayList<Noeud> neighbours = new ArrayList<>();
		for(Arc a : getAfterArcsFromNode(node)) {
			neighbours.add(a.getFin());
		}
		return neighbours;
	}

	public ArrayList<Noeud> getBeforeNeighbours(Noeud node) {
		ArrayList<Noeud> neighbours = new ArrayList<>();
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
		int[] weights = new int[n];
		Noeud[] predecessors = new Noeud[n];
		ArrayList<Noeud> visitedNodes = new ArrayList<>();
		ArrayList<Noeud> path = new ArrayList<>();

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

	public ArrayList<Noeud> randomPath(Paquet paquet) {
		// Calcul d'un chemin aléatoire
		Noeud dep = paquet.getNoeudDepart();
		Noeud dest = paquet.getNoeudDestination();

		if(getAfterNeighbours(dep).isEmpty() || getBeforeNeighbours(dest).isEmpty()) {
			return null;
		}

		int n = this.noeuds.size();
		int[] weights = new int[n];
		Noeud[] predecessors = new Noeud[n];
		ArrayList<Noeud> visitedNodes = new ArrayList<>();
		ArrayList<Noeud> path = new ArrayList<>();

		for(Noeud node : this.noeuds) {
			weights[this.noeuds.indexOf(node)] = -1;
		}
		for(Noeud node : this.noeuds) {
			predecessors[this.noeuds.indexOf(node)] = null;
		}
		weights[dep.getID()] = 0;
		for(Noeud node : getAfterNeighbours(dep)) {
			weights[node.getID()] = 0;
			predecessors[this.noeuds.indexOf(node)] = dep;
		}

		Noeud nextNode = null;
		int loop = 0;

		while(nextNode != dest) {
			if(visitedNodes.size() == this.noeuds.size()){
				return null;
			}

			ArrayList<Noeud> potentialNodes = new ArrayList<>();
			for (Noeud node : this.noeuds) {
				if (!visitedNodes.contains(node) && weights[this.noeuds.indexOf(node)] >= 0 && (nextNode != dep || loop == 0)) {
					potentialNodes.add(node);
				}
			}
			if(potentialNodes.isEmpty()) {
				return null;
			}
			nextNode = potentialNodes.get((int) Math.round(Math.random() * (potentialNodes.size()-1)));
			visitedNodes.add(nextNode);

			for (Noeud node : getAfterNeighbours(nextNode)) {
				weights[this.noeuds.indexOf(node)] = 0;
				predecessors[this.noeuds.indexOf(node)] = nextNode;
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
		int[][] adjacentMatrix = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Arc arc = new Arc(1000000, this.noeuds.get(i), this.noeuds.get(j), 1, 1);
				for(Arc a : this.arcs) {
					if (a.getDepart() == arc.getDepart() && a.getFin() == arc.getFin()) {
						adjacentMatrix[i][j] = 1;
						break;
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

	public void enterArc(Paquet paquet) {
		for (int i=0; i<paquet.getTrajet().size(); i++) {
			Noeud current = paquet.getTrajet().get(i);
			if (current == paquet.getNoeudPosition()) {
				Noeud next = paquet.getTrajet().get(i+1);
				this.getArcFromNodes(current, next).addPaquet(paquet);
				break;
			}
		}
	}

	public void enterNoeud(Paquet paquet) {
		// Mise a jour arcs[], noeuds[] et paquets[]
		// Probleme: comment metre a jour la position du paquet dans l'arc sans
		// avoir acces a la taille de l'arc
		for (int i=0; i<paquet.getTrajet().size(); i++) {
			Noeud current = paquet.getTrajet().get(i);
			if (current == paquet.getNoeudPosition()) {
				Noeud next = paquet.getTrajet().get(i+1);
				paquet.setNoeudPosition(next);
				if(next == paquet.getNoeudDestination()) {

					this.removePaquet(paquet);
					return;
				}
				next.enterPaquet(paquet);
				break;
			}
		}
	}

	public void refreshArcs() {
		for(Arc a : this.arcs) {
			Paquet exitPaquet = a.refresh();
			if (exitPaquet != null) {
				a.removePaquet(exitPaquet);
				this.enterNoeud(exitPaquet);
			}
		}
	}

	public void refreshNoeuds() {
		Paquet exitPaquet;
		for(Noeud noeud : this.noeuds) {
			exitPaquet = noeud.exitPaquet();
			if(exitPaquet != null) {
				this.enterArc(exitPaquet);
			}
		}
	}

	public void refresh() {
		// Mise à jour générale
		this.refreshNoeuds();
		this.refreshArcs();
		this.temps++;
	}

	public void paquetsGeneration(int num, boolean random){
		Noeud dep = null;
		Noeud dest = null;
		Paquet paquet = null;
		ArrayList<Noeud> path;
		for(int i=0; i<num; i++){
			path = null;
			while(path == null) {
				dep = this.noeuds.get((int) Math.round(Math.random() * (this.noeuds.size()-1)));
				dest = this.noeuds.get((int) Math.round(Math.random() * (this.noeuds.size()-1)));
				int priority;
				priority = 1;
				//priority = (int) Math.round(Math.random() * 5);
				paquet = new Paquet(i, dep, dest, priority, new ArrayList<>());
				if(random) {
					path = randomPath(paquet);
				} else {
					path = plusCourtChemin(paquet);
				}
			}
			paquet.setTrajet(path);
			//System.out.println("\n" + dep);
			//System.out.println(dest);
			//System.out.println(path);
			this.addPaquet(paquet);
		}
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
