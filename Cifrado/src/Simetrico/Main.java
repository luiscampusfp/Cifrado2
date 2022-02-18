package Simetrico;

import java.security.MessageDigest;

public class Main {

	public static void main(String[] args) {
		/*Cifrado cif = new Cifrado("1234");
		byte[] mensaje = cif.cifrarMensaje("Hola");
		System.out.println(new String(mensaje));
		String mensajedes = cif.descifrarMensaje(mensaje);
		System.out.println(mensajedes);

		ObjetoSimple os = new ObjetoSimple("hola", 20);

		byte[] objeto = cif.cifrarObjeto(os);
		System.out.println(new String(objeto));
		ObjetoSimple os2 = (ObjetoSimple) cif.descifrarObjeto(objeto);
		System.out.println(os2.toString());*/

		CifradoAsimetrico cifa = new CifradoAsimetrico("1234");
		byte[] mensaje2 = cifa.cifrarMensaje("HolaHOLA");
		System.out.println(new String(mensaje2));
		System.out.println(cifa.descifrarMensaje(mensaje2));
	}

}
