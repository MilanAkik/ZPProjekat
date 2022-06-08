package etf.openpgp.am180688ddm180630d.data.enumerators;

public enum HashAlgorithm {
	MD5(1),
	SHA1(2),
	RIPE_MD_160(3),
	SHA256(8),
	SHA384(9),
	SHA512(10),
	SHA224(11);
	
	private int value;
	
	HashAlgorithm(int value)
	{
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
