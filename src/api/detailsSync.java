package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class detailsSync {

    public detailsSync() throws MalformedURLException, IOException {

        String line = null;
        String url = " http://ravindalakshan-learningwithme.rhcloud.com/hope.php";
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        File f = new File("src/temps/playlist.txt");
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            wr.writeBytes(line);
        }
        wr.flush();
        bufferedReader.close();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader inc = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine = inc.readLine();
        StringBuffer response1 = new StringBuffer();

        while ((inputLine = inc.readLine()) != null) {
            response1.append("\n" + inputLine);
        }
        inc.close();

        System.out.println(response1.toString());

    }

}
