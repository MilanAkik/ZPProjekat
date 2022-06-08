package etf.openpgp.am180688ddm180630d.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

import etf.openpgp.am180688ddm180630d.data.types.MPI;

public class RSAUtil {

	protected static BigInteger e;
	protected static BigInteger n;
	
	public static void generateKey(int width)
	{
		SecureRandom sr = new SecureRandom();
		e = BigInteger.valueOf(65537);
		RSAKeyGenerationParameters rkgp = new RSAKeyGenerationParameters(e, sr, width, PrimeCertaintyCalculator.getDefaultCertainty(width));
		RSAKeyPairGenerator rkpg = new RSAKeyPairGenerator();
		rkpg.init(rkgp);
		AsymmetricCipherKeyPair ackp = rkpg.generateKeyPair();
		RSAKeyParameters rkp = (RSAKeyParameters) ackp.getPublic();
		n = rkp.getModulus();
	}
	
	public static MPI getE()
	{
		byte[] expba = e.toByteArray();
		int cnt = 0;
		for(byte b: expba)
		{
			if(b!=0)break;
			cnt++;
		}
		byte[] exppba = new byte[expba.length-cnt];
		for(int i=0; i<exppba.length; i++)
		{
			exppba[i]=expba[cnt+i];
		}
		return new MPI(exppba);
	}
	
	public static MPI getN()
	{
		byte[] modba = n.toByteArray();
		int cnt = 0;
		for(byte b: modba)
		{
			if(b!=0)break;
			cnt++;
		}
		byte[] modpba = new byte[modba.length-cnt];
		for(int i=0; i<modpba.length; i++)
		{
			modpba[i]=modba[cnt+i];
		}
		return  new MPI(modpba);
	}

}
