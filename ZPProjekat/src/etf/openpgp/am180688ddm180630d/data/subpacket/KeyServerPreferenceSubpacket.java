package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class KeyServerPreferenceSubpacket extends SignatureSubpacket {

	protected byte[] bytes;
	public KeyServerPreferenceSubpacket(byte[] bytes) {
		super(bytes.length+1, SignatureSubpacketType.KEY_SERVER_PREFERENCES);
		this.bytes=bytes;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte b: bytes)
		{
			arr[i++] = b;
		}
		return arr;
	}

}
