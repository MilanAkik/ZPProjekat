package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class KeyExpirationTimeSubpacket extends SignatureSubpacket {

	protected int expirationTime;
	public KeyExpirationTimeSubpacket(int length, SignatureSubpacketType type) {
		super(5, SignatureSubpacketType.KEY_EXPIRATION_TIME);
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((expirationTime >> 24)&0xFF);
		arr[i++] = (byte) ((expirationTime >> 16)&0xFF);
		arr[i++] = (byte) ((expirationTime >> 8)&0xFF);
		arr[i++] = (byte) (expirationTime&0xFF);
		return arr;
	}

}
