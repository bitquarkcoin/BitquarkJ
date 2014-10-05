package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import fr.cryptohash.BLAKE512;
import fr.cryptohash.BMW512;
import fr.cryptohash.Groestl512;
import fr.cryptohash.Skein512;
import fr.cryptohash.Keccak512;
import fr.cryptohash.JH512;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.resources.agent_ko;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {
    private static final Logger log = LoggerFactory.getLogger(CoinDefinition.class);

    public static final String coinName = "BitQuark";
    public static final String coinTicker = "BTQ";
    public static final String coinURIScheme = "bitquark";
    public static final String coinURIScheme2 = "bitquark";
    public static final String coinInternalName = "bitquark";
    public static final String cryptsyMarketId = "71";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[U7]";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    //public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://quarkexplorer.com/";
    //public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://quarkexplorer.com/";
    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.bitquark.info/";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://explorer.bitquark.info/";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";

    public static final String BLOCKEXPLORER_PATH_URL_TEST = "block/";


    public static final String DONATION_ADDRESS = "QVJZByN6HdrTuEjAbgXpAnEUxUeeUaoEcA";  //HashEngineering donation QRK address

    enum CoinHash {
        SHA256,
        scrypt,
        quark
    };
    public static final CoinHash coinHash = CoinHash.quark;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 1;
    //Original Values
    public static final int TARGET_TIMESPAN = (int)(10 * 60);  // 10 minutes per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 30);  // 30 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //20 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL*100;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }
    public static int spendableCoinbaseDepth = 120; //main.h: static const int COINBASE_MATURITY
    public static BigInteger COIN = BigInteger.valueOf(100000);
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(500000000).multiply(COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY


    public static BigInteger CENT = BigInteger.valueOf(1000);
    public static BigInteger mCOIN = BigInteger.valueOf(100);

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(10);   // MIN_TX_FEE
    public static final BigInteger DEFAULT_MIN_RELAY_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = CoinDefinition.CENT; //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70001;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 9596;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 9597;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 0;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 9;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS

    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xfea503da;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1388710861L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (14055670);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000b9cf0b9bb2437283f28d378e5f9644c643f25e1c80b2cd9fdd6510d33f1"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 1;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer

    static public String genesisTxInBytes = "04ffff001d0104414a616e2033746820323031342e204e534120646576656c6f70696e6720636f64652d637261636b696e67207175616e74756d20636f6d70757465722e2046636b21";   //"21 July 2013, The Guardian, Tesco boss says cheap food era is over"
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "196.210.132.241",
            "192.3.141.188",
			"62.210.125.140",
			"37.59.21.58",
			"46.165.208.136",
			"173.204.118.123",
			"173.216.113.207",
            "213.180.26.45",
			"176.57.143.181",
			"91.222.220.251",
			"151.231.157.105",
    };
    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - quarkcoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 119;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 199;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x011a39f7;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1373481000L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (905523645);                         //main.cpp: LoadBlockIndex


    static final long _COIN = 100000;
    static final BigInteger nGenesisBlockRewardCoin = COIN;
    static final BigInteger nBlockRewardStartCoin = BigInteger.valueOf(2048 * _COIN);
    static final BigInteger nBlockRewardMinimumCoin = COIN;

    //main.cpp GetBlockValue(height, fee)
    static final BigInteger GetBlockValue(int nHeight)
    {
        if (nHeight == 0)
        {
            return nGenesisBlockRewardCoin;
        }

        BigInteger nSubsidy = BigInteger.valueOf(2048L * 100000L);

        // Subsidy is cut in half every 60480 blocks (21 days)
        //nSubsidy >>= (nHeight / 60480);
        nSubsidy = nSubsidy.shiftRight(nHeight / 60480);

        // Minimum subsidy
        if (nSubsidy.compareTo(nBlockRewardMinimumCoin) < 0)
        {
            nSubsidy = nBlockRewardMinimumCoin;
        }

        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 60480;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284";
    public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.quark.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.quark.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.quark.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0,     new Sha256Hash("00000b9cf0b9bb2437283f28d378e5f9644c643f25e1c80b2cd9fdd6510d33f1"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";



}
