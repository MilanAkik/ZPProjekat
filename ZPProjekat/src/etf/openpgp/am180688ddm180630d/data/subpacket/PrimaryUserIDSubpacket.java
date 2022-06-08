package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PrimaryUserIDSubpacket extends SignatureSubpacket {

	protected boolean p;
	public PrimaryUserIDSubpacket(boolean p) {
		super(2, SignatureSubpacketType.PRIMARY_USER_ID);
		this.p=p;
	}

	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((p)?0x01:0x00);
		return arr;
	}

}
