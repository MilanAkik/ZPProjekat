package etf.openpgp.am180688ddm180630d.data;

import java.security.MessageDigest;
import java.security.Security;
import java.time.LocalDateTime;

import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.jcajce.provider.digest.SHA1;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import etf.openpgp.am180688ddm180630d.data.packet.PublicKeyPacket;
import etf.openpgp.am180688ddm180630d.data.packet.SignaturePacket;
import etf.openpgp.am180688ddm180630d.data.packet.UserIDPacket;
import etf.openpgp.am180688ddm180630d.data.types.MPI;

public class PublicKey {
//	private enum TrustFlag{YES,MAYBE,NO};
//	private LocalDateTime timestamp;
//	private char keyID[];
//	private char publicKey[];
//	private TrustFlag ownerTrust;
//	private String userID;
//	private TrustFlag keyLegitimacy;
//	private char signature[];
//	private TrustFlag signatureTrusts[];
	private PublicKeyPacket pk;
	private SignaturePacket[] rs;
	private UserIDPacket uid;
	private SignaturePacket uidc;
	
	public PublicKey(PublicKeyPacket pk, SignaturePacket[] rs, UserIDPacket uid, SignaturePacket uidc) {
		super();
		this.pk = pk;
		this.rs = rs;
		this.uid = uid;
		this.uidc = uidc;
	}
	
	public PublicKey(int width)
	{
		this.pk = null;
		this.rs = null;
		this.uid = null;
		this.uidc = null;
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public String[] getTableRow()
	{
		String[] res = new String[8];
		res[0]=pk.getLdt().toString();
		if(pk.getVersion()==3)
		{
			byte[] mod = pk.getData()[0].toByteArray();
			byte[] kid= new byte[8];
			for(int i=0; i<8; i++)
			{
				kid[i]=mod[mod.length-8+i];
			}
			res[1]=bytesToHex(kid);
		}
		else if (pk.getVersion()==4)
		{
			int length = pk.getLength();
			int hl = pk.getHeaderLength();
			byte[] kid = new byte[3+length];
			kid[0]=(byte) 0x99;
			kid[1]=(byte) ((length&0xFF00)>>8);
			kid[2]=(byte) (length&0xFF);
			byte[] pkdata = pk.toByteArray();
			for(int i=0; i<length; i++)
			{
				kid[3+i] = pkdata[hl+i];
			}
			res[1]=bytesToHex(new SHA1.Digest().digest(kid));
		}
		MPI mod = pk.getData()[0];
		MPI exp = pk.getData()[1];
		byte[] ma = mod.toByteArray();
		byte[] ea = exp.toByteArray();
		byte[] mar = new byte[ma.length-2];
		byte[] ear = new byte[ea.length-2];
		for(int i=0; i<mar.length; i++) mar[i]=ma[i+2];
		for(int i=0; i<ear.length; i++) ear[i]=ea[i+2];
		
		res[2]="("+bytesToHex(ear)+","+bytesToHex(mar)+")";
		res[3]="";
		res[4]=uid.getUserid();
		res[5]="";
		res[6]="";
		res[7]="";
		return res;
		
	}
	
}
