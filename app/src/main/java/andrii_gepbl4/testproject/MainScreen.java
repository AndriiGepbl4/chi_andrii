package andrii_gepbl4.testproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainScreen extends AppCompatActivity {

    private TextView tvPreviousStart;
    private TextView tvThisStart;
    private Button btnHistory;

    SharedPreferences sPref;
    final String PREV_DATA = "previous_data";
    final String LIST_DATA = "list_of_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        tvPreviousStart = (TextView)findViewById(R.id.tvPreviousStart);
        tvThisStart = (TextView)findViewById(R.id.tvThisStart);
        btnHistory = (Button)findViewById(R.id.btnHistory);

        setViews();
        saveTime();
    }

    private void setViews(){
        tvPreviousStart.setText(loadTime());
        tvThisStart.setText(getTime());

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, History.class);
                intent.putExtra("list_data", "" + listOfTime());
                startActivity(intent);
            }
        });
    }

    private String getTime(){
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return "" + hour + " : " + minute + " : " + second;
    }

    private String listOfTime(){
        String timeList = sPref.getString(LIST_DATA, "") + "\n" + loadTime();

        return timeList;
    }

    void saveTime() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(PREV_DATA, getTime());
        ed.putString(LIST_DATA, listOfTime());
        ed.commit();
    }

    private String loadTime() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(PREV_DATA, "");

        return savedText;
    }
}
