package andrii_gepbl4.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

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

        ivCat.setBackgroundResource(R.drawable.cat);
        wait(5500);
    }

    private void wait(int waitTime){
        try {
            Thread.sleep(waitTime);
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
