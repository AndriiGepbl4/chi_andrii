package andrii_gepbl4.testproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class SplashScreen extends AppCompatActivity {

    ImageView ivCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ivCat = (ImageView) findViewById(R.id.ivCat);

    }

    @Override
    protected void onResume() {
        super.onResume();

        MyThread myThread = new MyThread();
        myThread.execute();
    }

    private class MyThread extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ivCat.setBackgroundResource(R.drawable.cat);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Intent intent = new Intent(SplashScreen.this, MainScreen.class);
            startActivity(intent);
        }
    }
}



