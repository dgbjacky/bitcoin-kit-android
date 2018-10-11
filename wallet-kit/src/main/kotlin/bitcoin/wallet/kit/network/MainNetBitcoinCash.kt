package bitcoin.wallet.kit.network

import bitcoin.wallet.kit.blocks.validators.BitcoinCashValidator
import bitcoin.wallet.kit.models.Block
import bitcoin.wallet.kit.models.Header
import bitcoin.walllet.kit.utils.HashUtils

class MainNetBitcoinCash : NetworkParameters() {

    override var port: Int = 8333

    override var magic: Long = 0xe3e1f3e8L
    override var bip32HeaderPub: Int = 0x0488b21e
    override var bip32HeaderPriv: Int = 0x0488ade4
    override var addressVersion: Int = 0
    override var addressSegwitHrp: String = "bitcoincash"
    override var addressScriptVersion: Int = 5
    override var coinType: Int = 0

    override var dnsSeeds: Array<String> = arrayOf(
            "seed.bitcoinabc.org"
    )

    private val blockHeader = Header().apply {
        version = 536870912
        prevHash = HashUtils.toBytesAsLE("000000000000000000640772774c4c5c923397129370c8edf05c3792de1dcb4e")
        merkleHash = HashUtils.toBytesAsLE("254af3f28c30beac4fffaf6d64d2dabeb5bd5644462c53ec9504eda180b59cfa")
        timestamp = 1535105951
        bits = 0x180216f4
        nonce = 2665729828
    }

    override val checkpointBlock = Block(blockHeader, 544799)
    override val blockValidator = BitcoinCashValidator(this)

    override fun validateBlock(block: Block, previousBlock: Block) {
        blockValidator.validate(block, previousBlock)
    }
}
