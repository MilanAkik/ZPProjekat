package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.HashAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PreferredHashSubpacket extends SignatureSubpacket {

	protected HashAlgorithm[] ha;
	public PreferredHashSubpacket(HashAlgorithm[] ha) {
		super(ha.length+1, SignatureSubpacketType.PREFERRED_HASH_ALGORITHMS);
		this.ha=ha;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(HashAlgorithm h: ha)
		{
			arr[i++] = (byte) h.getValue();
		}
		return arr;
	}

}
