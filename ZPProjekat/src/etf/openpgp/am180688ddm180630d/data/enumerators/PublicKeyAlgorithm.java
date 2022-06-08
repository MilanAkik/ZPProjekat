package etf.openpgp.am180688ddm180630d.data.enumerators;

public enum PublicKeyAlgorithm {
	RSA_ES(1),
	RSA_E(2),
	RSA_S(3),
	ELGAMAL(16),
	DSA(17);
	
	private int value;
	
	PublicKeyAlgorithm(int value)
	{
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
