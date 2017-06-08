package unidad1;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Encriptacion {
	public String encriptar(String valor) throws UnsupportedEncodingException {
		String respuesta=new String();
		
		try {
			respuesta=Base64.getEncoder().encodeToString(valor.getBytes(valor));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		return respuesta;
		
		
	}
public String desencriptar(String valor) {
	String respuesta=null;
			
			try {
				respuesta=new String(Base64.getMimeDecoder().decode(valor),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	return respuesta;
	 
	
}

}
