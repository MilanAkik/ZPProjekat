package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class ExportableCertificationSubpacket extends SignatureSubpacket {

	protected boolean prot;
	public ExportableCertificationSubpacket(boolean prot) {
		super(2, SignatureSubpacketType.EXPORTABLE_CERTIFICATION);
		this.prot=prot;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = (byte) ((prot)?0x01:0x00);
		return arr;
	}

}
