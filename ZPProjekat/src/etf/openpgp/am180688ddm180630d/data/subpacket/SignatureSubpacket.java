package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class SignatureSubpacket {
	protected int length;
	protected SignatureSubpacketType type;
	protected int headerLength;
	public SignatureSubpacket(int length, SignatureSubpacketType type)
	{
		this.length=length;
		this.type=type;
	}

	public byte[] toByteArray() {
		byte[] arr;
		if(length<192)
		{
			arr=new byte[1+length];
			arr[0]=(byte) (length&0xFF);
			arr[1]=(byte) type.getValue();
			headerLength = 2;
		}
		else if(length<8384)
		{
			arr=new byte[2+length];
			int len = length-192;
			arr[0] = (byte) ((len>>8)+192);
			arr[1] = (byte) (len&0xFF);
			arr[2]=(byte) type.getValue();
			headerLength = 3;
		}
		else
		{
			arr=new byte[5+length];
			arr[0]=(byte) 255;
			arr[1]=(byte) (length>>24);
			arr[2]=(byte) ((length>>16)&0xFF);
			arr[3]=(byte) ((length>>8)&0xFF);
			arr[4]=(byte) (length&0xFF);
			arr[5]=(byte) type.getValue();
			headerLength = 6;
		}
		return arr;
	}
	
}
