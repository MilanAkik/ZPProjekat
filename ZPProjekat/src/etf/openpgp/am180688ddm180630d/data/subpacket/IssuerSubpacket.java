package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class IssuerSubpacket extends SignatureSubpacket{

	protected long keyID;
	
	public IssuerSubpacket(long keyID) {
		super(9, SignatureSubpacketType.ISSUER);
		this.keyID=keyID;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((keyID >> 56)&0xFF);
		arr[i++] = (byte) ((keyID >> 48)&0xFF);
		arr[i++] = (byte) ((keyID >> 40)&0xFF);
		arr[i++] = (byte) ((keyID >> 32)&0xFF);
		arr[i++] = (byte) ((keyID >> 24)&0xFF);
		arr[i++] = (byte) ((keyID >> 16)&0xFF);
		arr[i++] = (byte) ((keyID >> 8)&0xFF);
		arr[i++] = (byte) (keyID&0xFF);
		return arr;
	}
	
}
