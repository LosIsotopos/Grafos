package warshall;


public class Main {

	public static void main(String[] args) {
		int[][] grafo = {{99,10,5},{99,99,99},{99,3,99}};
//		int[][] grafo = {{99,99,99,99},{7,99,99,99},{4,99,99,5},{6,10,99,99}};
//		int[][] grafo = {{99,10,5},{2,99,99},{99,3,99}};
		Warshall f1 = new Warshall(grafo);
		f1.resolver();
		f1.imprimirSalida();
	}
}
