package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class FeaturesSubpacket extends SignatureSubpacket {

	protected byte[] flags;
	public FeaturesSubpacket(byte[] flags) {
		super(flags.length+1, SignatureSubpacketType.FEATURES);
		this.flags=flags;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte a : flags)
		{
			arr[i++] = a;
		}
		return arr;
	}
}
