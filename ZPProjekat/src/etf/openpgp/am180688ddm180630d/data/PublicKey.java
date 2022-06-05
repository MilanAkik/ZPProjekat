package etf.openpgp.am180688ddm180630d.data;

import java.time.LocalDateTime;

public class PublicKey {
	private enum TrustFlag{YES,MAYBE,NO};
	private LocalDateTime timestamp;
	private char keyID[];
	private char publicKey[];
	private TrustFlag ownerTrust;
	private String userID;
	private TrustFlag keyLegitimacy;
	private char signature[];
	private TrustFlag signatureTrusts[];
}
