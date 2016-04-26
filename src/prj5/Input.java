package prj5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class Input {
    
    private static SongList newSong;

    public Input(String survey, String songList) throws FileNotFoundException {
        
        newSong = readSongList(songList);
        readSurvey(newSong, survey);
        new GUIVisualizationWindow(newSong);
    }
    
    /**
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public SongList readSongList(String fileName) throws FileNotFoundException {
        
        SongList out = new SongList();
        File newFile = new File(fileName);
        Scanner fileScanner = new Scanner(newFile);
        fileScanner.nextLine();
        
        while (fileScanner.hasNextLine()) {
            
            String[] stringArray = fileScanner.nextLine().split(",");
            out.add(new Song(stringArray[0], stringArray[1]
                    , stringArray[2], stringArray[3]));
        }
        
        fileScanner.close();
        return out;
    }
    
    /**
     * 
     * @param newSongList
     * @param fileName
     * @throws FileNotFoundException
     */
    public void readSurvey(SongList newSongList, String fileName)
            throws FileNotFoundException {
        
        ArrayList<String[]> newStringArray = new ArrayList<String[]>();
        File fl = new File(fileName);
        Scanner file = new Scanner(fl);
        file.nextLine();
        
        while (file.hasNextLine()) {
            
            String[] arr = file.nextLine().split(",");
            if (arr.length > 5/* && file.hasNextLine()*/) {
                newStringArray.add(arr);
            }
        }
        file.close();
        
        for (int i = 0; i < newStringArray.size(); i++) {
            
            String[] currentEntry = newStringArray.get(i);
            Person newPerson = new Person(currentEntry[2]
                    , currentEntry[3], currentEntry[4]);
            newSongList.addPerson(newPerson);
            
            for (int j = 5; j < currentEntry.length; j++) {
                
                if (currentEntry[j].equals("Yes") && j % 2 == 1) {
                    
                    newSongList.get((j - 5) / 2).addHeard(newPerson, true);
                }
                else if (currentEntry[j].equals("No") && j % 2 == 1) {
                    
                    newSongList.get((j - 5) / 2).addHeard(newPerson, false);
                }
                else if (currentEntry[j].equals("Yes") && j % 2 == 0) {
                    
                    newSongList.get((j - 5) / 2).addLike(newPerson, true);
                }
                else if (currentEntry[j].equals("No") && j % 2 == 0) {
                    
                    newSongList.get((j - 5) / 2).addLike(newPerson, false);
                }
            }
        }
    }
    
    /**
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String arg0 = args[0];
        String arg1 = args[1];
        new Input(arg0, arg1);
        newSong.sort("Genre");
        // represent hobbies
        for (int i = 0; i < newSong.getLength(); i++) {
            int[] songHeard = newSong.getPercentHeard(i);
            int[] songLiked = newSong.getPercentLike(i);

            System.out.println("Song Title: " + newSong.get(i).getTitle());
            System.out.println("Song Artist: " + newSong.get(i).getArtist());
            System.out.println("Song Genre: " + newSong.get(i).getGenre());
            System.out.println("Song Year: " + newSong.get(i).getDate());
            System.out.println("Heard");
            System.out.println("reading:" + songHeard[0] + " art:"
                    + songHeard[1] + " sports:" + songHeard[2] + " music:"
                    + songHeard[3]);
            System.out.println("Likes");
            System.out.println("reading:" + songLiked[0] + " art:"
                    + songLiked[1] + " sports:" + songLiked[2] + " music:"
                    + songLiked[3]);
            System.out.println();
        }
        
        newSong.sort("Title");
        
        // represent hobbies
        for (int i = 0; i < newSong.getLength(); i++) {
            int[] songHeard = newSong.getPercentHeard(i);
            int[] songLiked = newSong.getPercentLike(i);

            System.out.println("Song Title: " + newSong.get(i).getTitle());
            System.out.println("Song Artist: " + newSong.get(i).getArtist());
            System.out.println("Song Genre: " + newSong.get(i).getGenre());
            System.out.println("Song Year: " + newSong.get(i).getDate());
            System.out.println("Heard");
            System.out.println("reading:" + songHeard[0] + " art:"
                    + songHeard[1] + " sports:" + songHeard[2] + " music:"
                    + songHeard[3]);
            System.out.println("Likes");
            System.out.println("reading:" + songLiked[0] + " art:"
                    + songLiked[1] + " sports:" + songLiked[2] + " music:"
                    + songLiked[3]);
            System.out.println("");
        }
    }
}
