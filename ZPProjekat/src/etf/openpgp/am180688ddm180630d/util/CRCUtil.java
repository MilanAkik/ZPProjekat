package etf.openpgp.am180688ddm180630d.util;

import org.bouncycastle.util.encoders.Base64;

public class CRCUtil {
	private static final long init=0xB704CE;
	private static final long poly=0x1864CFB;
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static long crc_octets(byte[] octets)
	{
		long crc = init;
		int len = octets.length;
		int i, cnt=0;
		while((len--)>0)
		{
			crc ^= (octets[cnt++]<<16);
			for(i=0; i<8; i++)
			{
				crc<<=1;
				if((crc&0x1000000)>0)
				{
					crc ^= poly;
				}
			}
		}
		return (crc & 0xFFFFFF);
	}
}
