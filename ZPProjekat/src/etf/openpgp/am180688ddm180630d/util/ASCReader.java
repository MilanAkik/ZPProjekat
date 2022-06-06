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
	
	private String block;
	private byte[] blockBytes;
	private String hash;
	private byte[] hashBytes;
	private KeyType type;
	
	public ASCReader()
	{
		this.block="";
		this.hash="";
		this.type=KeyType.UNDEFINED;
	}
	
	public boolean readASCFile(String path) {
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
		blockBytes = Radix64Util.decode(block);
		hashBytes = Radix64Util.decode(hash);
		long a = CRCUtil.crc_octets(blockBytes);
		long b = (hashBytes[0]&0xFF)<<16|(hashBytes[1]&0xFF)<<8|(hashBytes[2]&0xFF);
		return a==b;
	}

	public byte[] getBlockBytes() {
		return blockBytes;
	}

	public byte[] getHashBytes() {
		return hashBytes;
	}

	public String getBlock() {
		return block;
	}

	public String getHash() {
		return hash;
	}

	public KeyType getType() {
		return type;
	}
	

}
