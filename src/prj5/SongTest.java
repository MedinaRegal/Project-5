package prj5;


import student.TestCase;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */

public class SongTest extends TestCase {

    private Song song;
    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;

    /**
     * set up a new song and 5 people(so that we can 
     * store their like or heard)into the song
     */
    public void setUp() {
        song = new Song("All These Things I've Done", "The Killers",
                "alternative", "2005");
        person = new Person("Computer Science", "Southeast", "music");

        person1 = new Person("Other Engineering", "Northeast", "reading");
        person2 = new Person("Math or CMDA",
                "United States (other than Southeast or Northwest)", "sports");
        person3 = new Person("Other", "Outside", "art");
        person4 = new Person("a", "b", "c");
    }

    /**
     * check if getter methods return stored strings of a song
     */
    public void testGetters() {
        assertEquals(song.getTitle(), "All These Things I've Done");
        assertEquals(song.getArtist(), "The Killers");
        assertEquals(song.getDate(), "alternative");
        assertEquals(song.getGenre(), "2005");
    }

    /**
     * check addLike method
     */
    public void testAddLike() {

        song.addLike(person4, false);

        song.addLike(person, true);
        assertEquals(song.getLike().get(0), person);

        song.addLike(person1, true);
        assertEquals(song.getLike().get(1), person1);

        song.addLike(person2, true);
        assertEquals(song.getLike().get(2), person2);

        song.addLike(person3, true);
        assertEquals(song.getLike().get(3), person3);
    }

    /**
     * check addHeard method
     */
    public void testAddHeard() {
        
        song.addHeard(person4, false);

        song.addHeard(person, true);
        assertEquals(song.getHeard().get(0), person);

        song.addHeard(person1, true);
        assertEquals(song.getHeard().get(1), person1);

        song.addHeard(person2, true);
        assertEquals(song.getHeard().get(2), person2);

        song.addHeard(person3, true);
        assertEquals(song.getHeard().get(3), person3);

    }

    /**
     * check getNumHeard method
     */
    public void testGetNumHeard() {
        song.addHeard(person, true);
        song.addHeard(person1, true);
        song.addHeard(person2, true);
        song.addHeard(person3, true);
        song.addHeard(person4, true);

        assertEquals(song.getNumHeard()[0], 1);
        assertEquals(song.getNumHeard()[1], 1);
        assertEquals(song.getNumHeard()[2], 1);
        assertEquals(song.getNumHeard()[3], 1);

        assertEquals(song.getNumHeard()[4], 1);
        assertEquals(song.getNumHeard()[5], 1);
        assertEquals(song.getNumHeard()[6], 1);
        assertEquals(song.getNumHeard()[7], 1);

        assertEquals(song.getNumHeard()[8], 1);
        assertEquals(song.getNumHeard()[9], 1);
        assertEquals(song.getNumHeard()[10], 1);
        assertEquals(song.getNumHeard()[11], 1);
    }

    /**
     * check getNumLike method
     */
    public void testGetNumLike() {
        song.addLike(person, true);
        song.addLike(person1, true);
        song.addLike(person2, true);
        song.addLike(person3, true);
        song.addLike(person4, true);

        assertEquals(song.getNumLike()[0], 1);
        assertEquals(song.getNumLike()[1], 1);
        assertEquals(song.getNumLike()[2], 1);
        assertEquals(song.getNumLike()[3], 1);

        assertEquals(song.getNumLike()[0], 1);
        assertEquals(song.getNumLike()[1], 1);
        assertEquals(song.getNumLike()[2], 1);
        assertEquals(song.getNumLike()[3], 1);

        assertEquals(song.getNumLike()[0], 1);
        assertEquals(song.getNumLike()[1], 1);
        assertEquals(song.getNumLike()[2], 1);
        assertEquals(song.getNumLike()[3], 1);
    }
    
    /**
     * check get percent like method
     */
    public void testGetPercentLike() {
        
        assertEquals(song.getPercent(true)[9], 0);
        assertEquals(song.getPercent(true)[5], 0);
        assertEquals(song.getPercent(true)[0], 0);
        song.addLike(person1, true);
        assertEquals(song.getPercent(true)[0], 100);
        assertEquals(song.getPercent(true)[5], 100);
        assertEquals(song.getPercent(true)[9], 100);
        
        song.addLike(person1, false);
        assertEquals(song.getPercent(true)[0], 50);
        assertEquals(song.getPercent(true)[5], 50);
        assertEquals(song.getPercent(true)[9], 50);

        assertEquals(song.getPercent(true)[11], 0);
        assertEquals(song.getPercent(true)[7], 0);
        assertEquals(song.getPercent(true)[1], 0);
        song.addLike(person3, true);
        assertEquals(song.getPercent(true)[1], 100);
        assertEquals(song.getPercent(true)[7], 100);
        assertEquals(song.getPercent(true)[11], 100);
        
        assertEquals(song.getPercent(true)[2], 0);
        assertEquals(song.getPercent(true)[6], 0);
        assertEquals(song.getPercent(true)[10], 0);
        song.addLike(person2, true);
        assertEquals(song.getPercent(true)[2], 100);
        assertEquals(song.getPercent(true)[6], 100);
        assertEquals(song.getPercent(true)[10], 100);
        
        assertEquals(song.getPercent(true)[8], 0);
        assertEquals(song.getPercent(true)[3], 0);
        assertEquals(song.getPercent(true)[4], 0);
        song.addLike(person, true);
        assertEquals(song.getPercent(true)[4], 100);
        assertEquals(song.getPercent(true)[3], 100);
        assertEquals(song.getPercent(true)[8], 100);
    }

    /**
     * check GetPercentHeard method
     */
    public void testGetPercentHeard() {
        
        assertEquals(song.getPercent(false)[9], 0);
        assertEquals(song.getPercent(false)[5], 0);
        assertEquals(song.getPercent(false)[0], 0);
        song.addHeard(person1, true);
        assertEquals(song.getPercent(false)[0], 100);
        assertEquals(song.getPercent(false)[5], 100);
        assertEquals(song.getPercent(false)[9], 100);

        assertEquals(song.getPercent(false)[11], 0);
        assertEquals(song.getPercent(false)[7], 0);
        assertEquals(song.getPercent(false)[1], 0);
        song.addHeard(person3, true);
        assertEquals(song.getPercent(false)[1], 100);
        assertEquals(song.getPercent(false)[7], 100);
        assertEquals(song.getPercent(false)[11], 100);
        
        assertEquals(song.getPercent(false)[2], 0);
        assertEquals(song.getPercent(false)[6], 0);
        assertEquals(song.getPercent(false)[10], 0);
        song.addHeard(person2, true);
        assertEquals(song.getPercent(false)[2], 100);
        assertEquals(song.getPercent(false)[6], 100);
        assertEquals(song.getPercent(false)[10], 100);
        
        assertEquals(song.getPercent(false)[8], 0);
        assertEquals(song.getPercent(false)[3], 0);
        assertEquals(song.getPercent(false)[4], 0);
        song.addHeard(person, true);
        assertEquals(song.getPercent(false)[4], 100);
        assertEquals(song.getPercent(false)[3], 100);
        assertEquals(song.getPercent(false)[8], 100);
    }
    
    /**
     * check total heard and likes of an empty song
     */
    public void testgetTotal() {
        assertEquals(song.getTotalHeard(), 0);
        assertEquals(song.getTotalLikes(), 0);
    }

    /**
     * check toString method's return format
     */
    public void testToString() {
        assertEquals(song.toString(), "Title: All These"
                + " Things I've Done, Artist: The Killers, Genre: "
                + "2005, Release: alternative" + "\n" + "Heard: 0[]" + "\n"
                + "Like: 0[]" + "\n");
    }
}