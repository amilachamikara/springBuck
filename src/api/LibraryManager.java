package api;

import com.beaglebuddy.mp3.MP3;
import frames.JDBC;
import java.io.File;
import java.sql.ResultSet;

public class LibraryManager {

    public static void extractFiles(File parent, String[] ext, int folderid) throws Exception {
        File[] roots = parent.listFiles();
       AudioFileTagger aft = new AudioFileTagger();
        for (File f : roots) {
            if (f.isDirectory()) {
                extractFiles(f, ext, folderid);
            } else {
                
                
                for (String end : ext) {
                    if (f.getName().endsWith(end)) {
                        aft.setFile(f);
                        
                        ResultSet rs = JDBC.getData("SELECT MAX(FILE_ID)+1 FROM MEDIA_FILE");
                        rs.next();
                        int fileId = rs.getInt(1);
                        System.out.println(f.getAbsolutePath());
                        
                        
                        JDBC.setData("INSERT INTO MEDIA_FILE(FOLDER_ID,FILE_ID,FILE_PATH,title,artist,album,genre,composer,mf_year,ratings) VALUES(" + folderid + "," + fileId + ",'" + f.getAbsolutePath().replace("\\", "&").replace('\'', ' ') + "','" + aft.getTitle().replace('\'', ' ') + "','" + aft.getArtist().replace('\'', ' ') + "','" + aft.getAlbum().replace('\'', ' ') + "','" + aft.getGenre().replace('\'', ' ') + "','" + aft.getComposer().replace('\'', ' ') + "','" + aft.getYear() + "'," + aft.getRating() + ")");
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

        //extractFiles(new File("E:\\Musics\\Sinhala\\Mix"),new String[]{".mp3"});
    }

}
