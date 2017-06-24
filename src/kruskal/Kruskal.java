package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Kruskal {
	private int costo;
	int [] vectorCamino;
	private ArrayList<NodoKruskal> listaSolucion = new ArrayList<>();
	private ArrayList<NodoKruskal> listaAristas = new ArrayList<>();

	public Kruskal(int grafo[][]) {
		costo = 0;
		vectorCamino = new int[grafo.length];
		for (int i = 0; i < grafo.length; i++) {
			for (int j = i+1; j < grafo.length; j++) {
				if (grafo[i][j] != 999) {
					listaAristas.add(new NodoKruskal(i, j, grafo[i][j]));
				}
			}
		}
		Collections.sort(listaAristas, new Comparator<NodoKruskal>(){
			@Override
			public int compare(NodoKruskal n1, NodoKruskal n2) {
				return n1.getCosto() - n2.getCosto();
			}
		});
	}

	public void resolver() {
		int count = 0;
		// INICIALIZO VECTOR DE VISITADOS
		for (int i = 0; i < vectorCamino.length; i++) {
			vectorCamino[i] = i;
		}
		Iterator<NodoKruskal> it = listaAristas.iterator();
		NodoKruskal nodoKruskal = null;
		while(it.hasNext() && count != (vectorCamino.length -1)) {
			nodoKruskal = it.next();
			if (find(nodoKruskal.getNodo1()) != find(nodoKruskal.getNodo2())){
				union(nodoKruskal.getNodo1(), nodoKruskal.getNodo2());
				listaSolucion.add(nodoKruskal);
				costo += nodoKruskal.getCosto();
				count++;
			}
		}
	}
	
	public int find (int x) {
		return (x == vectorCamino[x])? x : find (vectorCamino[x]);
	}
	
	public void union (int x, int y) {
		vectorCamino[find(x)] = find(y);
	}
	
	public void imprimirSalida() {
		for (NodoKruskal nodoKruskal : listaSolucion) {
			System.out.println(Integer.valueOf(nodoKruskal.getNodo1()+1) + " " + Integer.valueOf(nodoKruskal.getNodo2()+1) + " - " + nodoKruskal.getCosto());
		}
		System.out.println("Costo: " + costo);
	}
}
