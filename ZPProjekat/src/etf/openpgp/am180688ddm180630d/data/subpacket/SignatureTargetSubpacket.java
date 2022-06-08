package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.HashAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class SignatureTargetSubpacket extends SignatureSubpacket {

	protected PublicKeyAlgorithm pka;
	protected HashAlgorithm ha;
	protected byte[] hash;
	public SignatureTargetSubpacket(PublicKeyAlgorithm pka, HashAlgorithm ha, byte[] hash) {
		super(hash.length+3, SignatureSubpacketType.SIGNATURE_TARGET);
		this.pka=pka;
		this.ha=ha;
		this.hash=hash;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) pka.getValue();
		arr[i++] = (byte) ha.getValue();
		for(byte b: hash)
		{
			arr[i++] = b;
		}
		return arr;
	}

}
