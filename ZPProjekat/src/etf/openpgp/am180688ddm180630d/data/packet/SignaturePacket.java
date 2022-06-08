package etf.openpgp.am180688ddm180630d.data.packet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import etf.openpgp.am180688ddm180630d.data.enumerators.HashAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.PacketTag;
import etf.openpgp.am180688ddm180630d.data.enumerators.PublicKeyAlgorithm;
import etf.openpgp.am180688ddm180630d.data.enumerators.SignatureType;
import etf.openpgp.am180688ddm180630d.data.subpacket.SignatureSubpacket;
import etf.openpgp.am180688ddm180630d.data.types.MPI;

public class SignaturePacket extends Packet {

	private byte version;
	private SignatureType type;
	private PublicKeyAlgorithm pka;
	private HashAlgorithm ha;
	private short l16oshv;
	private MPI[] m;
	private LocalDateTime ldt;
	private long keyID;
	private short hashedLength;
	private List<SignatureSubpacket> hashed;
	private short unhashedLength;
	private List<SignatureSubpacket> unhashed;
	
	public SignaturePacket(boolean isNew, byte version, SignatureType type, PublicKeyAlgorithm pka,
			HashAlgorithm ha, short l16oshv, MPI[] m, LocalDateTime ldt, long keyID, short hashedLength,
			List<SignatureSubpacket> hashed, short unhashedLength, List<SignatureSubpacket> unhashed) {
		super(isNew, PacketTag.SIGNATURE, true, 0);
		this.version = version;
		this.type = type;
		this.pka = pka;
		this.ha = ha;
		this.l16oshv = l16oshv;
		this.m = m;
		this.ldt = ldt;
		this.keyID = keyID;
		this.hashedLength = hashedLength;
		this.hashed = hashed;
		this.unhashedLength = unhashedLength;
		this.unhashed = unhashed;
		if(version==3)
		{
			length = 19;
			for(MPI mpi: m)
			{
				length+=mpi.toByteArray().length;
			}
		}
		else if(version==4)
		{
			length = 10;
			for(MPI mpi: m)
			{
				length+=mpi.toByteArray().length;
			}
			for(SignatureSubpacket sp: hashed)
			{
				length+=sp.getLength();
			}
			for(SignatureSubpacket sp: unhashed)
			{
				length+=sp.getLength();
			}
		}
	}
	
	//-------------------------------TODO--------------------------------------
	public int getBodyLength()
	{
		return 1;
	}

	//POTREBNO
	//
	//1 VERSION
	//1 SIGNATURE TYPE
	//1 PUBLIC KEY ALGORITHM
	//1 HASH ALGORITHM
	//2 LEFT 16 BITS OF SIGNED HASH VALUE
	//1+ MPI
	//
	//4 CREATION TIME
	//8 KEY ID
	//
	//2 HASHED SUBPACKETS LENGTH
	//0+ HASHED SUBPACKETS
	//2 UNHASHED SUBPACKETS LENGTH
	//0+ UNHASHES SUBPACKETS
	//
	//
	//V3
	//
	//1 VERSION	
	//1 LITERAL 5 LENGTH OF THE NEXT 2 ELEMENTS
	//1 SIGNATURE TYPE
	//4 CREATION TIME
	//8 KEY ID
	//1 PUBLIC KEY ALGORITHM
	//1 HASH ALGORITHM
	//2 LEFT 16 BITS OF SIGNED HASH VALUE
	//1+ MPI
	//
	//
	//
	//V4
	//
	//1 VERSION
	//1 SIGNATURE TYPE
	//1 PUBLIC KEY ALGORITHM
	//1 HASH ALGORITHM
	//2 HASHED SUBPACKETS LENGTH
	//0+ HASHED SUBPACKETS
	//2 UNHASHED SUBPACKETS LENGTH
	//0+ UNHASHES SUBPACKETS
	//2 LEFT 16 BITS OF SIGNED HASH VALUE
	//1+ MPI
	//
	//
	
	@Override
	public byte[] toByteArray() {
		byte[] arr = super.toByteArray();
		int i=headerLength;
		if(version == 4)
		{
			int uts = (int) ldt.atZone(ZoneId.systemDefault()).toEpochSecond();
			arr[i++] = version;
			arr[i++] = (byte) type.getValue();
			arr[i++] = (byte) pka.getValue();
			arr[i++] = (byte) ha.getValue();
			arr[i++] = (byte) ((hashedLength >> 8)&0xFF);
			arr[i++] = (byte) (hashedLength&0xFF);
			for(SignatureSubpacket s: hashed)
			{
				byte[] h = s.toByteArray();
				for(byte b : h)
				{
					arr[i++]=b;
				}
			}
			arr[i++] = (byte) ((unhashedLength >> 8)&0xFF);
			arr[i++] = (byte) (unhashedLength&0xFF);
			for(SignatureSubpacket s: unhashed)
			{
				byte[] h = s.toByteArray();
				for(byte b : h)
				{
					arr[i++]=b;
				}
			}
			arr[i++] = (byte) ((l16oshv >> 8)&0xFF);
			arr[i++] = (byte) (l16oshv&0xFF);
			for(MPI mpi: m)
			{
				for(byte b: mpi.toByteArray())
				{
					arr[i++]=b;
				}
			}
		}
		else if(version == 3)
		{
			int uts = (int) ldt.atZone(ZoneId.systemDefault()).toEpochSecond();
			arr[i++] = version;
			arr[i++] = 0x05;
			arr[i++] = (byte) type.getValue();
			arr[i++] = (byte) ((uts >> 24)&0xFF);
			arr[i++] = (byte) ((uts >> 16)&0xFF);
			arr[i++] = (byte) ((uts >> 8)&0xFF);
			arr[i++] = (byte) (uts&0xFF);
			arr[i++] = (byte) ((keyID >> 56)&0xFF);
			arr[i++] = (byte) ((keyID >> 48)&0xFF);
			arr[i++] = (byte) ((keyID >> 40)&0xFF);
			arr[i++] = (byte) ((keyID >> 32)&0xFF);
			arr[i++] = (byte) ((keyID >> 24)&0xFF);
			arr[i++] = (byte) ((keyID >> 16)&0xFF);
			arr[i++] = (byte) ((keyID >> 8)&0xFF);
			arr[i++] = (byte) (keyID&0xFF);
			arr[i++] = (byte) pka.getValue();
			arr[i++] = (byte) ha.getValue();
			arr[i++] = (byte) ((l16oshv >> 8)&0xFF);
			arr[i++] = (byte) (l16oshv&0xFF);
			for(MPI mpi: m)
			{
				for(byte b: mpi.toByteArray())
				{
					arr[i++]=b;
				}
			}
		}
		return arr;
	}
}
