package etf.openpgp.am180688ddm180630d.data;

import java.util.LinkedList;
import java.util.List;

public class PublicKeyRing {
	public static List<PublicKey> ring;
	
	public static void init()
	{
		ring = new LinkedList<>();
	}
	
	public static void add(PublicKey pk)
	{
		ring.add(pk);
	}
	
}
