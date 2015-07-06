
package api;

import frames.JDBC;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;

public class PlaylistFile {

    public static void writeFile(int user_id) {
        int uid = user_id;
        JDBC jdbc = new JDBC();
        int i = 1;
        try {
            File file = new File("src/temps/playlist.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            ResultSet rss = JDBC.getData("select time_slot.start_time, time_slot.end_time,application.file_path,media_file.title,media_file.genre,media_file.artist,frequency  from event_log, application,time_slot,media_file where application.application_id = event_log.application_id and time_slot.timeslot_id=event_log.timeslot_id and media_file.file_id=event_log.media_id");
            while (rss.next()) {
                bw.write(uid + ",");
                for (i = 1; i < 8; i++) {

                    if (i == 3) {
                        String x[] = rss.getString(i).split("&");
                        bw.write(x[x.length - 1] + ",");
                    } else if (i == 7) {
                        bw.write(rss.getString(i));
                    } else {
                        bw.write(rss.getString(i) + ",");
                    }
                }
                bw.write(";");
            }
            bw.close();
            detailsSync dsyn = new detailsSync();
        } catch (Exception E) {
            System.out.println(E);
        }
    }


}
