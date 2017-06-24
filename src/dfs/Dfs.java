package dfs;

import java.util.ArrayList;
import java.util.Stack;

public class Dfs {
	private int nodoInicio;
	private int[][] matrizAdy;
	private Stack<Integer> pila = new Stack<Integer>();
	private boolean[] vecSolucion;
	
	public Dfs(int[][] grafo, int nodoInicial) {
		nodoInicio = nodoInicial;
		matrizAdy = grafo.clone();
		vecSolucion = new boolean[matrizAdy.length];
	}

	public void resolver() {
		int nodoActual = nodoInicio;
		int i = 0;
		boolean encontroAdy = false;
		pila.push(nodoInicio);
		vecSolucion[nodoInicio] = true;
		while (!pila.isEmpty()) {
			if (buscarAdyacencia(nodoActual)) {
				while( i < matrizAdy.length && !encontroAdy) {
					if (matrizAdy[nodoActual][i] != 999 && !vecSolucion[i]) {
						vecSolucion[i] = true;
						pila.push(i);
						nodoActual = i;
						encontroAdy = true;
					}
					i++;
				}
				encontroAdy = false;
				i = 0;
			} else {
				pila.pop();
				if (!pila.isEmpty()) {
					nodoActual = pila.peek();					
				}
			}
		}
	}

	public void imprimirSalida() {
		for (int i = 0; i < vecSolucion.length; i++) {
			System.out.println(vecSolucion[i] + " ");
		}
	}

	private boolean buscarAdyacencia(int w) {
		for (int i = 0; i < matrizAdy[w].length; i++) {
			if (matrizAdy[w][i] != 999 && vecSolucion[i] == false) {
				return true;
			}
		}
		return false;
	}
}
