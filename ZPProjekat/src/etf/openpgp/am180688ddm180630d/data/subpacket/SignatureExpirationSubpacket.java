package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class SignatureExpirationSubpacket extends SignatureSubpacket {

	protected int ex;
	public SignatureExpirationSubpacket(int ex) {
		super(5, SignatureSubpacketType.SIGNATURE_EXPIRATION_TIME);
		this.ex=ex;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((ex >> 24)&0xFF);
		arr[i++] = (byte) ((ex >> 16)&0xFF);
		arr[i++] = (byte) ((ex >> 8)&0xFF);
		arr[i++] = (byte) (ex&0xFF);
		return arr;
	}

}
