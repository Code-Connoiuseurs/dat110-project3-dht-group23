package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Hash {

	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest'
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// compute the hash of the input 'entity'
		byte[] entityByteArray = md.digest(entity.getBytes());
		// convert the hash into hex format
		String hex = HexFormat.of().formatHex(entityByteArray);
		// convert the hex into BigInteger
		hashint = new BigInteger(hex, 16);
		// return the BigInteger

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// compute the number of bits = bitSize()
		// compute the address size = 2 ^ number of bits
		// return the address size

		return BigInteger.valueOf(2).pow(bitSize());
	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
