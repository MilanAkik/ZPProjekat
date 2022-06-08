package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class KeyFlags extends SignatureSubpacket {

	protected byte[] flags;
	public KeyFlags(byte[] flags) {
		super(flags.length+1, SignatureSubpacketType.KEY_FLAGS);
		this.flags=flags;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte b: flags)
		{
			arr[i++] = b;
		}
		return arr;
	}

}
