package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PreferredSymetricSubpacket extends SignatureSubpacket {

	protected PublicKeyAlgorithm[] preferred;
	public PreferredSymetricSubpacket(PublicKeyAlgorithm[] preferred) {
		super(preferred.length+1, SignatureSubpacketType.PREFERRED_SYMMETRIC_ALGORITHMS);
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(PublicKeyAlgorithm pka: preferred)
		{
			arr[i++] = (byte) pka.getValue();
		}
		return arr;
	}
	
}
