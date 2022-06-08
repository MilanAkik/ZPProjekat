package etf.openpgp.am180688ddm180630d.data.subpacket;

import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureSubpacketType;

public class SignersUserIDSubpacket extends SignatureSubpacket {

	String uid;
	public SignersUserIDSubpacket(String uid) {
		super(uid.length()+1, SignatureSubpacketType.SIGNERS_USER_ID);
		this.uid = uid;
	}
	
	@Override
	public byte[] toByteArray()
	{
		byte[] arr = super.toByteArray();
		int i=headerLength;
		for(byte b: uid.getBytes())
		{
			arr[i++] = b;
		}
		return arr;
	}

}
