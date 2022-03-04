package Simetrico;

public class Main {

	public static void main(String[] args) {
		Cifrado cif = new Cifrado("1234");
		byte[] mensaje = cif.cifrarMensaje("Hola");
		System.out.println(new String(mensaje));
		String mensajedes = cif.descifrarMensaje(mensaje);
		System.out.println(mensajedes);

	}

}
