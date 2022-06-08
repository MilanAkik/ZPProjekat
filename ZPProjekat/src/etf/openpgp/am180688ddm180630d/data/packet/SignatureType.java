package etf.openpgp.am180688ddm180630d.data.packet;

public enum SignatureType {
	BINARY(0),
	CANONICAL_TEXT(1),
	STANDALONE(2),
	GENERIC_USERID(0x10),
	PERSONA_USERID(0x11),
	CASUAL_USERID(0x12),
	POSITIVE_USERID(0x13),
	SUBKEY_BINDING(0x18),
	PRIMARY_KEY_BINDING(0x19),
	DIRECTLY_ON_KEY(0x1F),
	KEY_REVOCATION(0x20),
	SUBKEY_REVOCATION(0x28),
	CERTIFICATION_REVOCATION(0x30),
	TIMESTAMP(0x40),
	THIRD_PARTY_CONFIRMATION(0x50);
	
	private int value;
	
	private SignatureType(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
	
}
