package andrii_gepbl4.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    private TextView tvDateList;
    private String post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_screen);

        tvDateList = (TextView)findViewById(R.id.tvDateList);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            post = extras.getString("list_data");
            //The key argument here must match that used in the other activity
        }

        tvDateList.setText(post);
    }


}
