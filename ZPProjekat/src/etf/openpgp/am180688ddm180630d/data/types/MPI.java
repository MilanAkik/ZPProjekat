package etf.openpgp.am180688ddm180630d.data.types;

public class MPI {
	private byte[] bytes;
	public MPI(byte[] b) {
		bytes = new byte[b.length+2];
		short len = (short) ((b.length-1)*8);
		//-------------------------------------
		if((b[0]&0x80)!=0)len+=8;
		else if((b[0]&0x40)!=0)len+=7;
		else if((b[0]&0x20)!=0)len+=6;
		else if((b[0]&0x10)!=0)len+=5;
		else if((b[0]&0x08)!=0)len+=4;
		else if((b[0]&0x04)!=0)len+=3;
		else if((b[0]&0x02)!=0)len+=2;
		else if((b[0]&0x01)!=0)len+=1;
		bytes[0]=(byte) ((len>>8)&0xFF);
		bytes[1]=(byte) (len&0xFF);
		for(int i=0; i<b.length; i++)
		{
			bytes[i+2]=b[i];
		}
	}
}
