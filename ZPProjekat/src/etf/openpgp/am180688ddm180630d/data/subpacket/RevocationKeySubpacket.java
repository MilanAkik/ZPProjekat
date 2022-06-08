package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class RevocationKeySubpacket extends SignatureSubpacket {

	protected byte cl;
	protected PublicKeyAlgorithm pka;
	protected byte[] fp;
	public RevocationKeySubpacket(byte cl, PublicKeyAlgorithm pka, byte[] fp) {
		super(23, SignatureSubpacketType.REVOCATION_KEY);
		this.cl=cl;
		this.pka=pka;
		this.fp=fp;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = cl;
		arr[i++] = (byte) pka.getValue();
		for(byte b: fp)
		{
			arr[i++]=b;
		}
		return arr;
	}

}
