package blockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class MainBlockChain {
	
	public static ArrayList<Block> blockChain = new ArrayList<Block>();
	public static int difficulty = 5;

	public static void main(String[] args) {
		/*Block firstBlock = new Block("first transaction", "0");
		System.out.println("hash for block1 =  "+firstBlock.hash);
		System.out.println("previous hash for block 1 = "+firstBlock.previousHash);
		System.out.println();
		
		Block secondBlock = new Block("second big transaction", firstBlock.hash);
		System.out.println("hash for block1 =  "+secondBlock.hash);
		System.out.println("previous hash for block 1 = "+secondBlock.previousHash);
		System.out.println();
		
		Block thirdBlock = new Block("third small transaction", secondBlock.hash);
		System.out.println("hash for block1 =  "+thirdBlock.hash);
		System.out.println("previous hash for block 1 = "+thirdBlock.previousHash);
		System.out.println();*/
		
		/*blockChain.add(new Block("first transaction", "0"));
		blockChain.add(new Block("second big transaction", blockChain.get(blockChain.size()-1).hash));
		blockChain.add(new Block("third small transaction", blockChain.get(blockChain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);		
		System.out.println(blockchainJson);*/
		
		blockChain.add(new Block("first transaction", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockChain.get(0).mineBlock(difficulty);
		
		blockChain.add(new Block("second big transaction",blockChain.get(blockChain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockChain.get(1).mineBlock(difficulty);
		
		blockChain.add(new Block("third small transaction",blockChain.get(blockChain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockChain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		for(int i=1; i < blockChain.size(); i++) {
			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i-1);
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
		}
		return true;
	}
}
