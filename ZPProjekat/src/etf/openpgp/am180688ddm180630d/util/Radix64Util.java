package etf.openpgp.am180688ddm180630d.util;

import org.bouncycastle.util.encoders.Base64;

public class Radix64Util {
	public static byte[] decode(String s)
	{
		return Base64.decode(s);
	}
}
