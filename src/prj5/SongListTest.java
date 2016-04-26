package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import student.TestCase;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */

public class SongListTest extends TestCase {
    
    private SongList list;
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;
    private Iterator<Song> iter;
    
    /**
     * setup a list with 4 songs inside
     * setuo a iterator to iterate through the song list
     */
    public void setUp() {
        list = new SongList();
        song = new Song("All These Things I've Done", "The Killers",
                "2005", "alternative");
        song2 = new Song("a", "b", "2000", "y");
        song3 = new Song("d", "s", "2008", "c");
        song4 = new Song("c", "a", "2006", "h");
        
        iter = list.iterator();
    }
    
    /**
     * test sort method
     * sort title, genre, artist,release
     */
    public void testSort() {
        list.sort("Title");
        
        list.add(song3);
        list.add(song2);
        list.add(song4);
        list.sort("Title");
        assertEquals(list.get(0), song2);
        
        list.sort("Genre");
        assertEquals(list.get(0), song3);
        
        list.sort("Artist");
        assertEquals(list.get(0), song4);
        
        list.sort("Release");
        assertEquals(list.get(0), song2);
    }
    
    /**
     * test getNumPeople method
     */
    public void testGetNumPeople() {
        Person person4 = new Person("a", "b", "c");
        list.addPerson(person4);
        assertEquals(list.getNumPeople(), 1);
    }

    /**
     * test if isempty return true when the list is empty
     * also chec if it return false when the list is not empty
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(song);
        assertFalse(list.isEmpty());
    }

    /**
     * test empty list length and nonempty list length
     */
    public void testGetLength() {
        assertEquals(list.getLength(), 0);
        list.add(song);
        assertEquals(list.getLength(), 1);
    }

    /**
     * test if clear method makes a list empty
     */
    public void testClear() {
        list.clear();
        assertEquals(list.getLength(), 0);
    }

    /**
     * test getter method by getting song from list
     */
    public void testGet() {
        list.add(song);
        assertEquals(list.get(0), song);
    }

    /**
     * test add method by adding a song into an empty list
     */
    public void testAdd() {
        assertTrue(list.isEmpty());
        list.add(song);
        assertFalse(list.isEmpty());
    }

    /**
     * test addIndexExc method dealing with exceptions
     * check if it throws exception when index is out of bounds
     * or when obj is null
     */
    public void testAddIndexExc() {
        Exception exception = null;
        try
        {
            list.add(-1, song);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        Exception exception2 = null;
        try
        {
            list.add(3, song);
        }
        catch (Exception e)
        {
            exception2 = e;
        }
        assertTrue(exception2 instanceof IndexOutOfBoundsException);
        
        Exception exception3 = null;
        Song obj = null;
        try
        {
            list.add(0, obj);
        }
        catch (Exception e)
        {
            exception3 = e;
        }
        assertTrue("Cannot add null objects to a list",
            exception3 instanceof IllegalArgumentException);
    }

    /**
     * test non-special cases of add method
     */
    public void testAddIndex() {
        list.add(song);
        list.add(1, song2);
        assertEquals(list.getLength(), 2);
        list.add(0, song);
        assertEquals(list.getLength(), 3);
    }

    /**
     * test iterator's methods
     * check if it throws exception when there isn't a next
     */
    public void testHasNext() {
        list.add(song);
        list.add(song2);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), song);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), song2);
        assertFalse(iter.hasNext());
        
        Exception exception2 = null;
        try
        {
            iter.next();
        }
        catch (Exception e)
        {
            exception2 = e;
        }
        assertTrue(exception2 
                instanceof NoSuchElementException);
    }

    /**
     * test getNodeAt method dealing with exceptions
     * index out of bounds
     */
    public void testGetNodeAtExc() {
        Exception exception = null;
        try
        {
            list.getNodeAtIndex(-1);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("No element exists",
            exception instanceof IndexOutOfBoundsException);
        
        Exception exception2 = null;
        try
        {
            list.getNodeAtIndex(2);
        }
        catch (Exception e)
        {
            exception2 = e;
        }
        assertTrue("No element exists", 
                exception2 instanceof IndexOutOfBoundsException);
    }
    
    /**
     *test getNodeAt method in normal cases
     */
    public void testGetNodeAt() {
        list.add(song);
        list.add(song2);
        list.add(song3);
        assertEquals(list.getNodeAtIndex(0).getSong(), song);
        assertEquals(list.getNodeAtIndex(1).getSong(), song2);
        assertEquals(list.getNodeAtIndex(2).getSong(), song3);
    }

    /**
     * test if getEntry method returns an entry
     */
    public void testGetEntry() {
        list.add(song);
        list.add(song2);
        list.add(song3);
        assertEquals(list.getEntry(0), song);
        assertEquals(list.getEntry(1), song2);
        assertEquals(list.getEntry(2), song3);
    }
    
    /**
     * test unused method to check their performance
     */
    public void testUnusedMethods() {
        assertFalse(list.contains(song));
        assertNull(list.replace(1, song));
        assertNull(list.remove(1));
        assertNull(list.toArray());
    }
    
    /**
     * test percent heard method
     * check if its return integer range is from 0-100
     */
    public void testGetPercentLike() {
        list.add(song);
        assertEquals(list.getPercentLike(0)[0], 0);
    }
    
    /**
     * test percent heard method
     * check if its return integer range is from 0-100
     */
    public void testGetPercentHeard() {
        list.add(song);
        assertEquals(list.getPercentHeard(0)[0], 0);
    }
}

