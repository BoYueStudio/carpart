package com.xiupeilian.carpart.util;



import java.security.MessageDigest;

/* 
 '============================================================================ 
 'api˵���� 
 'createSHA1Sign����ǩ��SHA1 
 'getSha1()Sha1ǩ�� 
 '============================================================================ 
 '*/
public class SHA1Util {
	private static final char[] HEX_DIGITS
 = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	/**
	 * Takes the raw bytes from the digest and formats them correct.
	 * 
	 * @param bytes
	 *            the raw bytes from the digest.
	 * @return the formatted bytes.
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		// ������ת����ʮ�����Ƶ��ַ�����ʽ
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}
    /**
	  加密
	**/
	public static String encode(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(str.getBytes());
			str=getFormattedText(messageDigest.digest());
		    str=str.substring(8, 24);

			return str ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		// System.out.println(SHA1Util.encode("123456"));
		System.out.println(SHA1Util.encode("123123"));
		
	}
}