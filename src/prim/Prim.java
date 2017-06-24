package prim;

import java.util.ArrayList;

import kruskal.NodoKruskal;

public class Prim {
	private int nodoInicio;
	private int costo;
	private int[][] matrizAdy;
	private int[][] matrizSol;
	private ArrayList<Integer> conjSolucion = new ArrayList<Integer>();
	private ArrayList<Integer> conjNS = new ArrayList<Integer>();
	private ArrayList<Integer> listaNodos = new ArrayList<Integer>();

	public Prim (int[][] matAdy) {
		nodoInicio = 1;
		costo = 0;
		matrizAdy = matAdy;
		for (int i = 1; i <= matAdy.length; i++) {
			conjNS.add(i);
		}
		listaNodos = (ArrayList<Integer>) conjNS.clone();
		matrizSol = new int[matAdy.length][matAdy.length];
		for (int i = 0; i < matrizSol.length; i++) {
			for (int j = 0; j < matrizSol.length; j++) {
				matrizSol[i][j] = 999;
			}
		}
	}

	public void resolver() {
		// W = NODO A TRATAR
		int w;
		int u;
		// PASO EL NODO INICIAL AL CONJUNTO SOLUCION
		// SACO NODO INICIAL DE CONJUNTO NS
		conjSolucion.add(nodoInicio);
		conjNS.remove((Object)nodoInicio);
		// MIENTRAS QUE TENGA ALGO EN EL CONJ NS ITERO
		while(!conjNS.isEmpty()) {
			// BUSCO UN W QUE SERIA EL MENOR DE TODAS LAS DISTANCIAS QUE OBTUVE Y LO PASO AL CONJ SOL
			// Y LO SACO DE CONJ NS
			w = findLower(); // la primera vez es 3 osea nodo 4
			u = w+1;
			conjSolucion.add(u);
			conjNS.remove((Object) u);
		}
	}

	private int findLower() {
		int menor = Integer.MAX_VALUE;
		int fila = 0;
		int retorno = -1; // es la columna
		for (Integer list : conjSolucion) {
			for (int i = 0; i < matrizAdy.length; i++) {
				if(conjNS.contains(i+1) && matrizAdy[listaNodos.indexOf(list)][i] != 999 && menor >= matrizAdy[listaNodos.indexOf(list)][i]) {					
					menor = matrizAdy[listaNodos.indexOf(list)][i];
					fila = list-1;
					retorno = i;
				}
			}
		}
		costo += matrizAdy[fila][retorno];
		matrizSol[fila][retorno] = matrizAdy[fila][retorno];
		return retorno;
	}
	
	public void imprimirSalida() {
		for (int i = 0; i < matrizSol.length; i++) {
			for (int j = 0; j < matrizSol.length; j++) {
				if(matrizSol[i][j] != 999) {
					//cambiar syso por printear al archivo
					System.out.println(Integer.valueOf(i+1) + " " + Integer.valueOf(j+1) + " - " + matrizSol[i][j]);
				}
			}
		}
		System.out.println("Costo: " + costo);
	}
	public int[][] getMatrizSol() {
		return matrizSol;
	}

	public int getCosto() {
		return costo;
	}
}
