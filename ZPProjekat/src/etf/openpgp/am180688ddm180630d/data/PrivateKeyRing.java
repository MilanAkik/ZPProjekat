package etf.openpgp.am180688ddm180630d.data;

import java.util.LinkedList;
import java.util.List;

public class PrivateKeyRing {
	public static List<PrivateKey> ring;
	
	public static void init()
	{
		ring = new LinkedList<>();
	}
	
	public static void add(PrivateKey pk)
	{
		ring.add(pk);
	}
	
}
