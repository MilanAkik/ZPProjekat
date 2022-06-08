package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class NotationDataSubpacket extends SignatureSubpacket {

	protected int flags;
	protected short m;
	protected short n;
	protected byte[] name;
	protected byte[] value;
	
	public NotationDataSubpacket(int flags, short m, short n, byte[] name, byte[] value) {
		super(9+m+n, SignatureSubpacketType.NOTATION_DATA);
		this.flags=flags;
		this.m=m;
		this.n=n;
		this.name=name;
		this.value=value;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((flags >> 24)&0xFF);
		arr[i++] = (byte) ((flags >> 16)&0xFF);
		arr[i++] = (byte) ((flags >> 8)&0xFF);
		arr[i++] = (byte) (flags&0xFF);
		
		arr[i++] = (byte) ((m >> 8)&0xFF);
		arr[i++] = (byte) (m&0xFF);
		
		arr[i++] = (byte) ((n >> 8)&0xFF);
		arr[i++] = (byte) (n&0xFF);
		
		for(byte b: name)
		{
			arr[i++] = b;
		}
		for(byte b: value)
		{
			arr[i++] = b;
		}
		return arr;
	}

}
