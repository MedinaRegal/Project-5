package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import list.ListInterface;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class SongList implements ListInterface<Song> {
    private int size;
    private int numPeople;

    private SongNode head;
    private SongNode tail;

    /**
     * 
     */
    public SongList() {
        init();
    }

    /**
     * intialize two sentinal nodes for doubly linked list
     */
    private void init() {
        head = new SongList.SongNode(null);
        tail = new SongList.SongNode(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * 
     * @param p
     *            person we want to add
     */
    public void addPerson(Person p) {
        numPeople++;
    }
    
    /**
     * 
     * @param index
     *            index we're at
     * @return percent
     */
    public int[] getPercentLike(int index) {
        return get(index).getPercent(true);
    }

    /**
     * 
     * @param index
     *            index we're at
     * @return percent
     */
    public int[] getPercentHeard(int index) {
        return get(index).getPercent(false);
    }

    /**
     * 
     * @return the number of people
     */
    public int getNumPeople() {
        return numPeople;
    }

    /**
     * 
     * @param modifier
     *            region, hobby, or major
     */
    public void sort(String modifier) {
        boolean swapped = (head != null);

        while (swapped) {
            SongNode temp = head.next();
            swapped = false;
            while (temp != null && temp.getSong() != null
                    && temp.next().getSong() != null) {
                Song s = temp.getSong();
                if (modifier.equals("Artist")) {
                    if (s.getArtist()
                            .compareTo(temp.next()
                                    .getSong().getArtist()) > 0) {
                        SongNode tempNext = temp.next();
                        SongNode tempPrev = temp.previous();
                        tempNext.next().setPrevious(temp);
                        temp.setNext(tempNext.next());
                        temp.setPrevious(tempNext);
                        tempPrev.setNext(tempNext);
                        tempNext.setPrevious(tempPrev);
                        tempNext.setNext(temp);
                        swapped = true;
                    }
                    else {
                        temp = temp.next();
                    }
                }
                if (modifier.equals("Title")) {
                    if (s.getTitle()
                            .compareTo(temp.next()
                                    .getSong().getTitle()) > 0) {
                        SongNode tempNext = temp.next();
                        SongNode tempPrev = temp.previous();
                        tempNext.next().setPrevious(temp);
                        temp.setNext(tempNext.next());
                        temp.setPrevious(tempNext);
                        tempPrev.setNext(tempNext);
                        tempNext.setPrevious(tempPrev);
                        tempNext.setNext(temp);
                        swapped = true;
                    }
                    else {
                        temp = temp.next();
                    }
                }
                if (modifier.equals("Genre")) {
                    if (s.getGenre()
                            .compareTo(temp.next()
                                    .getSong().getGenre()) > 0) {
                        SongNode tempNext = temp.next();
                        SongNode tempPrev = temp.previous();
                        tempNext.next().setPrevious(temp);
                        temp.setNext(tempNext.next());
                        temp.setPrevious(tempNext);
                        tempPrev.setNext(tempNext);
                        tempNext.setPrevious(tempPrev);
                        tempNext.setNext(temp);
                        swapped = true;
                    }
                    else {
                        temp = temp.next();
                    }
                }
                if (modifier.equals("Release")) {
                    if (s.getDate().compareTo(temp
                            .next().getSong()
                            .getDate()) > 0) {
                        SongNode tempNext = temp.next();
                        SongNode tempPrev = temp.previous();
                        tempNext.next().setPrevious(temp);
                        temp.setNext(tempNext.next());
                        temp.setPrevious(tempNext);
                        tempPrev.setNext(tempNext);
                        tempNext.setPrevious(tempPrev);
                        tempNext.setNext(temp);
                        swapped = true;
                    }
                    else {
                        temp = temp.next();
                    }
                }
            }
        }
    }

    /**
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return length
     */
    public int getLength() {
        return size;
    }

    /**
     * call init method to reset the list
     */
    public void clear() {
        init();
    }

    /**
     * 
     * @param index
     *            index where the song is
     * @return song at index
     */
    public Song get(int index) {
        return getNodeAtIndex(index).getSong();
    }

    /**
     * @param newEntry
     *            song we're adding
     */
    public void add(Song newEntry) {
        add(getLength(), newEntry);
    }

    /**
     * @param index
     *            index where we're adding
     * @param obj
     *            song we want to add
     */
    public void add(int index, Song obj) {
        
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                    + "objects to a list");
        }

        SongNode nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        SongNode addition = new SongNode(obj, nodeAfter, nodeAfter.previous());
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;
    }

    /**
     * 
     * @return iterator
     */
    public Iterator<Song> iterator() {
        return new SongIterator();
    }

    /**
     * 
     * @param index
     *            index where node is
     * @return node at index
     */
    public SongNode getNodeAtIndex(int index) {
        
        if (index < 0 || getLength() <= index) {
            throw new IndexOutOfBoundsException("No element exists");
        }
        SongNode current = head.next();
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }

    /**
     * @param obj
     *            song we're looking for
     * @return true if it contains it, false if not
     */
    @Override
    public boolean contains(Song obj) {
        // will not use this method
        return false;
    }

    /**
     * @param index
     *            index where the song is
     * @return song at index
     */
    @Override
    public Song getEntry(int index) {
        return getNodeAtIndex(index).getSong();
    }

    /**
     * @param index
     *            to replace at
     * @param song
     *            new song we're replacing
     * @return index to replace at
     */
    @Override
    public Song replace(int index, Song song) {
        // will not use this method
        return null;
    }

    /**
     * @return array representation of the list
     */
    @Override
    public Object[] toArray() {
        // will not use this method
        return null;
    }

    /**
     * @param index
     *            we're removing at
     * @return song removed
     */
    @Override
    public Song remove(int index) {
        // will not use this method
        return null;
    }

    /**
     * @author Daniel Medina, dmedina
     *         Shuaicheng Zhang, zshuai8
     *         James Jee, jamesj95
     * @version 2016/4/10
     */
    class SongNode {
        private Song song;
        private SongNode next;
        private SongNode prev;

        /**
         * 
         * @param data
         *            song
         * @param nextNode
         *            next node
         * @param prevNode
         *            next node
         */
        public SongNode(Song data, SongNode nextNode, SongNode prevNode) {
            song = data;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * 
         * @param data
         *            song
         */
        public SongNode(Song data) {
            song = data;
            next = null;
            prev = null;
        }

        /**
         * 
         * @param n
         *            next node we're setting
         */
        public void setNext(SongNode n) {
            next = n;
        }

        /**
         * 
         * @param n
         *            previous node to set
         */
        public void setPrevious(SongNode n) {
            prev = n;
        }

        /**
         * 
         * @return the next node
         */
        public SongNode next() {
            return next;
        }

        /**
         * 
         * @return previous node
         */
        public SongNode previous() {
            return prev;
        }

        /**
         * 
         * @return song in the node
         */
        public Song getSong() {
            return song;
        }
    }

    /**
     * @author Daniel Medina, dmedina
     *         Shuaicheng Zhang, zshuai8
     *         James Jee, jamesj95
     * @version 2016/4/10
     */
    public class SongIterator implements Iterator<Song> {
        private SongNode curNode;

        /**
         * 
         */
        public SongIterator() {
            curNode = head;
        }

        /**
         * @return true if there's a next, false if not
         */
        @Override
        public boolean hasNext() {
            return curNode.next().getSong() != null;
        }

        /**
         * @return next
         */
        @Override
        public Song next() {
            
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            System.out.println(curNode.getSong());
            curNode = curNode.next();
            System.out.println(curNode.getSong());
            System.out.println("\n\n\n");
            return curNode.getSong();
        }
    }

}

