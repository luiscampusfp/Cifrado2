package Simetrico;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Cifrado {
	private Cipher cipher;
	private SecretKey key;

	public Cifrado(String clave) {
		try {
			cipher = Cipher.getInstance("AES");
			byte[] claveEncriptada = clave.getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			claveEncriptada = md.digest(claveEncriptada);
			claveEncriptada = Arrays.copyOf(claveEncriptada, 16);
			key = new SecretKeySpec(claveEncriptada, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public byte[] cifrarMensaje(String mensaje) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] mensajeCifrado = mensaje.getBytes();
			mensajeCifrado = cipher.doFinal(mensajeCifrado);
			return mensajeCifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String descifrarMensaje(byte[] cifrado) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] descifrado = cipher.doFinal(cifrado);
			return new String(descifrado);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public byte[] cifrarObjeto(Object ob) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(ob);
			oos.flush();
			byte[] obCifrado = bos.toByteArray();
			obCifrado = cipher.doFinal(obCifrado);
			return obCifrado;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object descifrarObjeto(byte[] cifrado) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] descifrado = cipher.doFinal(cifrado);
			ByteArrayInputStream bis = new ByteArrayInputStream(descifrado);
			ObjectInput oi = new ObjectInputStream(bis);
			return oi.readObject();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
