package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.CompressionAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class PreferredCompressionSubpacket extends SignatureSubpacket {

	protected CompressionAlgorithm[] ca; 
	public PreferredCompressionSubpacket(CompressionAlgorithm[] ca) {
		super(ca.length+1, SignatureSubpacketType.PREFERRED_COMPRESSION_ALGORITHMS);
		this.ca=ca;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(CompressionAlgorithm c: ca)
		{
			arr[i++] = (byte) c.getValue();
		}
		return arr;
	}

}
