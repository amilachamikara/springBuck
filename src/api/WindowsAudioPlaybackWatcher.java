
package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class WindowsAudioPlaybackWatcher {
    private List<MediaListener> listeners;
    public WindowsAudioPlaybackWatcher() {
        listeners = new ArrayList<>();
        startWatch();
    }
    public void addListener(MediaListener ml) {
        listeners.add(ml);
    }

    public void startWatch() {
        
        new Thread(new Runnable() {
            String app = null;
            String file = null;
            
            @Override
            public void run() {
                try {
                    //start process that watch for PlaybackManager EventLog 
                    Process csmodule = Runtime.getRuntime().exec("TeamInnova.exe");
                    int pid = 0;
                    Scanner csmoduleReader = new Scanner(csmodule.getInputStream());
                    System.out.println(csmoduleReader.nextLine());

                    while (csmoduleReader.hasNext()) {
                        app = csmoduleReader.nextLine();
                        file = csmoduleReader.nextLine();
                        for(MediaListener ml : listeners){
                            ml.mediaPlayed(app, file);
                        }
                    }
                    csmoduleReader.close();
                    csmodule.destroy();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
