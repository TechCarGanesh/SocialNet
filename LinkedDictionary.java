/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialnet;
import java.util.Iterator;


/**
 *
 * @author Ganesh Kumar
 */
/*
The LinkedDictionary class implements add, remove, getValue, contains,
getKeyIterator, and getValueIterator.
*/
public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
    // Private data of LinkedDictionary class.
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public LinkedDictionary()
    {
        // Initialize the data fields.
        initializeDataFields();
    } // end default constructor

    // Initialize private data.
    public void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /** Adds a new entry to this dictionary. If the given search key already
       exists in the dictionary, replaces the corresponding value.
       @param key    An object search key of the new entry.
       @param value  An object associated with the search key.
       @return  Either null if the new entry was added to the dictionary
                or the value that was associated with key if that value
                was replaced. */
    @Override
    public V add(K key, V value) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        V result = null;
        
        // Search chain for a node containing key.
        Node currentNode = firstNode;
        while( (currentNode != null) && !key.equals(currentNode.getKey()) ) {
            currentNode = currentNode.getNextNode();
        }
        
        if(currentNode == null) {
            // Key not in dictionary; add new node at the beginning of chain.
            Node newNode = new Node(key, value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            numberOfEntries++;
        }
        else {
            // Key in dictionary; replace corresponding value.
            result = currentNode.getValue();
            currentNode.setValue(value);
        }
        
        return result;
    }

    /** Removes a specific entry from this dictionary.
       @param key  An object search key of the entry to be removed.
       @return  Either the value that was associated with the search key
                or null if no such object exists. */
    @Override
    public V remove(K key) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        V result = null;
        Node previousNode = null;
        
        // Search chain for a node containing key.
        Node currentNode = firstNode;
        // If first node, remove the first node and move the first node pointer.
        if(firstNode.getKey() == key) {
            result = firstNode.getValue();
            firstNode = firstNode.next;
            numberOfEntries--;
            return result;
        }
        // If it is in the middle, search and remove.
        while( (currentNode != null) ) {
            if(currentNode.getKey() == key) {
                result = currentNode.getValue();
                previousNode.setNextNode(currentNode.getNextNode());
                numberOfEntries--;
                return result;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    /** Retrieves from this dictionary the value associated with a given
       search key.
       @param key  An object search key of the entry to be retrieved.
       @return  Either the value that is associated with the search key
                or null if no such object exists. */
    @Override
    public V getValue(K key) {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        V result = null;
        
        // Search chain for a node containing key.
        Node currentNode = firstNode;
        while( (currentNode != null) && !key.equals(currentNode.getKey()) ) {
            currentNode = currentNode.getNextNode();
        }
        if(currentNode != null) {
            // Key in dictionary; replace corresponding value.
            if(key.equals(currentNode.getKey())) {
                result = currentNode.getValue();
                return result;
            }
        }
        return null;
    }

    /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
    @Override
    public boolean contains(K key) {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        V result = null;
        
        // Search chain for a node containing key.
        Node currentNode = firstNode;
        while( (currentNode != null) ) {
            if(key.equals(currentNode.getKey())) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    /** Creates an iterator that traverses all search keys in this dictionary.
       @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
    @Override
    public Iterator<K> getKeyIterator() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        KeyIterator iter = new KeyIterator();
        return iter;
    }

    /** Creates an iterator that traverses all values in this dictionary.
       @return  An iterator that provides sequential access to the values
                in this dictionary. */
    @Override
    public Iterator<V> getValueIterator() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ValueIterator iter = new ValueIterator();
        return iter;
    }

    /** Sees whether this dictionary is empty.
       @return  True if the dictionary is empty. */
    @Override
    public boolean isEmpty() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(firstNode == null && numberOfEntries == 0) {
            return true;
        }
        return false;
    }

    /** Gets the size of this dictionary.
       @return  The number of entries (key-value pairs) currently
                in the dictionary. */
    @Override
    public int getSize() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return numberOfEntries;
    }

    /** Removes all entries from this dictionary. */
    @Override
    public void clear() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        numberOfEntries = 0;
        firstNode = null;
    }



// Same as in SortedLinkedDictionary.
// Since iterators implement Iterator, methods must be public.
private class KeyIterator implements Iterator<K>
{
    private Node nextNode;
    private KeyIterator()
    {
        nextNode = firstNode;
    } // end default constructor

    public boolean hasNext()
    {
        return nextNode != null;
    } // end hasNext

    public K next()
    {
        K result;
        if (hasNext())
        {
            result = nextNode.getKey();
            nextNode = nextNode.getNextNode();
        }
        else
        {
            throw new NoSuchElementException();
        } // end if
        return result;
    } // end next

    public void remove()
    {
        throw new UnsupportedOperationException();
    } // end remove
} // end KeyIterator

private class ValueIterator implements Iterator<V>
{
    private Node nextNode;
    private ValueIterator()
    {
        nextNode = firstNode;
    } // end default constructor

    public boolean hasNext()
    {
        return nextNode != null;
    } // end hasNext

    public V next()
    {
        V result;
        if (hasNext())
        {
            result = nextNode.getValue();
            nextNode = nextNode.getNextNode();
        }
        else
        {
            throw new NoSuchElementException();
        } // end if

        return result;
    } // end next

    public void remove()
    {
        throw new java.lang.UnsupportedOperationException();
    } // end remove
} // end getValueIterator

private class Node
{
    private K key;
    private V value;
    private Node next;
    private Node(K searchKey, V dataValue)
    {
        key = searchKey;
        value = dataValue;
        next = null;
    } // end constructor

    private Node(K searchKey, V dataValue, Node nextNode)
    {
        key = searchKey;
        value = dataValue;
        next = nextNode;
    } // end constructor

    private K getKey()
    {
        return key;
    } // end getKey

    private V getValue()
    {
        return value;
    } // end getValue

    private void setValue(V newValue)
    {
        value = newValue;
    } // end setValue

    private Node getNextNode()
    {
        return next;
    } // end getNextNode

    private void setNextNode(Node nextNode)
    {
        next = nextNode;
    } // end setNextNode
} // end Node

} // end LinkedDictionary


