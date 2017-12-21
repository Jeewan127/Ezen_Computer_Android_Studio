package kr.co.ezenac.tbja.sampledev;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AsyncTaskActivity extends AppCompatActivity {
    Button btn_download;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        btn_download = findViewById(R.id.btn_download);

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestTask task = new TestTask();
                task.execute();
            }
        });
    }

    public class TestTask extends AsyncTask<Integer,Integer,Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = ProgressDialog.show(AsyncTaskActivity.this,
                    "Title", "로딩중..", true);

            Log.d("ksj","onPreExecute");
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            Log.d("ksj","doInBackground");

            for (int i = 0 ; i < 3 ; i++) {
                try {
                    Thread.sleep(1000);
                    Log.d("ksj","sleep : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("ksj","onPostExecute");
            dialog.dismiss();
        }
    }
}
