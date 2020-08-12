package io.horizontalsystems.digibytekit

import io.horizontalsystems.bitcoincore.network.Network

class MainNetDigiByte : Network() {
    override val protocolVersion: Int = 70017
    override var port: Int = 12024

    override var magic: Long = 0xdab6c3fa
    override var bip32HeaderPub: Int = 0x049d7cb2   // The 4 byte header that serializes in base58 to "xpub".
    override var bip32HeaderPriv: Int = 0x049d7878  // The 4 byte header that serializes in base58 to "xprv"
    override var addressVersion: Int = 0x1e
    override var addressSegwitHrp: String = "dgb"
    override var addressScriptVersion: Int = 0x3f
    override var coinType: Int = 0

    override val maxBlockSize = 2_000_000
    override val dustRelayTxFee = 3000 // https://github.com/digibyte/digibyte/blob/master/src/policy/policy.h#L51

    override val syncableFromApi = true

    override var dnsSeeds = listOf(
            "185.221.172.127",
            "seed1.digibyte.io",
            "seed2.digibyte.io",
            "seed3.digibyte.io",
            "seed.digibyteprojects.com",
            "digiexplorer.info",
            "digihash.co"
    )
}
