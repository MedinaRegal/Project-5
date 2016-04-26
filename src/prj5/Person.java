package prj5;

/**
 * this class is a Person class which stores a person's major, region and hobby
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class Person {
    private String major;
    private String hobby;
    private String region;

    /**
     * 
     * @param inputMajor represents major
     * @param inputRegion region
     * @param inputHobby hobby
     */
    public Person(String inputMajor, String inputRegion, String inputHobby) {
        
        major = inputMajor;
        hobby = inputHobby;
        region = inputRegion;
    }

    /**
     * getter method for this person's major
     * @return person's major
     */
    public String getMajor() {
        
        return major;
    }

    /**
     * getter method for this person's hobby
     * @return person's hobby
     */
    public String getHobby() {
        
        return hobby;
    }

    /**
     * getter method for this person's region
     * @return person's region
     */
    public String getRegion() {
        
        return region;
    }

    /**
     * this method is used to return a string of 
     * a person's name, hobby and region.
     * @return String representation of a person
     */
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Major: ");
        sb.append(major);
        sb.append(", Hobby: ");
        sb.append(hobby);
        sb.append(", Region: ");
        sb.append(region);
        return sb.toString();
    }
}
