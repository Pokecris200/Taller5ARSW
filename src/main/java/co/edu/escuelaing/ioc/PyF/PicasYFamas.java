package co.edu.escuelaing.ioc.PyF;

import java.util.Random;

public class PicasYFamas {

	private String clave;
	
	private int intentos;
	
	private static PicasYFamas _instance = new PicasYFamas();
	
	public PicasYFamas getInstance() {
		return _instance;
	}
	
	public void newGame() {
		intentos = 8;
		Random r = new Random();
		for(int i=0 ; i<4 ;i++) {
			clave += r.nextInt(10);
		}
		System.out.println(clave);
	}
	
	public int[] compare(String cadena) {
		int[] pair = new int[2];
		int picas = 0, famas = 0;
		for(int i=0 ; i<4 ;i++) {
			if(clave.contains(cadena.substring(i, i+1))) {
				if(clave.charAt(i) == cadena.charAt(i)) {
					famas++;
				}
				else {
					picas++;
				}
			}
		}
		pair[0] = famas;
		pair[1] = picas;
		return pair;
		
	}
	
	public String gameTurn(String cadena) {
		intentos--;
		String r = "";
		if(intentos > 0 ) {
			int[] resultado = compare(cadena);
			r = "Picas: "+ resultado[0] + "      Famas: " + resultado[1];
		}
		else {
			r = "Game Over! >:3";
		}
		return r;
	}
}
