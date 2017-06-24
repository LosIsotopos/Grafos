package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	private int nodoInicio;
	private int[][] matrizAdy;
	private Queue<Integer> cola = new LinkedList<Integer>();
	private int[] distancia;
	
	public Bfs(int[][] grafo, int nodoInicial) {
		nodoInicio = nodoInicial;
		matrizAdy = grafo.clone();
		distancia = new int[matrizAdy.length];
		for (int i = 0; i < distancia.length; i++) {
			distancia[i] = -1;
		}
	}

	public void resolver() {
		int nodoActual = nodoInicio;
		cola.add(nodoInicio);
		distancia[nodoInicio] = 0;
		while (!cola.isEmpty()) {
			if (buscarAdyacencia(nodoActual)) {
				for (int i = 0; i < distancia.length; i++) {
					if (matrizAdy[nodoActual][i] != 999 && distancia[i] == -1) {
						cola.add(i);
						distancia[i] = distancia[nodoActual] + 1;
					}
				}
			} else {
				cola.poll();
				if (!cola.isEmpty()) {
					nodoActual = cola.peek();					
				}
			}
		}
	}

	public void imprimirSalida() {
		for (int i = 0; i < distancia.length; i++) {
			System.out.print(distancia[i] + " ");
		}
	}

	private boolean buscarAdyacencia(int w) {
		for (int i = 0; i < matrizAdy[w].length; i++) {
			if (matrizAdy[w][i] != 999 && distancia[i] == -1) {
				return true;
			}
		}
		return false;
	}
}
