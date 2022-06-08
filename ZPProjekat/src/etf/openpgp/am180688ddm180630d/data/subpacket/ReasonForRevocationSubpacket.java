package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class ReasonForRevocationSubpacket extends SignatureSubpacket {

	protected byte b;
	protected byte[] reason;
	public ReasonForRevocationSubpacket(byte b, byte[] reason) {
		super(2+reason.length, SignatureSubpacketType.REASONS_FOR_REVOCATION);
		this.b=b;
		this.reason=reason;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++] = b;
		for(byte a : reason)
		{
			arr[i++] = a;
		}
		return arr;
	}

}
