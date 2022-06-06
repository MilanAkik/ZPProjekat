package etf.openpgp.am180688ddm180630d.data.packet;

public class Packet {
	private byte tag;
	private int length;
	public Packet(boolean isNew, byte t, boolean determinateLength, int length)
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
	}
}
