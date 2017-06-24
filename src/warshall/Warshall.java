package warshall;

public class Warshall {
	private boolean[][] matrizSolucion;
	
	public Warshall(int[][] grafo) {
		matrizSolucion = new boolean [grafo.length][grafo.length];
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				if (grafo[i][j] != 99){
					matrizSolucion[i][j] = true;					
				}
			}
		}
	}

	public void resolver() {
		boolean[][] aAnt = matrizSolucion.clone();
		boolean[][] aNow = matrizSolucion.clone();
		
		for (int i = 0; i < aNow.length; i++) {
			for (int j = 0; j < aNow.length; j++) {
				if (i != j){
					for (int k = 0; k < aNow.length; k++) {
						if (!(i == k || j == k)){
							if (aAnt[i][j] || (aNow[i][k] && aNow[k][j])) {
								aNow[i][j] = true; 
							}
						}
					}					
				}
			}
			aAnt = aNow;
		}
	}

	public void imprimirSalida() {
		for (int i = 0; i < matrizSolucion.length; i++) {
			for (int j = 0; j < matrizSolucion.length; j++) {
				System.out.print(matrizSolucion[i][j] + " ");
			}
			System.out.println();
		}
	}

}
