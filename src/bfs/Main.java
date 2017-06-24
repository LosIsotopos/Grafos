package bfs;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 999;
		int grafo[][] = {{x,2,x,3,x,x,x,x,x,x},{0,x,2,x,x,x,x,x,x,x},{x,5,x,6,x,7,x,x,x,x},{3,x,4,x,7,x,x,x,x,x},
				{x,x,x,7,x,6,x,3,x,x},{x,x,5,x,5,x,x,x,x,x},{x,x,x,x,x,x,x,6,x,x},{x,x,x,x,x,x,5,x,5,x},
				{x,x,x,x,x,x,x,8,x,x},{x,x,x,x,x,x,x,x,x,x}};
		Bfs f1 = new Bfs(grafo,4);
		f1.resolver();
		f1.imprimirSalida();
	}

}
