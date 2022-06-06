package etf.openpgp.am180688ddm180630d.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ASCReader {
	
	public enum KeyType { 
		PUBLIC("-----BEGIN PGP PUBLIC KEY BLOCK-----"),
		PRIVATE("-----BEGIN PGP PRIVATE KEY BLOCK-----"),
		UNDEFINED("UNDEFINED");
		private String type;
		
		private KeyType(String t) {
			type=t;
		}
		
		public String getType() {
			return type;
		}
	}
	
	private static String block;
	private static String hash;
	private static KeyType type;
	
	public ASCReader()
	{
		this.block="";
		this.hash="";
		this.type=KeyType.UNDEFINED;
	}
	
	public static boolean readASCFile(String path) {
		try {
			File f = new File(path);
			Scanner s = new Scanner(f);
			String typestring = s.nextLine();
			if(typestring.equals(KeyType.PUBLIC.getType()))
			{
				type=KeyType.PUBLIC;
			}
			if(typestring.equals(KeyType.PRIVATE.getType()))
			{
				type=KeyType.PRIVATE;
			}
			while (s.hasNextLine()) {
				String line = s.nextLine().trim();
				if(line.equals("")) continue;
				else if(line.startsWith("-"))continue;
				else if(line.startsWith("="))hash=line.substring(1);
				else block+=line;
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		byte[] octets = Radix64Util.decode(block);
		byte[] h = Radix64Util.decode(hash);
		long a = CRCUtil.crc_octets(octets);
		long b = (h[0]&0xFF)<<16|(h[1]&0xFF)<<8|(h[2]&0xFF);
		return a==b;
	}

	public static String getBlock() {
		return block;
	}

	public static String getHash() {
		return hash;
	}

	public static KeyType getType() {
		return type;
	}
	

}
