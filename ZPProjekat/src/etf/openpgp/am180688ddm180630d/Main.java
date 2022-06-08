package etf.openpgp.am180688ddm180630d;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.LinkedList;
import java.util.List;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Base64Encoder;

import etf.openpgp.am180688ddm180630d.data.PublicKey;
import etf.openpgp.am180688ddm180630d.data.PublicKeyRing;
import etf.openpgp.am180688ddm180630d.data.enumerators.HashAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.PacketTag;
import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureType;
import etf.openpgp.am180688ddm180630d.data.packet.Packet;
import etf.openpgp.am180688ddm180630d.data.packet.PublicKeyPacket;
import etf.openpgp.am180688ddm180630d.data.packet.SignaturePacket;
import etf.openpgp.am180688ddm180630d.data.packet.UserIDPacket;
import etf.openpgp.am180688ddm180630d.data.subpacket.SignatureSubpacket;
import etf.openpgp.am180688ddm180630d.data.types.MPI;
import etf.openpgp.am180688ddm180630d.gui.MainMenu;
import etf.openpgp.am180688ddm180630d.util.ASCReader;
import etf.openpgp.am180688ddm180630d.util.CRCUtil;
import etf.openpgp.am180688ddm180630d.util.RSAUtil;
import etf.openpgp.am180688ddm180630d.util.Radix64Util;
import javax.swing.*;

public class Main {

	public static void main(String[] args) throws Exception
	{
		
//		JFrame f=new JFrame();
//        
//		JButton b=new JButton("click");  
//		b.setBounds(130,100,100, 40);
//		          
//		f.add(b);  
//		          
//		f.setSize(400,500);  
//		f.setLayout(null);  
//		f.setVisible(true);  
//		ASCReader asc = new ASCReader();
//		
//		if(asc.readASCFile("C:\\Users\\Milan\\Desktop\\Milan_0xB327AE61_public.asc"))
//		{
//			System.out.println(asc.getBlock());
//			System.out.println(asc.getHash());
//			System.out.println(asc.getType().getType());
//		}
//		else
//		{
//			System.out.println("INCORRECT KEY FILE");
//		}

		
//		System.out.println(a);
//		System.out.println(b);
//		RSAPublicKeyStructure struct = new RSAPublicKeyStructure(rkp.getModulus(), 
//				rkp.getExponent());
//
//		SubjectPublicKeyInfo info = 
//				new SubjectPublicKeyInfo(
//						new AlgorithmIdentifier(
//								new ASN1ObjectIdentifier(
//										"1.2.840.113549.1.1.1"
//										)
//								)
//						,struct);
//		byte[] bytes = info.getEncoded();
//
//		 FileOutputStream out = new FileOutputStream("test.der");
//
//		 out.write(bytes);
//		 out.flush();
//		 out.close();
//		 byte[] data = hexStringToByteArray(datastring);
//		 long checksum = 0xee97e4;
//		 System.out.println(crc_octets(data));
//		 System.out.println(checksum);
//		byte[] b = new byte[202];
//		b[0]=(byte) 0xCB;
//		b[1]=(byte) 0xC0;
//		b[2]=0x08;
//		System.out.println(CRCUtil.crc_octets(b));
//		Packet p = new Packet(true, PacketTag.LITERAL_DATA, false, 30);
//		p.toByteArray();
		PublicKeyRing.init();
		RSAUtil.generateKey(2048);
		MPI[] m= {RSAUtil.getN(),RSAUtil.getE()};
		MPI[] m2= {new MPI(new byte[]{0x01,(byte) 0x00,(byte) 0x01})};
		List<SignatureSubpacket> ssp = new LinkedList<SignatureSubpacket>();
		List<SignatureSubpacket> ssp2 = new LinkedList<SignatureSubpacket>();
		PublicKeyPacket pkp = new PublicKeyPacket(true,4,LocalDateTime.now(), 120, PublicKeyAlgorithm.RSA_S, m);
		byte[] k = pkp.toByteArray();
		UserIDPacket u = new UserIDPacket(true, "andjela <andjela@example.com>");
		byte[] p = u.toByteArray();
		SignaturePacket sp = new SignaturePacket(true, (byte)4, SignatureType.POSITIVE_USERID, PublicKeyAlgorithm.RSA_ES,
				HashAlgorithm.SHA1, (short)0, m2, LocalDateTime.now(), (long)0, (short)0, ssp, (short)0, ssp2);
		byte[] spb = sp.toByteArray();
		byte[] file = new byte[k.length+p.length+spb.length];
		for(int i=0; i<k.length; i++) file[i]=k[i];
		for(int i=0; i<p.length; i++) file[i+k.length]=p[i];
		for(int i=0; i<spb.length; i++) file[i+k.length+p.length]=spb[i];
		System.out.println(Radix64Util.encode(file));
		int crc = (int) CRCUtil.crc_octets(file);
		byte[] c = {(byte) ((crc>>16)&0xFF), (byte) ((crc>>8)&0xFF), (byte) (crc&0xFF)};
		System.out.println("="+Radix64Util.encode(c));
		PublicKey pk = new PublicKey(pkp, null, u, sp);
		PublicKeyRing.add(pk);
		for(String s: pk.getTableRow())
			System.out.println(s);
		MainMenu m1 = new MainMenu();
	}
	
	

}
