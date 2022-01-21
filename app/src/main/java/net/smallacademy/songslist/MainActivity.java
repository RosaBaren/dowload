package net.smallacademy.songslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Song> songs = new ArrayList<>();
    private static String JSON_URL = "https://my-json-server/Json/db";
    Adapter adapter;
    Song pdf = new Song();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.songsList);
        extractSongs();
    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject nombre = new JSONObject(response) ;
                    JSONArray nombre1 = nombre.getJSONArray("ficheros");
                for (int i = 0; i < response.length(); i++) {

                        JSONObject songObject = nombre1.getJSONObject(i);

                        Song song = new Song();
                        song.setId(songObject.getString("id"));
                         song.setDescripcion(songObject.getString("descripcion"));
                         song.setFecha(songObject.getString("fecha"));
                         song.setUrl(songObject.getString("url"));
                         song.setSongURL(songObject.getString("url"));
                        songs.add(song);


                }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),songs);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }
}
