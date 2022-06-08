package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class TrustSignatureSubpacket extends SignatureSubpacket {

	protected byte level;
	protected byte amount;
	public TrustSignatureSubpacket(byte level, byte amount) {
		super(3, SignatureSubpacketType.TRUST_SIGNATURE);
		this.level=level;
		this.amount=amount;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = level;
		arr[i++] = amount;
		return arr;
	}

}
