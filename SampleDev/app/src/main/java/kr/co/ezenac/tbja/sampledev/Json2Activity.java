package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json2);

        String json = "{arr:[1,2,3]}";
        int[] iArr = null;

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("arr");
            iArr = new int[arr.length()];
            for (int i = 0 ; i < arr.length() ; i++) {
                iArr[i] = (int) arr.get(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0 ; i < iArr.length ; i++) {
            Log.d("ksj",iArr[i] + " ");
        }

        /*
        String json = "{name:\"kimseongjae\",phone:\"0105543343\",addr:\"seoul\"}";

        try {
            JSONObject obj = new JSONObject(json);
            String name = obj.getString("name");
            String phone = obj.getString("phone");
            String addr = obj.getString("addr");

            Log.d("ksj",name + " " + phone + " " + addr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */
    }
}
