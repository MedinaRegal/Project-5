package prj5;


import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Daniel Medina, dmedina
 *         Shuaicheng Zhang, zshuai8
 *         James Jee, jamesj95
 * @version 2016/4/10
 */
public class GUIVisualizationWindow {
    
    //window
    private Window window;
    
    //buttons
    private Button artist;
    private Button songName;
    private Button release;
    private Button genre;
    private Button hobby;
    private Button region;
    private Button major;
    private Button prev;
    private Button next;
    private Button quit;
    
    //textShapes for displaying texts
    private TextShape startText;
    private Legend legendShape;
    private int totalPage;
    private int currentPage;
    private int index;
    private SongList songs;
    private Glyph[] onScreen;
    private String representation;
    private boolean firstClick;
    
    private String sortedCategory = "artist";
    private String majorCategoryData = "hobby";
    
    /**
     * 
     * @param data
     *            SongList containing data
     */
    public GUIVisualizationWindow(SongList data) {
        
        representation = "";
        songs = data;
        totalPage = (int) Math.ceil((double) (songs.getLength() * 1.0  / 9));
        currentPage = 1;
        firstClick = false;
        index = 0;
        window = new Window("Music Preference Visualization");
        startText = new TextShape(250, 150,
                "Please select how to represent songs.", Color.black);
        window.addShape(startText);
        onScreen = new Glyph[9];
        initButtons(quit, hobby, region, major);
    }

    /**
     * Is executed when Sort by Artist is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedArtist(Button button) {
        
        prev.disable();
        next.enable();
        index = 0;
        currentPage = 1;
        songs.sort("Artist");
        sortedCategory = "artist";
        
        updateGlyph();
        updateData();
    }

    /**
     * Is executed when Sort by Title is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedSong(Button button) {
        
        prev.disable();
        next.enable();
        index = 0;
        currentPage = 1;
        songs.sort("Title");
        sortedCategory = "artist";
        
        updateGlyph();
        updateData();
    }

    /**
     * Is executed when Sort by Release Date is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedRelease(Button button) {
        
        prev.disable();
        next.enable();
        index = 0;
        currentPage = 1;
        songs.sort("Release");
        sortedCategory = "release";

        updateGlyph();
        updateData();
    }

    /**
     * Is executed when Sort by Genre is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedGenre(Button button) {
        
        prev.disable();
        next.enable();
        index = 0;
        currentPage = 1;
        songs.sort("Genre");
        sortedCategory = "genre";
        
        updateGlyph();
        updateData();
    }

    /**
     * Is executed when Previous is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedPrev(Button button) {
        
        currentPage--;
        if (currentPage != 1) {
            
            index -= 9;
            
        }
        else {
            
            prev.disable();
            index = 0;     
        }
        updateGlyph();
        next.enable();
    }

    /**
     * Is executed when Next is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedNext(Button button) {
        
        currentPage++;
        if  (currentPage < totalPage) {
            
            index += 9;

        }
        else if (currentPage == totalPage) {
            
            index = 9 * (currentPage - 1);
            next.disable();
        }
        updateGlyph();
        prev.enable();
    }

    /**
     * Is executed when Quit is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedQuit(Button button) {
        
        System.exit(0);
    }

    /**
     * Is executed when Represent Hobby is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedHobby(Button button) {
        
        firstClick();
        representation = "Hobby Legend";
        legendShape.setText();
        majorCategoryData = "hobby";
        int counter = 9;
        
        if (songs.getLength() - (currentPage - 1) * 9 < 9) {
            
            counter = songs.getLength() - (currentPage - 1) * 9;
        }
        
        
        for (int i = 0; i < counter; i++) {
            
            int[] percentHeard = songs.getPercentHeard(index + i);
            int[] percentLike = songs.getPercentLike(index + i);
            onScreen[i].setPink(percentHeard[0], percentLike[0]);
            onScreen[i].setBlue(percentHeard[1], percentLike[1]);
            onScreen[i].setOrange(percentHeard[2], percentLike[2]);
            onScreen[i].setGreen(percentHeard[3], percentLike[3]);
        }
    }

    /**
     * Is executed when Represent Region is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedRegion(Button button) {
        
        firstClick();
        representation = "Region Legend";
        legendShape.setText();
        majorCategoryData = "region";
        int counter = 9;
        
        if (songs.getLength() - (currentPage - 1) * 9 < 9) {
            
            counter = songs.getLength() - (currentPage - 1) * 9;
        }
        
        
        for (int i = 0; i < counter; i++) {
            
            int[] percentHeard = songs.getPercentHeard(index + i);
            int[] percentLike = songs.getPercentLike(index + i);
            
            onScreen[i].setPink(percentHeard[4], percentLike[4]);
            onScreen[i].setBlue(percentHeard[5], percentLike[5]);
            onScreen[i].setOrange(percentHeard[6], percentLike[6]);
            onScreen[i].setGreen(percentHeard[7], percentLike[7]);
        }
    }

    /**
     * Is executed when Represent Major is clicked
     * @param button
     *            Button we clicked
     */
    public void clickedMajor(Button button) {
        
        firstClick();
        majorCategoryData = "major";
        representation = "Major Legend";
        legendShape.setText();
        int counter = 9;
        
        if (songs.getLength() - (currentPage - 1) * 9 < 9) {
            
            counter = songs.getLength() - (currentPage - 1) * 9;
        }
        
        
        for (int i = 0; i < counter; i++) {
            int[] percentHeard = songs.getPercentHeard(index + i);
            int[] percentLike = songs.getPercentLike(index + i);
            onScreen[i].setPink(percentHeard[8], percentLike[8]);
            onScreen[i].setBlue(percentHeard[9], percentLike[9]);
            onScreen[i].setOrange(percentHeard[10], percentLike[10]);
            onScreen[i].setGreen(percentHeard[11], percentLike[11]);
        }
    }

    /**
     * Initializes buttons and adds them to the window
     */
    private void initButtons(Button quitB, 
            Button hobbyB, Button regionB, Button majorB) {
        
        artist = new Button("Sort by Artist Name");
        artist.onClick(this, "clickedArtist");
        songName = new Button("Sort by Song Title");
        songName.onClick(this, "clickedSong");
        release = new Button("Sort by Release Date");
        release.onClick(this, "clickedRelease");
        genre = new Button("Sort by Genre");
        genre.onClick(this, "clickedGenre");

        prev = new Button("\u2190 Prev");
        prev.onClick(this, "clickedPrev");
        next = new Button("Next \u2192");
        next.onClick(this, "clickedNext");
        quitB = new Button("Quit");
        quitB.onClick(this, "clickedQuit");

        hobbyB = new Button("Represent Hobby");
        hobbyB.onClick(this, "clickedHobby");
        regionB = new Button("Represent Region");
        regionB.onClick(this, "clickedRegion");
        majorB = new Button("Represent Major");
        majorB.onClick(this, "clickedMajor");

        prev.disable();
        next.disable();
        songName.disable();
        artist.disable();
        genre.disable();
        release.disable();

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(artist, WindowSide.NORTH);
        window.addButton(songName, WindowSide.NORTH);
        window.addButton(release, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        window.addButton(hobbyB, WindowSide.SOUTH);
        window.addButton(majorB, WindowSide.SOUTH);
        window.addButton(regionB, WindowSide.SOUTH);
        window.addButton(quitB, WindowSide.SOUTH);
    }

    /**
     * Updates Glyph shapes
     */
    private void updateGlyph() {
        
        for (int i = 0; i < 9; i++) {
            if (onScreen[i] != null) {
                onScreen[i].remove();
            }
        }
        
        onScreen[0] = new Glyph(window, 100, 50, index, sortedCategory);
        
        if (songs.getLength() > index + 1) {
            
            onScreen[1] = new Glyph(window, 300, 50, index + 1
                    , sortedCategory);
        }

        if (songs.getLength() > index + 2) {
            
            onScreen[2] = new Glyph(window, 500, 50, index + 2
                    , sortedCategory);
        }

        if (songs.getLength() > index + 3) {
            
            onScreen[3] = new Glyph(window, 100, 140, index + 3
                    , sortedCategory);
        }

        if (songs.getLength() > index + 4) {
            
            onScreen[4] = new Glyph(window, 300, 140, index + 4
                    , sortedCategory);
        }

        if (songs.getLength() > index + 5) {
            
            onScreen[5] = new Glyph(window, 500, 140, index + 5
                    , sortedCategory);
        }

        if (songs.getLength() > index + 6) {
            
            onScreen[6] = new Glyph(window, 100, 230, index + 6
                    , sortedCategory);
        }

        if (songs.getLength() > index + 7) {
            
            onScreen[7] = new Glyph(window, 300, 230, index + 7
                    , sortedCategory);
        }

        if (songs.getLength() > index + 8) {
            
            onScreen[8] = new Glyph(window, 500, 230, index + 8
                    , sortedCategory);
        }
    }

    /**
     * Is executed when the first button is clicked
     */
    private void firstClick() {
        
        if (!firstClick) {
            
            window.removeShape(startText);
            updateGlyph();
            legendShape = new Legend(window);
            next.enable();
            songName.enable();
            artist.enable();
            genre.enable();
            release.enable();
        }
        firstClick = true;
    }
    
    /**
     * 
     */
    private void updateData() {
        
        Button button = new Button();
        if (majorCategoryData.equals("hobby")) {
            
            clickedHobby(button);
        }
        else if (majorCategoryData.equals("region")) {
            
            clickedRegion(button);
        }
        else if (majorCategoryData.equals("major")) {
            
            clickedMajor(button);
        }
    }

    /**
     * Glyph shape class
     * @author Daniel Medina, dmedina
     *         Shuaicheng Zhang, zshuai8
     *         James Jee, jamesj95
     * @version 2016/4/10
     *
     */
    private class Glyph {
        
        private Window window;
        private Shape blackBar;
        private Shape pinkBar;
        private Shape blueBar;
        private Shape orangeBar;
        private Shape greenBar;

        private TextShape title;
        private TextShape newLine;
        private int x;
        private int y;

        /**
         * 
         * @param w
         *            window
         * @param xPos
         *            x position
         * @param yPos
         *            y position
         */
        public Glyph(Window w, int xPos, int yPos, int index, String category) {
            
            Song song = songs.get(index);
            x = xPos;
            y = yPos;
            window = w;
            
            int[] heard = songs.getPercentHeard(index);
            int[] liked = songs.getPercentLike(index);
            
            pinkBar = new Shape(x - heard[0], y, 5 + heard[0] + liked[0], 10,
                    Color.magenta);
            blueBar = new Shape(x - heard[1], y + 10, heard[1] + liked[1], 10,
                    Color.blue);
            orangeBar = new Shape(x - heard[2], y + 20, heard[2] + liked[2],
                    10, Color.orange);
            greenBar = new Shape(x - heard[3], y + 30, heard[3] + liked[3], 10,
                    Color.green);
            blackBar = new Shape(x, y, 5, 40, Color.black);
            title = new TextShape(x - (song.getTitle().length() / 2 * 6),
                    y - 40, song.getTitle(), Color.black);
            
            if (category.equals("artist")) {
                
                newLine = new TextShape(x - (song.getArtist().length() / 2 * 6),
                        y - 20, song.getArtist(), Color.black);
            }
            else if (category.equals("release")) {
                
                newLine = new TextShape(x - (song.getDate().length() / 2 * 6),
                        y - 20, song.getDate(), Color.black);
            }
            else if (category.equals("genre")) {
                
                newLine = new TextShape(x - (song.getGenre().length() / 2 * 6),
                        y - 20, song.getGenre(), Color.black);
            }
            title.setBackgroundColor(Color.white);
            newLine.setBackgroundColor(Color.white);
            
            window.addShape(title);
            window.addShape(newLine);
            window.addShape(blackBar);
            window.addShape(pinkBar);
            window.addShape(blueBar);
            window.addShape(orangeBar);
            window.addShape(greenBar);
        }

        /**
         * 
         * @param heard
         *            number of people who have heard the song
         * @param likes
         *            number of people who like the song
         */
        public void setPink(int heard, int likes) {
            
            window.removeShape(pinkBar);
            pinkBar = new Shape(x - heard, y, 5 + heard + likes, 10,
                    Color.magenta);
            window.addShape(pinkBar);
        }

        /**
         * 
         * @param heard
         *            number of people who have heard the song
         * @param likes
         *            number of people who like the song
         */
        public void setBlue(int heard, int likes) {
            
            window.removeShape(blueBar);
            blueBar = new Shape(x - heard, y + 10, 5 + heard + likes, 10,
                    Color.blue);
            window.addShape(blueBar);
        }

        /**
         * 
         * @param heard
         *            number of people who have heard the song
         * @param likes
         *            number of people who like the song
         */
        public void setOrange(int heard, int likes) {
            
            window.removeShape(orangeBar);
            orangeBar = new Shape(x - heard, y + 20, 5 + heard + likes, 10,
                    Color.orange);
            window.addShape(orangeBar);
        }

        /**
         * 
         * @param heard
         *            number of people who have heard the song
         * @param likes
         *            number of people who like the song
         */
        public void setGreen(int heard, int likes) {
            window.removeShape(greenBar);
            greenBar = new Shape(x - heard, y + 30, 5 + heard + likes, 10,
                    Color.green);
            window.addShape(greenBar);
        }


        /**
         * 
         */
        public void remove() {
            
            window.removeShape(blackBar);
            window.removeShape(pinkBar);
            window.removeShape(blueBar);
            window.removeShape(orangeBar);
            window.removeShape(greenBar);
            window.removeShape(title);
            window.removeShape(newLine);
        }
    }

    /**
     * Legend class
     * @author Daniel Medina, dmedina
     *         Shuaicheng Zhang, zshuai8
     *         James Jee, jamesj95
     * @version 2016/4/10
     *
     */
    private class Legend {
        
        private Shape legendShape;
        private Shape border;
        private Shape legendGlyph;

        private TextShape pinkText;
        private TextShape blueText;
        private TextShape orangeText;
        private TextShape greenText;
        private TextShape legendText;
        private TextShape title;
        private TextShape heard;
        private TextShape likes;

        private Window window;

        /**
         * 
         * @param w
         *            window
         */
        public Legend(Window w) {
            
            window = w;

            legendText = new TextShape(600, 145, "", Color.black);

            pinkText = new TextShape(600, 160, "", Color.magenta);
            blueText = new TextShape(600, 175, "", Color.blue);
            orangeText = new TextShape(600, 190, "", Color.orange);
            greenText = new TextShape(600, 205, "", Color.green);

            legendShape = new Shape(600, 140, 100, 130, Color.white);
            border = new Shape(599, 139, 102, 132, Color.black);
            legendGlyph = new Shape(645, 240, 5, 30, Color.black);

            title = new TextShape(610, 220, "Song Title", Color.black);
            heard = new TextShape(600, 240, "Heard", Color.black);
            likes = new TextShape(655, 240, "Likes", Color.black);

            pinkText.setBackgroundColor(Color.white);
            blueText.setBackgroundColor(Color.white);
            orangeText.setBackgroundColor(Color.white);
            greenText.setBackgroundColor(Color.white);
            legendText.setBackgroundColor(Color.white);
            title.setBackgroundColor(Color.white);
            heard.setBackgroundColor(Color.white);
            likes.setBackgroundColor(Color.white);

            window.addShape(title);
            window.addShape(pinkText);
            window.addShape(blueText);
            window.addShape(orangeText);
            window.addShape(greenText);
            window.addShape(legendText);
            window.addShape(heard);
            window.addShape(likes);

            window.addShape(legendGlyph);
            window.addShape(legendShape);
            window.addShape(border);

            setText();
        }

        /**
         * 
         */
        public void setText() {
            
            legendText.setText(representation);
            
            if (representation.contains("Hobby")) {
                pinkText.setText("Read");
                blueText.setText("Art");
                orangeText.setText("Sports");
                greenText.setText("Music");
            }
            else if (representation.contains("Major")) {
                pinkText.setText("Comp Sci");
                blueText.setText("Other Eng");
                orangeText.setText("Math/CMDA");
                greenText.setText("Other");
            }
            else if (representation.contains("Region")) {
                pinkText.setText("Southeast");
                blueText.setText("Northeast");
                orangeText.setText("US(Other)");
                greenText.setText("non-US");
            }
            else {
                pinkText.setText("");
                blueText.setText("");
                orangeText.setText("");
                greenText.setText("");
            }
        }
    }
}
