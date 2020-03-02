package at.htlkaindorf.mahohoma;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class APICon extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL("https://financialmodelingprep.com/api/v3/search?query=AA&limit=10&exchange=NASDAQ");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            String text="";
            for (String line; (line = reader.readLine()) != null;) {
                text += line+"\n";
            }
            return text;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
