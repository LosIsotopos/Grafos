package floyd;

public class Floyd {
	private int[][] fCero;
	
	public Floyd(int[][] grafo) {
		fCero = grafo;
		for (int i = 0; i < grafo.length; i++) {
			fCero[i][i] = 0;
		}
	}

	public void resolver() {
		int[][] fAnt = fCero;
		int[][] fNow = fCero.clone();
		
		for (int i = 0; i < fNow.length; i++) {
			for (int j = 0; j < fNow.length; j++) {
				if (i != j){
					for (int k = 0; k < fNow.length; k++) {
						if (!(i == k || j == k)){
							if (fAnt[i][j] > (fNow[i][k]+fNow[k][j])) {
								fNow[i][j] = fNow[i][k] + fNow[k][j];
							}
						}
					}					
				}
			}
			fAnt = fNow;
		}
	}

	public void imprimirSalida() {
		for (int i = 0; i < fCero.length; i++) {
			for (int j = 0; j < fCero.length; j++) {
				System.out.print(fCero[i][j] + " ");
			}
			System.out.println();
		}
	}
}
