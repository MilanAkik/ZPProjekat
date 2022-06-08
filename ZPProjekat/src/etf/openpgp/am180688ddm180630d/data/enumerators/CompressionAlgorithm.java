package etf.openpgp.am180688ddm180630d.data.enumerators;

public enum CompressionAlgorithm {
	UNCOMPRESSED(0),
	ZIP(1),
	ZLIB(2),
	BZIP2(3);
	
	private int value;
	
	CompressionAlgorithm(int value)
	{
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
