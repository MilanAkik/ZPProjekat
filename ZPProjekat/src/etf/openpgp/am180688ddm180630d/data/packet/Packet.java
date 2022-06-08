package etf.openpgp.am180688ddm180630d.data.packet;

import etf.openpgp.am180688ddm180630d.data.enumerators.PacketTag;

public class Packet {
	protected boolean isNew;
	protected PacketTag tag;
	protected boolean determinateLength;
	protected int length;
	protected int headerLength;
	
	/*public Packet(boolean isNew, byte tag, boolean determinateLength, int length)
	{
		if(isNew)
		{
			tag = (byte) 0xC0;
			tag |= (t & 0x3F);
			if(determinateLength)
			{
				if(length<256)tag |= 0x00;
				else if(length<65536)tag |= 0x01;
				else tag |= 0x02;
			}
			else
			{
				tag |= 0x03;
			}
		}
		else
		{
			tag = (byte) 0x80;
			tag |= ((t & 0x0F)<<2);
		}
	}*/

	public Packet(boolean isNew, PacketTag tag, boolean determinateLength, int length)
	{
		super();
		if(!determinateLength && !isNew && length>30)
		{
			System.out.println("Length of the indeterminate is less then 30");
			System.exit(-1);
		}
		this.isNew = isNew;
		this.tag = tag;
		this.determinateLength = determinateLength;
		this.length = length;
	}
	
	public byte[] toByteArray()
	{
		byte[] arr;
		byte t=(byte) 0x80;
		if(isNew)
		{
			t |= 0x40;
			t |= tag.getValue()&0x3F;
			if(!determinateLength)
			{
				arr = new byte[2+(1<<length)];
				arr[1]=(byte) (length&0xFF);
				headerLength = 2;
			}
			else if(length<192)
			{
				arr = new byte[2+length];
				arr[1]=(byte) (length&0xFF);
				headerLength = 2;
			}
			else if(length<8384)
			{
				arr = new byte[3+length];
				int len = length-192;
				arr[1] = (byte) ((len>>8)+192);
				arr[2] = (byte) (len&0xFF);
				headerLength = 3;
			}
			else
			{
				arr = new byte[6+length];
				arr[1]=(byte) 255;
				arr[2]=(byte) (length>>24);
				arr[3]=(byte) ((length>>16)&0xFF);
				arr[4]=(byte) ((length>>8)&0xFF);
				arr[5]=(byte) (length&0xFF);
				headerLength = 6;
			}
		}
		else
		{
			t |= ((tag.getValue()&0x3F)<<2);
			if(!determinateLength)
			{
				arr = new byte[1];
				t |= 0x03;
				System.out.println("Indeterminate length old format packets are not supported");
				System.exit(-1);
			}
			else if(length<256)
			{
				arr = new byte[2+length];
				arr[1] = (byte) (length&0xFF);
				headerLength = 2;
			}
			else if(length<65536)
			{
				arr = new byte[3+length];
				arr[1] = (byte) (length>>8);
				arr[2] = (byte) (length&0xFF);
				t |= 0x01;
				headerLength = 3;
			}
			else
			{
				arr = new byte[5+length];
				arr[1]=(byte) (length>>24);
				arr[2]=(byte) ((length>>16)&0xFF);
				arr[3]=(byte) ((length>>8)&0xFF);
				arr[4]=(byte) (length&0xFF);
				t |= 0x02;
				headerLength = 5;
			}
		}
		arr[0]=t;
//		System.out.println(arr.length);
//		System.out.println(bytesToHex(arr));
		return arr;
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
}
