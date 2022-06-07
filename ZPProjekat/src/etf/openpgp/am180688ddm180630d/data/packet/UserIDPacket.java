package etf.openpgp.am180688ddm180630d.data.packet;

public class UserIDPacket extends Packet{

	String userid;
	public UserIDPacket(boolean isNew, String userid) {
		super(isNew, PacketTag.USER_ID, true, userid.length());
		this.userid=userid;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		for(int i=0; i<length; i++)
		{
			arr[headerLength+i] = (byte) userid.charAt(i);
		}
		return arr;
	}

}
