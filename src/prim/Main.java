package prim;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HARDCODEO TODOS LOS DATOS
		int nodos = 7;
		int aristas = nodos+1;
		int nodoInicio = 1;
		ArrayList<Integer> listaNodos = new ArrayList<Integer>();
		int x = 999;
		int ej[][] = {{x,2,4,1,x,x,x},{2,x,x,3,10,x,x},{4,x,x,2,x,5,x},{1,3,2,x,7,8,4},{x,10,x,7,x,x,6},
				{x,x,5,8,x,x,1},{x,x,x,4,6,1,x}};
		int ejDijk[][] = {{x,100,30,20,x},{100,x,40,x,30},{30,40,x,x,5},{20,x,x,x,40},{x,30,5,40,x},};
		// CARGO LA LISTA DE NODOS
		for (int i = 1; i < aristas; i++) {
			listaNodos.add(i);
		}
		Prim d1 = new Prim(ej);
		d1.resolver();
		d1.imprimirSalida();
		
//		for (int i = 1; i < 6; i++) {
//			listaNodos.add(i);
//		}
//		Prim d1 = new Prim(5, ejDijk, nodoInicio, listaNodos);
//		d1.resolver();
//		d1.imprimirSalida();
	}

}
