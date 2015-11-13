package com.scorpio.demo.my.decode.t_global_param;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdUtil {
	public static final String ENCRYPT_PASSWORD = ":=$encp$=:";
	private static final String PUB3_KEY = "9219687f37195d80";
	
	public static final String hexStr = "0123456789abcdef";
	private static Key key = null;
	static {
		
		try {
			key = DESUtils.getKeyByHexStr(hexStrToBytes(PUB3_KEY));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static boolean isEncryptString(String str){
		if(str==null || str.trim().length()==0){
			return false;
		}
		str = str.trim();
		return str.startsWith(ENCRYPT_PASSWORD);
	}

	public static String md5(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
			}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}

	/**
	 * ���ܿ���
	 * 
	 * @param orgPassword
	 * @return
	 * @throws P3Exception
	 */
	public static String encryptPassword(String orgPassword) throws Exception {

		if (orgPassword==null || orgPassword.trim().length()==0) {
			return "";
		}
		if (isEncryptString(orgPassword)) {
			return orgPassword;
		}

		byte[] data = DESUtils.doEncrypt(key, orgPassword.getBytes());
		return ENCRYPT_PASSWORD + bytesToHexStr(data);

	}

	/**
	 * �ȽϿ����Ƿ����
	 * 
	 * @param inputPassword
	 * @param dbPassword
	 * @return
	 * @throws P3Exception
	 */
	public static boolean passwordEq(String inputPassword, String dbPassword)
			throws Exception {
		// ������һ��Ϊ�� ����Ϊ���ƥ��
		if ((inputPassword==null || inputPassword.trim().length()==0) || (dbPassword==null || dbPassword.trim().length()==0)) {
			return false;
		}

		String decryptPassword = decryptPassword(dbPassword);
		return decryptPassword.equals(inputPassword);
	}

	/**
	 * �Կ������
	 * 
	 * @param dbPassword
	 * @return
	 * @throws P3Exception
	 */
	public static String decryptPassword(String dbPassword) throws Exception {

		if (dbPassword==null || dbPassword.trim().length()==0) {
			return dbPassword;
		}
		// ����û�м���
		if (isEncryptString(dbPassword)) {
			String hexPass = dbPassword.substring(ENCRYPT_PASSWORD.length(),
					dbPassword.length());
			byte[] decryptBytes = DESUtils.doDecrypt(key,
					hexStrToBytes(hexPass));
			String decryptPass = new String(decryptBytes);
			return decryptPass;
		} else {
			return dbPassword;
		}

	}
	
	private static byte[] hexStrToBytes(String s) {
		byte[] result = new byte[s.length() / 2];
		for (int i = 0; i < s.length() / 2; i++) {
			result[i] = (byte) (charToByte(s.charAt(2 * i)) * 16 + charToByte(s
					.charAt(2 * i + 1)));
		}
		return result;
	}
	
	private static byte charToByte(char c) {
		if (c >= '0' && c <= '9') {
			return (byte) ((byte) c - (byte) '0');
		} else if (c >= 'a' && c <= 'f') {
			return (byte) (10 + (byte) c - (byte) 'a');
		} else {
			throw new java.lang.IllegalArgumentException("invalid arg:"
					+ String.valueOf(c));
		}
	}
	
	private static String bytesToHexStr(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			int temp = bytes[i] < 0 ? bytes[i] + 256 : bytes[i];
			result.append(hexStr.charAt((temp / 16) % 16));
			result.append(hexStr.charAt(temp % 16));
		}
		return result.toString();
	}
}
