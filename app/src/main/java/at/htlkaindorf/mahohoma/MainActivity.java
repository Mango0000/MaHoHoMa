package at.htlkaindorf.mahohoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText etSearch;
    TextView tvSearch;
    Button btsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch = findViewById(R.id.searchname);
        tvSearch = findViewById(R.id.tvSearch);
        btsearch = findViewById(R.id.btSearch);
        btsearch.setOnClickListener(this::onSearch);
    }

    public void onSearch(View view){
        APICon apic = new APICon();
        try {
            tvSearch.setText(apic.execute("test").get());
        } catch (ExecutionException e) {
            tvSearch.setText(e.toString());
        } catch (InterruptedException e) {
            tvSearch.setText(e.toString());
        }
    }
}
