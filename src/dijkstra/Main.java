package dijkstra;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//HARDCODEO TODOS LOS DATOS
		int claros = 9;
		int senderos = 10;
		int dragones = 2;
		int nodoPrincesa = 9;
		int nodoPrincipe = 1;
		int nodoDragon1 = 5;
		int nodoDragon2 = 8;
		ArrayList<Integer> listaNodos = new ArrayList<Integer>();
		int []result = new int [claros];
		int mat[][] = {{99,3,2,99,99,99,99,99,99},{3,99,4,99,99,1,99,99,99},{2,4,99,2,99,2,99,1,99},
				{99,99,2,99,2,99,99,99,99},{99,99,99,2,99,99,99,99,99},{99,1,2,99,99,99,99,5,3},
				{99,99,99,99,99,99,99,99,99},{99,99,1,99,99,5,99,99,99},{99,99,99,99,99,3,99,99,99}};
		int x = 999;
		int ej[][] = {{x,100,30,20,x},{x,x,x,x,x},{x,40,x,x,5},{x,x,x,x,x},{x,30,x,40,x}};
		// CARGO LA LISTA DE NODOS
//		for (int i = 1; i < 10; i++) {
//			listaNodos.add(i);
//		}
//		
//		MyDijkstra d1 = new MyDijkstra(claros, mat, nodoPrincesa, listaNodos);
//		result = d1.resolver();
//		
//		System.out.println("01-02-03-04-05-06-07-08-09");
//		for (int i = 0; i < result.length; i++) {
//			if(result[i] < 10) {
//				System.out.print("0" + result[i]+ "-");
//			} else {
//				System.out.print(result[i]+ "-");				
//			}
//		}

		MyDijkstra d1 = new MyDijkstra(ej, 1);
		d1.resolver();
		d1.imprimirSolucion();
	}

}
