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
    final String LIST_DATA = "list_of_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        tvPreviousStart = (TextView)findViewById(R.id.tvPreviousStart);
        tvThisStart = (TextView)findViewById(R.id.tvThisStart);

        setViews();
    }

    private void setViews(){
        tvPreviousStart.setText(loadText());
        tvThisStart.setText(getTime());
        saveText();
    }

    private String getTime(){
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return "" + hour + ":" + minute + ":" + second;
    }

    private String listOfTime(){
        String timeList = "";

        return timeList;
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(PREV_DATA, getTime());
        ed.putString(LIST_DATA, loadText() + "/n" + getTime()  );
        ed.commit();
    }

    private String loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(PREV_DATA, "");

        return savedText;
    }


}
