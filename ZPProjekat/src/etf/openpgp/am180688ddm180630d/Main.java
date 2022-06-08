package etf.openpgp.am180688ddm180630d;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;

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

import etf.openpgp.am180688ddm180630d.data.packet.Packet;
import etf.openpgp.am180688ddm180630d.data.packet.PacketTag;
import etf.openpgp.am180688ddm180630d.data.packet.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.packet.PublicKeyPacket;
import etf.openpgp.am180688ddm180630d.data.packet.UserIDPacket;
import etf.openpgp.am180688ddm180630d.data.types.MPI;
import etf.openpgp.am180688ddm180630d.gui.MainMenu;
import etf.openpgp.am180688ddm180630d.util.ASCReader;
import etf.openpgp.am180688ddm180630d.util.CRCUtil;
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
//		SecureRandom sr = new SecureRandom();
//		BigInteger e = BigInteger.valueOf(65537);
//		RSAKeyGenerationParameters rkgp = new RSAKeyGenerationParameters(e, sr, 1024, PrimeCertaintyCalculator.getDefaultCertainty(1024));
//		RSAKeyPairGenerator rkpg = new RSAKeyPairGenerator();
//		rkpg.init(rkgp);
//		AsymmetricCipherKeyPair ackp = rkpg.generateKeyPair();
//		RSAKeyParameters rkp = (RSAKeyParameters) ackp.getPublic();
//		System.out.println(rkp.getExponent());
//		System.out.println(rkp.getModulus());
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
//		MPI[] m= new MPI[2];
//		MPI n = new MPI(new byte[]{0x11,(byte) 0xDD,(byte) 0xFF});
//		MPI e = new MPI(new byte[]{0x01,(byte) 0x00,(byte) 0x01});
//		m[0]=n;
//		m[1]=e;
//		PublicKeyPacket pkp = new PublicKeyPacket(true,4,LocalDateTime.now(), 120, PublicKeyAlgorithm.RSA_S, m);
//		byte[] k = pkp.toByteArray();
//		UserIDPacket u = new UserIDPacket(true, "milan <milan@example.com>");
//		byte[] p = u.toByteArray();
//		byte[] file = new byte[k.length+p.length];
//		for(int i=0; i<k.length; i++) file[i]=k[i];
//		for(int i=0; i<p.length; i++) file[i+k.length]=p[i];
//		System.out.println(Radix64Util.encode(file));
//		int crc = (int) CRCUtil.crc_octets(file);
//		byte[] c = {(byte) ((crc>>16)&0xFF), (byte) ((crc>>8)&0xFF), (byte) (crc&0xFF)};
//		System.out.println("="+Radix64Util.encode(c));
		MainMenu m = new MainMenu();
	}
	
	

}
