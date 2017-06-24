package dfs;


public class Main {

	public static void main(String[] args) {
//		int[][] grafo = {{99,10,5},{99,99,99},{99,3,99}};
//		int[][] grafo = {{99,99,99,99},{7,99,99,99},{4,99,99,5},{6,10,99,99}};
//		int[][] grafo = {{99,10,5},{2,99,99},{99,3,99}};
		int x = 999;
		int grafo[][] = {{x,2,x,3,x,x,x,x,x,x},{0,x,2,x,x,x,x,x,x,x},{x,5,x,6,x,7,x,x,x,x},{3,x,4,x,7,x,x,x,x,x},
				{x,x,x,7,x,6,x,3,x,x},{x,x,5,x,5,x,x,x,x,x},{x,x,x,x,x,x,x,6,x,x},{x,x,x,x,x,x,5,x,5,x},
				{x,x,x,x,x,x,x,8,x,x},{x,x,x,x,x,x,x,x,x,x}};
		Dfs f1 = new Dfs(grafo,4);
		f1.resolver();
		f1.imprimirSalida();
	}

}
