package prj5;

import java.util.ArrayList;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class Song {

    private String title;
    private String artist;
    private String genre;
    private String date;
    
    
    private int numHeardRead;
    private int numHeardArt;
    private int numHeardSports;
    private int numHeardMusic;

    private int numHeardComp;
    private int numHeardEng;
    private int numHeardMath;
    private int numHeardOther;

    private int numLikeSouth;
    private int numLikeNorth;
    private int numLikeUs;
    private int numLikeNon;

    private int numLikeRead;
    private int numLikeArt;
    private int numLikeSports;
    private int numLikeMusic;

    private int numLikeComp;
    private int numLikeEng;
    private int numLikeMath;
    private int numLikeOther;

    private int numHeardSouth;
    private int numHeardNorth;
    private int numHeardUs;
    private int numHeardNon;

    private ArrayList<Person> likeArray;
    private ArrayList<Person> heardArray;

    /**
     * 
     * @param tit
     *            title
     * @param art
     *            artist
     * @param dat
     *            date
     * @param gen
     *            genre
     */
    public Song(String tit, String art, String dat, String gen) {
        likeArray = new ArrayList<Person>();
        heardArray = new ArrayList<Person>();
        title = tit;
        artist = art;
        genre = gen;
        date = dat;

        numHeardRead = 0;
        numHeardArt = 0;
        numHeardSports = 0;
        numHeardMusic = 0;
        numHeardComp = 0;
        numHeardEng = 0;
        numHeardMath = 0;
        numHeardOther = 0;
        numHeardSouth = 0;
        numHeardNorth = 0;
        numHeardUs = 0;
        numHeardNon = 0;

        numLikeRead = 0;
        numLikeArt = 0;
        numLikeSports = 0;
        numLikeMusic = 0;
        numLikeComp = 0;
        numLikeEng = 0;
        numLikeMath = 0;
        numLikeOther = 0;
        numLikeSouth = 0;
        numLikeNorth = 0;
        numLikeUs = 0;
        numLikeNon = 0;
    }

    /**
     * 
     * @return song's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return song's artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * 
     * @return song's genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * 
     * @return song's release date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param p
     *            person that has heard the song
     * @param add
     *            true if person has heard it, false if not
     */
    public void addHeard(Person p, boolean add) {
        if (add) {
            heardArray.add(p);
        }
        String hob = p.getHobby();
        String maj = p.getMajor();
        String reg = p.getRegion();
        if (hob.contains("read")) {
            numHeardRead++;
        }
        else if (hob.contains("art")) {
            numHeardArt++;
        }
        else if (hob.contains("sport")) {
            numHeardSports++;
        }
        else if (hob.contains("music")) {
            numHeardMusic++;
        }
        if (maj.contains("Comp")) {
            numHeardComp++;
        }
        else if (maj.contains("Eng")) {
            numHeardEng++;
        }
        else if (maj.contains("Math")) {
            numHeardMath++;
        }
        else if (maj.equals("Other")) {
            numHeardOther++;
        }
        if (reg.equals("Southeast")) {
            numHeardSouth++;
        }
        else if (reg.equals("Northeast")) {
            numHeardNorth++;
        }
        else if (reg.contains("other")) {
            numHeardUs++;
        }
        else if (reg.contains("Outside")) {
            numHeardNon++;
        }
    }

    /**
     * 
     * @param p
     *            person that likes the song
     * @param add
     *            true if person likes it, false if not
     * 
     */
    public void addLike(Person p, boolean add) {
        if (add) {
            likeArray.add(p);
        }
        String hob = p.getHobby();
        String maj = p.getMajor();
        String reg = p.getRegion();
        if (hob.contains("read")) {
            numLikeRead++;
        }
        else if (hob.contains("art")) {
            numLikeArt++;
        }
        else if (hob.contains("sport")) {
            numLikeSports++;
        }
        else if (hob.contains("music")) {
            numLikeMusic++;
        }
        if (maj.contains("Comp")) {
            numLikeComp++;
        }
        else if (maj.contains("Eng")) {
            numLikeEng++;
        }
        else if (maj.contains("Math")) {
            numLikeMath++;
        }
        else if (maj.equals("Other")) {
            numLikeOther++;
        }
        if (reg.equals("Southeast")) {
            numLikeSouth++;
        }
        else if (reg.equals("Northeast")) {
            numLikeNorth++;
        }
        else if (reg.contains("other")) {
            numLikeUs++;
        }
        else if (reg.contains("Outside")) {
            numLikeNon++;
        }
    }

    /**
     * 
     * @return ArrayList of people who like the song
     */
    public ArrayList<Person> getLike() {
        return likeArray;
    }

    /**
     * 
     * @return ArrayList of people who have heard the song
     */
    public ArrayList<Person> getHeard() {
        return heardArray;
    }

    /**
     * 
     * @return int array of number of people who heard the song
     */
    public int[] getNumHeard() {
        int[] out = new int[12];
        for (int i = 0; i < 12; i++) {
            out[i] = 0;
        }
        for (int i = 0; i < heardArray.size(); i++) {
            if (heardArray.get(i).getHobby().contains("read")) {
                out[0]++;
            }
            else if (heardArray.get(i).getHobby().contains("art")) {
                out[1]++;
            }
            else if (heardArray.get(i).getHobby().contains("sport")) {
                out[2]++;
            }
            else if (heardArray.get(i).getHobby().contains("music")) {
                out[3]++;
            }
            if (heardArray.get(i).getMajor().contains("Comp")) {
                out[4]++;
            }
            else if (heardArray.get(i).getMajor().contains("Eng")) {
                out[5]++;
            }
            else if (heardArray.get(i).getMajor().contains("Math")) {
                out[6]++;
            }
            else if (heardArray.get(i).getMajor().equals("Other")) {
                out[7]++;
            }
            if (heardArray.get(i).getRegion().equals("Southeast")) {
                out[8]++;
            }
            else if (heardArray.get(i).getRegion().equals("Northeast")) {
                out[9]++;
            }
            else if (heardArray.get(i).getRegion().contains("other")) {
                out[10]++;
            }
            else if (heardArray.get(i).getRegion().contains("Outside")) {
                out[11]++;
            }
        }
        return out;
    }

    /**
     * 
     * @return int array of number of people who like the song
     */
    public int[] getNumLike() {
        int[] out = new int[12];
        for (int i = 0; i < 12; i++) {
            out[i] = 0;
        }
        for (int i = 0; i < likeArray.size(); i++) {
            if (likeArray.get(i).getHobby().contains("read")) {
                out[0]++;
            }
            else if (likeArray.get(i).getHobby().contains("art")) {
                out[1]++;
            }
            else if (likeArray.get(i).getHobby().contains("sport")) {
                out[2]++;
            }
            else if (likeArray.get(i).getHobby().contains("music")) {
                out[3]++;
            }
            if (likeArray.get(i).getMajor().contains("Comp")) {
                out[4]++;
            }
            else if (likeArray.get(i).getMajor().contains("Eng")) {
                out[5]++;
            }
            else if (likeArray.get(i).getMajor().contains("Math")) {
                out[6]++;
            }
            else if (likeArray.get(i).getMajor().equals("Other")) {
                out[7]++;
            }
            if (likeArray.get(i).getRegion().equals("Southeast")) {
                out[8]++;
            }
            else if (likeArray.get(i).getRegion().equals("Northeast")) {
                out[9]++;
            }
            else if (likeArray.get(i).getRegion().contains("other")) {
                out[10]++;
            }
            else if (likeArray.get(i).getRegion().contains("Outside")) {
                out[11]++;
            }
        }
        return out;
    }

    /**
     * 
     * @return int people who heard it
     */
    public int getTotalHeard() {
        return heardArray.size();
    }

    /**
     * 
     * @return int people who like it
     */
    public int getTotalLikes() {
        return likeArray.size();
    }

    /**
     * 
     * @param like true if like, false if heard
     * @return array of numbers of people who like/heard
     *         the song
     */
    public int[] getPercent(boolean like) {
        int[] out;
        if (like) {
            out = getNumLike();
            if (numLikeRead != 0) {
                out[0] = (int) (out[0] * 1.0 / numLikeRead * 100);
            }
            else {
                out[0] = 0;
            }
            if (numLikeArt != 0) {
                out[1] = (int) (out[1] * 1.0 / numLikeArt * 100);
            }
            else {
                out[1] = 0;
            }
            if (numLikeSports != 0) {
                out[2] = (int) (out[2] * 1.0 / numLikeSports * 100);
            }
            else {
                out[2] = 0;
            }
            if (numLikeMusic != 0) {
                out[3] = (int) (out[3] * 1.0 / numLikeMusic * 100);
            }
            else {
                out[3] = 0;
            }
            if (numLikeComp != 0) {
                out[4] = (int) (out[4] * 1.0 / numLikeComp * 100);
            }
            else {
                out[4] = 0;
            }
            if (numLikeEng != 0) {
                out[5] = (int) (out[5] * 1.0 / numLikeEng * 100);
            }
            else {
                out[5] = 0;
            }
            if (numLikeMath != 0) {
                out[6] = (int) (out[6] * 1.0 / numLikeMath * 100);
            }
            else {
                out[6] = 0;
            }
            if (numLikeOther != 0) {
                out[7] = (int) (out[7] * 1.0 / numLikeOther * 100);
            }
            else {
                out[7] = 0;
            }
            if (numLikeSouth != 0) {
                out[8] = (int) (out[8] * 1.0 / numLikeSouth * 100);
            }
            else {
                out[8] = 0;
            }
            if (numLikeNorth != 0) {
                out[9] = (int) (out[9] * 1.0 / numLikeNorth * 100);
            }
            else {
                out[9] = 0;
            }
            if (numLikeUs != 0) {
                out[10] = (int) (out[10] * 1.0 / numLikeUs * 100);
            }
            else {
                out[10] = 0;
            }
            if (numLikeNon != 0) {
                out[11] = (int) (out[11] * 1.0 / numLikeNon * 100);
            }
            else {
                out[11] = 0;
            }
        }
        else {
            out = getNumHeard();
            if (numHeardRead != 0) {
                out[0] = (int) (out[0] * 1.0 / numHeardRead * 100);
            }
            else {
                out[0] = 0;
            }
            if (numHeardArt != 0) {
                out[1] = (int) (out[1] * 1.0 / numHeardArt * 100);
            }
            else {
                out[1] = 0;
            }
            if (numHeardSports != 0) {
                out[2] = (int) (out[2] * 1.0 / numHeardSports * 100);
            }
            else {
                out[2] = 0;
            }
            if (numHeardMusic != 0) {
                out[3] = (int) (out[3] * 1.0 / numHeardMusic * 100);
            }
            else {
                out[3] = 0;
            }
            if (numHeardComp != 0) {
                out[4] = (int) (out[4] * 1.0 / numHeardComp * 100);
            }
            else {
                out[4] = 0;
            }
            if (numHeardEng != 0) {
                out[5] = (int) (out[5] * 1.0 / numHeardEng * 100);
            }
            else {
                out[5] = 0;
            }
            if (numHeardMath != 0) {
                out[6] = (int) (out[6] * 1.0 / numHeardMath * 100);
            }
            else {
                out[6] = 0;
            }
            if (numHeardOther != 0) {
                out[7] = (int) (out[7] * 1.0 / numHeardOther * 100);
            }
            else {
                out[7] = 0;
            }
            if (numHeardSouth != 0) {
                out[8] = (int) (out[8] * 1.0 / numHeardSouth * 100);
            }
            else {
                out[8] = 0;
            }
            if (numHeardNorth != 0) {
                out[9] = (int) (out[9] * 1.0 / numHeardNorth * 100);
            }
            else {
                out[9] = 0;
            }
            if (numHeardUs != 0) {
                out[10] = (int) (out[10] * 1.0 / numHeardUs * 100);
            }
            else {
                out[10] = 0;
            }
            if (numHeardNon != 0) {
                out[11] = (int) (out[11] * 1.0 / numHeardNon * 100);
            }
            else {
                out[11] = 0;
            }
        }

        return out;
    }

    /**
     * @return String representation of the song
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ");
        sb.append(title);
        sb.append(", Artist: ");
        sb.append(artist);
        sb.append(", Genre: ");
        sb.append(genre);
        sb.append(", Release: ");
        sb.append(date);
        sb.append("\nHeard: ");
        sb.append(heardArray.size());
        sb.append(heardArray);
        sb.append("\nLike: ");
        sb.append(likeArray.size());
        sb.append(likeArray);
        sb.append("\n");
        return sb.toString();
    }
}
