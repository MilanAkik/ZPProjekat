package etf.openpgp.am180688ddm180630d.data.packet;

import java.time.LocalDateTime;
import java.util.List;

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
	
	public SignaturePacket(boolean isNew, int length, byte version, SignatureType type, PublicKeyAlgorithm pka,
			HashAlgorithm ha, short l16oshv, MPI[] m, LocalDateTime ldt, long keyID, short hashedLength,
			List<SignatureSubpacket> hashed, short unhashedLength, List<SignatureSubpacket> unhashed) {
		super(isNew, PacketTag.SIGNATURE, true, length);
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
	//
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
	
	@Override
	public byte[] toByteArray() {
		return super.toByteArray();
	}
}
