package kr.co.ezenac.tbja.sampledev;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AsyncTast2Activity extends AppCompatActivity {
    private ProgressDialog dialog;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_tast2);
        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestTast testTast = new TestTast();
                testTast.execute(10,20,30);
            }
        });
    }

    public class TestTast extends AsyncTask<Integer,Integer,String> {//필요없을때는 Void객체 이용
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(AsyncTast2Activity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMessage("loading..");
            dialog.setMax(10);
            dialog.setProgress(0);
            dialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            dialog.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(Integer... integers) {

            Log.d("ksj",integers[0] + "=" + integers[1] + "=" + integers[2]);

            for (int i = 0 ; i < 3 ; i++) {
                    publishProgress(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "10";
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            Log.d("ksj","onPostExecute : " + str);
            dialog.dismiss();
        }
    }
}
