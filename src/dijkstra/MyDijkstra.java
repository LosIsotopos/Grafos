package dijkstra;

import java.util.ArrayList;

public class MyDijkstra {
	private int nodoInicio;
	private int[] distResult;
	private int[] vecPrecedencia;
	private int[][] matrizAdy;
	private ArrayList<Integer> conjSolucion = new ArrayList<Integer>();
	private ArrayList<Integer> conjNS = new ArrayList<Integer>();

	public MyDijkstra(int[][] matAdy, int nodoInicial) {
		nodoInicio = nodoInicial;
		distResult = new int[matAdy.length];
		vecPrecedencia = new int[matAdy.length];
		matrizAdy = matAdy;
		for (int i = 1; i <= matAdy.length; i++) {
			conjNS.add(i);
		}
	}

	public void resolver() {
		// W = NODO A TRATAR
		int w;
		int u;
		// CARGO LA PRIMERA VEZ, QUE SERIA CUNADO NO HAY NADA EN EL CONJUNTO SOLUCION
		// POR LO TANTO CARGO LAS DISTANCIAS DEL NODO INICIAL A LOS DEMAS
		for (int i = 0; i < distResult.length; i++) {
			vecPrecedencia[i] = nodoInicio;
		}
		for (int i = 0; i < distResult.length; i++) {
			distResult[i] = matrizAdy[nodoInicio-1][i];
		}
		distResult[nodoInicio-1] = -9;
		// PASO EL NODO INICIAL AL CONJUNTO SOLUCION
		conjSolucion.add(nodoInicio);
		// SACO NODO INICIAL DE CONJUNTO NS
		conjNS.remove((Object)nodoInicio);
		
		vecPrecedencia[nodoInicio-1] = -1;
		// MIENTRAS QUE TENGA ALGO EN EL CONJ NS ITERO
		while(!conjNS.isEmpty()) {
			// BUSCO UN W QUE SERIA EL MENOR DE TODAS LAS DISTANCIAS QUE OBTUVE Y LO PASO AL CONJ SOL
			// Y LO SACO DE CONJ NS
			w = findLower(distResult,conjNS); // la primera vez es 4 osea D
			u = w+1;
			conjSolucion.add(u);
			conjNS.remove((Object) u);
			if (buscarAdyacencia(w, conjNS)){
				for (int j = 0; j < matrizAdy[w].length; j++) {
					if(matrizAdy[w][j] != 999) {
						if (distResult[j] > distResult[w] + matrizAdy[w][j]) {
							distResult[j] = distResult[w] + matrizAdy[w][j];
							vecPrecedencia[j] = w+1;
						}
					}			
				}
			}
		}
	}
	
	private boolean buscarAdyacencia(int w, ArrayList<Integer> conjNS2) {
		for (int i = 0; i < matrizAdy[w].length; i++) {
			if (matrizAdy[w][i] != 999 && conjNS2.contains(i+1)) {
				return true;
			}
		}
		return false;
	}

	private int findLower(int[] distResult, ArrayList<Integer> conjNS2) {
		int menor = Integer.MAX_VALUE;
		int retorno = -1;
		for (int i = 0; i < distResult.length; i++) {
			if(conjNS2.contains(i+1) && menor > distResult[i]) {
				menor = distResult[i];
				retorno = i;
			}
		}
		return retorno;
	}

	public void imprimirSolucion () {
		System.out.println("Vector de Costos");
		for (int i = 0; i < distResult.length; i++) {
			System.out.print(distResult[i] + " ");
		}
		System.out.println();
		mostrarCamino();
	}
	
	public void mostrarCamino () {
		int i = conjSolucion.get(vecPrecedencia.length-1)-1;
		int j = 0;
		int[] camino = new int [vecPrecedencia.length];
		camino[j] = i+1;
		j++;
		while (vecPrecedencia[i] != nodoInicio) {
			camino[j] = vecPrecedencia[i];
			i = vecPrecedencia[i]-1;
			j++;
		}
		camino[j] = nodoInicio;
		System.out.println("Camino");
		for (j = camino.length-1; j >= 0; j--) {
			if (camino[j] != 0) {
				System.out.print(camino[j] + " ");				
			}
		}
		System.out.println();
	}
	
	public int[] getVecPrecedencia() {
		return vecPrecedencia;
	}

	public void setVecPrecedencia(int[] vecPrecedencia) {
		this.vecPrecedencia = vecPrecedencia;
	}
	
	public int[] getDistResult() {
		return distResult;
	}

	public void setDistResult(int[] distResult) {
		this.distResult = distResult;
	}

	public ArrayList<Integer> getConjSolucion() {
		return conjSolucion;
	}

	public void setConjSolucion(ArrayList<Integer> conjSolucion) {
		this.conjSolucion = conjSolucion;
	}

	public ArrayList<Integer> getConjNS() {
		return conjNS;
	}

	public void setConjNS(ArrayList<Integer> conjNS) {
		this.conjNS = conjNS;
	}	
}
