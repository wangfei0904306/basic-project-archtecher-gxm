
package com.app.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/*
 * MD5 算法
 */
public class MD5Util {

	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	protected static MessageDigest messagedigest = null;

	public static String getRandomNum(Integer length) {
		final int MaxNum = 55;
		int i;
		int count = 0;
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer sbuf = new StringBuffer("");
		Random random = new Random();
		while (count < length) {
			i = Math.abs(random.nextInt(MaxNum));
			if (i >= 0 && i < str.length) {
				sbuf.append(str[i]);
				count++;
			}
		}
		return sbuf.toString();
	}

	/**
	 * MessageDigest初始化
	 * 
	 * @author 高焕杰
	 */
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("MD5FileUtil messagedigest初始化失败");
			e.printStackTrace();
		}
	}

	/**
	 * 对文件进行MD5加密
	 * 
	 * @author 高焕杰
	 */
	public static String getFileMD5String(File file) throws IOException {
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			FileChannel ch = in.getChannel();
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			messagedigest.update(byteBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @author 高焕杰
	 */
	public static String getMD5String(String s) {
		return getMD5String(s.getBytes());
	}

	/**
	 * 对byte类型的数组进行MD5加密
	 * 
	 * @author 高焕杰
	 */
	public static String getMD5String(byte[] bytes) {
		messagedigest.update(bytes);
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
			char c1 = hexDigits[bytes[l] & 0xf];
			stringbuffer.append(c0);
			stringbuffer.append(c1);
		}
		return stringbuffer.toString();
	}

	public static String passWordMd5(String str) {
		String newStr = "DJ_20160520" + str;
		return getMD5String(newStr).toUpperCase().toUpperCase();
	}

	public static void main(String[] args) {
		//System.out.println(passWordMd5(getMD5String("guda123").toUpperCase()));
		String data = "MERCHANTID=02330107050260415&ORDERSEQ=dev001&ORDERREQTRANSEQ=dev001&ORDERREQTIME=20170123093600&KEY=514F3BE1C74509EEA752E73ADED9AD16E15F7B34450DB7F2";
		System.out.println("MD5:" + MD5Util.getMD5String(data).toUpperCase());
		System.out.println("MAC:" + bufferToHex(data.getBytes()));
	}
}
