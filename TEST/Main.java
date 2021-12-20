import java.io.*;
import java.util.*;

@SuppressWarnings("all")

public class Main 
{
    static class TrieNode
    {
        int data;
        TrieNode children[] = new TrieNode[2];
        int prefix;
        public TrieNode()
        {
            data =-1;
            prefix = 0;
        }
        public TrieNode(int data)
        {
            this.data = data; 
            this.prefix = 0;
        }
        public void insertNum(TrieNode root, int n)
        {
            TrieNode curr = root;
            for(int i = 30-1; i>=0; i--)
            {
                prefix++;
                int nextBit = (n&(1<<i))!=0?1:0;
                TrieNode next = curr.children[nextBit];
                if(next == null)
                {
                    next = new TrieNode(nextBit);
                    curr.children[nextBit] = next;
                }
                curr = next;
            }
            curr.data = n;
        }
        public int query_max_xor(TrieNode root, int n)
        {
            TrieNode curr = root;
            int ans = 0;
            for(int i = 30-1; i>=0; i--)
            {
                int nextBit = (n&(1<<i))!=0?1:0;
                TrieNode next = curr.children[1^nextBit];
                if(next!=null)
                    curr = next;
                else
                    curr = curr.children[nextBit];
            }
            return curr.data;
        }
    }

    public static void main(String[] args)
    {
        TrieNode root = new TrieNode();
        int arr[] = {2,3,4};
        int n = 12;
        for(int i : arr) root.insertNum(root, i);
        System.out.println(n^root.query_max_xor(root, n));
        
    }
}