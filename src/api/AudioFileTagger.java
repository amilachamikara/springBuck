package api;

import com.beaglebuddy.id3.enums.PictureType;
import com.beaglebuddy.id3.pojo.AttachedPicture;
import com.beaglebuddy.mp3.MP3;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;

public class AudioFileTagger {

    private File file;
    private MP3 tag;

    private String title = "Undefined";
    private String artist = "Undefined";
    private String album = "Undefined";
    private String genre = "Undefined";
    private String composer = "Undefined";
    private String year = "Undefined";
    private String rating = "0";

    public AudioFileTagger(File file) {
        try {
            this.file = file;
            this.tag = new MP3(this.file);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public AudioFileTagger() {

    }

    public void writeTag()throws Exception{
        
            tag.save();
            
        
    }

    /**
     * @param tag the tag to set
     */
    public void setFile(File file) {
        try {
            this.file = file;
            this.tag = new MP3(this.file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @return the title
     */
    public String getTitle() {
        try {
            if (tag.getTitle() != null) {
                this.title = tag.getTitle();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
        tag.setTitle(this.title);
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        try {
            if (tag.getLeadPerformer() != null) {
                this.artist = tag.getLeadPerformer();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
        tag.setLeadPerformer(this.artist);
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        try {
            if (tag.getAlbum() != null) {
                this.album = tag.getAlbum();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
        tag.setAlbum(this.album);
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        try {
            if (tag.getMusicType() != null) {
                this.genre = tag.getMusicType();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
        tag.setMusicType(this.genre);
    }

    /**
     * @return the composer
     */
    public String getComposer() {
        try {
            if (tag.getPublisher() != null) {
                this.composer = tag.getPublisher();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.composer;
    }

    /**
     * @param composer the composer to set
     */
    public void setComposer(String composer) {
        this.composer = composer;
        tag.setPublisher(this.composer);
    }

    /**
     * @return the year
     */
    public String getYear() {
        try {
            if (tag.getYear() != 0) {
                this.year = String.valueOf(tag.getYear());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
        try {
            tag.setYear(Integer.valueOf(this.year));
        } catch (Exception e) {
            tag.setYear(1);
        }
    }

    /**
     * @return the rating
     */
    public String getRating() {
        try {
            if (tag.getRating() != 0) {
                this.rating = String.valueOf(tag.getRating());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
        
        try {
            tag.setRating(Integer.valueOf(this.year)*42);
        } catch (Exception e) {
            tag.setRating(0);
        }
    }
    
    public ImageIcon getImage(){
        List<AttachedPicture> picList = tag.getPictures();
        AttachedPicture pic=new AttachedPicture(PictureType.OTHER, "image/jpg", "Empty", new byte[]{0,2,3,3});
        for(AttachedPicture p:picList){
            if(p!=null){
                pic = p;
            }
        }
        ImageIcon icon = new ImageIcon(pic.getImage());
        return icon;
    }
    
    public void setImage(File f){
        try {
            tag.setPicture(PictureType.FRONT_COVER, f);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

}
