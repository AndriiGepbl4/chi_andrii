package andrii_gepbl4.testproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainScreen extends AppCompatActivity {

    TextView tvPreviousStart;
    TextView tvThisStart;

    SharedPreferences sPref;
    final String PREV_DATA = "previous_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        tvPreviousStart = (TextView)findViewById(R.id.tvPreviousStart);
        tvThisStart = (TextView)findViewById(R.id.tvThisStart);

        setViews();
    }

    private void setViews(){
        tvPreviousStart.setText("I've got it from shared preference " + loadText());
        tvThisStart.setText("this time app started at " + getTime());
        saveText();
    }

    private String getTime(){
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return "" + hour + ":" + minute + ":" + second;
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(PREV_DATA, tvThisStart.getText().toString());
        ed.commit();
    }

    private String loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(PREV_DATA, "");

        return savedText;
    }


}
