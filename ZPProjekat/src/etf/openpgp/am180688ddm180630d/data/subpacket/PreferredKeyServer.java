package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PreferredKeyServer extends SignatureSubpacket {

	String s;
	public PreferredKeyServer(String s) {
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
