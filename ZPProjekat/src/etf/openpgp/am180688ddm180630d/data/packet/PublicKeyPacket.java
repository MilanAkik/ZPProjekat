package etf.openpgp.am180688ddm180630d.data.packet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import etf.openpgp.am180688ddm180630d.data.enumerators.PacketTag;
import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.types.MPI;

public class PublicKeyPacket extends Packet {

	protected int version;
	protected LocalDateTime ldt;
	int duration;
	PublicKeyAlgorithm pka;
	MPI[] data;
	
	public PublicKeyPacket(boolean isNew, int version, LocalDateTime ldt, int duration, PublicKeyAlgorithm pka, MPI[] data ) {
		super(isNew, PacketTag.PUBLIC_KEY, true, (version==3)?8:6);
		this.version=version;
		this.ldt=ldt;
		this.duration=duration;
		this.pka=pka;
		this.data=data;
		for(MPI m: data) this.length+= m.toByteArray().length;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		arr[i++]=(byte) (version&0xFF);
		int uts = (int) ldt.atZone(ZoneId.systemDefault()).toEpochSecond();
		arr[i++] = (byte) ((uts >> 24)&0xFF);
		arr[i++] = (byte) ((uts >> 16)&0xFF);
		arr[i++] = (byte) ((uts >> 8)&0xFF);
		arr[i++] = (byte) (uts&0xFF);
		if(version==3)
		{
			arr[i++] = (byte) ((duration >> 8)&0xFF);
			arr[i++] = (byte) (duration&0xFF);
		}
		arr[i++] = (byte) pka.getValue();
		for(MPI m: data)
		{
			for(byte b: m.toByteArray())
			{
				arr[i++]=b;
			}
		}
		return arr;
	}

}
