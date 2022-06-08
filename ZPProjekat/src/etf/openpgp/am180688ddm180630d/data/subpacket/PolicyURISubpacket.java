package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PolicyURISubpacket extends SignatureSubpacket {

	String s;
	public PolicyURISubpacket(String s) {
		super(s.length()+1, SignatureSubpacketType.PREFERRED_KEY_SERVER);
		this.s=s;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte b: s.getBytes())
		{
			arr[i++] = b;
		}
		return arr;
	}
}
