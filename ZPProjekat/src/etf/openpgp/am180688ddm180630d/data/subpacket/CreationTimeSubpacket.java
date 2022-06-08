package etf.openpgp.am180688ddm180630d.data.subpacket;

import java.time.LocalDateTime;
import java.time.ZoneId;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class CreationTimeSubpacket extends SignatureSubpacket {

	protected LocalDateTime ldt;
	public CreationTimeSubpacket(int length, SignatureSubpacketType type, LocalDateTime ldt) {
		super(5, SignatureSubpacketType.SIGNATURE_CREATION_TIME);
		this.ldt=ldt;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		int uts = (int) ldt.atZone(ZoneId.systemDefault()).toEpochSecond();
		arr[i++] = (byte) ((uts >> 24)&0xFF);
		arr[i++] = (byte) ((uts >> 16)&0xFF);
		arr[i++] = (byte) ((uts >> 8)&0xFF);
		arr[i++] = (byte) (uts&0xFF);
		return arr;
	}
	
}
