package kr.co.ezenac.tbja.sampledev;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        //String json = "{key:[a,b,c]}";
//        String json = "{key:a,key2:b,key3:c}";
//
//        try {
//            JSONObject jObject = new JSONObject(json);
//            String value1 = (String) jObject.get("key");
//            String value2 = (String) jObject.get("key2");
//            String value3 = (String) jObject.get("key3");
//            Log.d("ksj",value1 + " " + value2 + " " + value3);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        try {
//            JSONObject jObject = new JSONObject(json);
//            JSONArray jsonArray = (JSONArray) jObject.get("key");
//            for (int i = 0 ; i < jsonArray.length() ; i++) {
//                Log.d("ksj",jsonArray.get(i).toString());
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        JsonTask jsonTask = new JsonTask();
        jsonTask.execute();

    }

    public class JsonTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String jsonPage = getStringFromUrl("http://172.16.141.201:8090/testJsp/json.jsp");

            return jsonPage;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("ksj",s);
        }
    }

    public String getStringFromUrl(String pUrl) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String forecastJsonStr = null;

        try {
            URL url = new URL(pUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null; // 아무것도 하지 않음
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            forecastJsonStr = buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                }
            }
        }
        return forecastJsonStr;
    }
}
