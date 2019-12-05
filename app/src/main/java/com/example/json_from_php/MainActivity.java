package com.example.json_from_php;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    Button bttn_sqlConn;
    TextView textview;
    final String fetch = "http://192.168.1.144:8080/sqli/fetch2json.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.textView);
        bttn_sqlConn= (Button)findViewById(R.id.bttnSQLCon);
        bttn_sqlConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncCall asyncall = new asyncCall();
                String getRet = asyncall.execute(fetch);
                //Log.v("george getRet",getRet);
                try {
                    JSONArray js_array = new JSONArray(getRet);
                    textview.setText(js_array.toString());

                    /* reading the JSON array line by line */
                    for (int i = 0; i < js_array.length(); i++) {
                        String value=js_array.getString(i);
                        Log.v("george json", i+"="+value);
                    }
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }
        });
    }
}
