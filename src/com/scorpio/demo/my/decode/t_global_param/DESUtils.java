package com.scorpio.demo.my.decode.t_global_param;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DESUtils {

	public static Key createNewKey() throws NoSuchAlgorithmException {
		Security.insertProviderAt(new com.sun.crypto.provider.SunJCE(), 1);
		KeyGenerator generator = KeyGenerator.getInstance("DES");
		generator.init(new SecureRandom());
		Key key = generator.generateKey();
		key.getEncoded();
		return key;
	}
	
	public static Key getKeyByHexStr(byte[] keyBytes) throws NoSuchAlgorithmException {
		return new SecretKeySpec(keyBytes, "DES");
	}

	public static byte[] doEncrypt(Key key, byte[] data)
			throws EncryptException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}

	public static byte[] doDecrypt(Key key, byte[] raw)
			throws EncryptException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] data = cipher.doFinal(raw);
		return data;
	}

	public static Cipher getCipher(Key key, int cipherMode)
			throws EncryptException {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(cipherMode, key);
			return cipher;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EncryptException("Generate Cipher occurs Exception.["
					+ e.getMessage() + "]");
		}
	}
	
	
}
