package Trees;
class TrieNode
{
    char data;
    TrieNode children[] = new TrieNode[128];
    int wordEnd;
    public TrieNode()
    {
        data ='\0';
        wordEnd = 0;
    }
    public TrieNode(char data)
    {
        this.data = data; 
    }
    public void insertString(TrieNode root, String s)
    {
        TrieNode v = root;
        for (char ch : s.toCharArray()) {
            TrieNode next = v.children[ch];
            if(next == null)
            {
                next = new TrieNode(ch);
                v.children[ch] = next;
            }
            v = next;
        }
        v.wordEnd++;
    }
    public boolean searchWord(TrieNode root, String word)
    {
        TrieNode v = root;
        for(char ch : word.toCharArray())
        {
            TrieNode next = v.children[ch];
            if(next==null)
                return false;
            v = next;
        }
        return v.wordEnd>0;
    }
}
public class Trie
{
    public static void main(String args[])
    {
        
    }
}