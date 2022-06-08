package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class RegexSubpacket extends SignatureSubpacket {

	protected String r;
	public RegexSubpacket(String r) {
		super(r.length()+2, SignatureSubpacketType.REGULAR_EXPRESSION);
		this.r = r;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte b : r.getBytes())
		{
			arr[i++] = b;
		}
		arr[i++]=0;
		return arr;
	}

}
