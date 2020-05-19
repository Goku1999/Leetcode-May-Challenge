/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/

class Trie 
{

    /** Initialize your data structure here. */
    class Node
    {
        Node tree[];
        boolean end;
        public Node()
        {
            tree=new Node[26];
            end=false;
        }
    }
    public Trie() 
    {
        root=new Node();
    }
    Node root;
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        int l=word.length();
        Node t=root;
        for(int x=0;x<l;x++)
        {
            int d=word.charAt(x)-97;
            if(t.tree[d]==null)
            {
                t.tree[d]=new Node();
            }
            t=t.tree[d];
        }
        t.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        int l=word.length();
        Node t=root;
        for(int x=0;x<l;x++)
        {
            int d=word.charAt(x)-97;
            if(t.tree[d]==null)
            {
                return false;
            }
            t=t.tree[d];
        }
        return (t!=null&&t.end);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) 
    {
        int l=word.length();
        Node t=root;
        for(int x=0;x<l;x++)
        {
            int d=word.charAt(x)-97;
            if(t.tree[d]==null)
            {
                return false;
            }
            t=t.tree[d];
        }
        return (t!=null);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
