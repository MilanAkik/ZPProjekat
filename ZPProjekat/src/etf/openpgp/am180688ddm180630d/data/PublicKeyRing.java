package etf.openpgp.am180688ddm180630d.data;

import java.util.LinkedList;
import java.util.List;

public class PublicKeyRing {
	public static List<PublicKey> ring;
	public static List<String> pwords;
	
	public static void init()
	{
		ring = new LinkedList<>();
		pwords= new LinkedList<>();
	}
	
	public static void add(PublicKey pk, String pw)
	{
		ring.add(pk);
		pwords.add(pw);
	}
	
	public static void remove(String uid, String pword)
	{
		int i=0; 
		for(; i<ring.size(); i++)
        {
        	if(ring.get(i).getUserID().equals(uid))
        	{
        		break;
        	}
        }
		if(pwords.get(i).equals(pword))
		{
			ring.remove(i);
			pwords.remove(i);
		}
	}
	
}
