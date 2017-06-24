package kruskal;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantNodos = 7;
		int nodoInicio = 1;
//		int [] v1 = {1,6,1,3,4,4,3,3,7,4,6,2};
//		int [] v2 = {4,7,2,4,2,7,1,6,5,5,4,5};
//		int [] v3 = {1,1,2,2,3,4,4,5,6,7,8,10};
		int x = 999;
		int grafo[][] = {{x,2,4,1,x,x,x},{2,x,x,3,10,x,x},{4,x,x,2,x,5,x},{1,3,2,x,7,8,4},{x,10,x,7,x,x,6},
				{x,x,5,8,x,x,1},{x,x,x,4,6,1,x}};
		int grafoDijk[][] = {{x,100,30,20,x},{100,x,40,x,30},{30,40,x,x,5},{20,x,x,x,40},{x,30,5,40,x},};
 		ArrayList<Integer> listaNodos = new ArrayList<Integer>();
		
 		Kruskal d1 = new Kruskal(grafo);
		d1.resolver();
		d1.imprimirSalida();
// 		Kruskal d1 = new Kruskal(grafoDijk);
//		d1.resolver();
//		d1.imprimirSalida();
	}

}
