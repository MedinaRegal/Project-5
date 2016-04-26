package prj5;

import student.TestCase;

/**
 * this class is used to test out the performance of Person's method
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class PersonTest extends TestCase {
    
    private Person newPerson;
    
    /**
     * set up a new person with strings which represent major, hobby and region
     */
    public void setUp() {
        
        newPerson = new Person("a", "b", "c");
    }
    
    /**
     * check if major, hobby and region are corrrectly returned
     */
    public void testGetters() {
        
        assertEquals(newPerson.getMajor(), "a");
        assertEquals(newPerson.getHobby(), "c");
        assertEquals(newPerson.getRegion(), "b");
    }
    
    /**
     * check if tostring method correctly shows the newPerson's major, region
     * and hobby.
     */
    public void testToString() {
        
        assertEquals(newPerson.toString(),
                "Major: a, Hobby: c, Region: b");
    }
}
