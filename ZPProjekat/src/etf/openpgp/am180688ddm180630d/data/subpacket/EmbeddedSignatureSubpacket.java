package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;
import etf.openpgp.am180688ddm180630d.data.packet.SignaturePacket;

public class EmbeddedSignatureSubpacket extends SignatureSubpacket {

	protected SignaturePacket sp;
	public EmbeddedSignatureSubpacket(SignaturePacket sp) {
		super(sp.getBodyLength(), SignatureSubpacketType.EMBEDDED_SIGNATURE);
		this.sp=sp;
	}
	
	//-------------------------------TODO---------------------------------------
	@Override
	public byte[] toByteArray() {
		return super.toByteArray();
	}

}
