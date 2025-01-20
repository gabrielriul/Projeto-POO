//Gabriel Riul Perissé
//RA: 2064430

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura{

	public String entDados(String rotulo){

		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);
		
		String ret ="";
			
		try{
			ret = buff.readLine();
		}
		catch(IOException ioe){
			System.out.println("\nERRO de sistema: RAM - TECLADO");
		}

		return ret;
	}

}