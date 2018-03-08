class Trie{
	private static final int ALPHABET_SIZE=26;
	private static TrieNode root = new TrieNode();
	static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isLastWord;
		
		public TrieNode(){
			for(int i=0;i<ALPHABET_SIZE;i++){
				children[i] = null;
			}
			isLastWord =false;
		}
	}
	
	public static void insert(TrieNode root, String word){
		TrieNode current = root;
		for(int i=0;i<word.length();i++){
			int indexOfChar = word.charAt(i) - 'a';
			System.out.println(indexOfChar);
			if(current.children[indexOfChar] == null){
				TrieNode newNode = new TrieNode();
				current.children[indexOfChar] = newNode;
			}
			current = current.children[indexOfChar];
		}
		current.isLastWord = true;
	}
	
	public static boolean search(String word) {
		TrieNode current = root;
		for(int i=0;i<word.length();i++){
			int indexOfChar = word.charAt(i) - 'a';
			if(current.children[indexOfChar] == null){
				return false;
			}
			current = current.children[indexOfChar];
		}
		if(current.isLastWord)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String word = "word";
		insert(root, word);
		insert(root, "hello");
		insert(root, "welcome");
		insert(root, "welnot");
		System.out.println(search("welcome"));
	}
}