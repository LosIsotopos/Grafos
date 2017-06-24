package kruskal;

public class NodoKruskal {
	private int nodo1;
	private int nodo2;
	private int costo;
	
	public NodoKruskal(int nodo1, int nodo2, int costo) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
		this.costo = costo;
	}

	public int getNodo1() {
		return nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}

	public int getCosto() {
		return costo;
	}	
}
