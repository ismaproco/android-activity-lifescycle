package co.ismapro.activitylifecycle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //define an external class attribute to keep the textInformation
    TextView messageText;
    StringBuffer logger = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize textView for further manipulation
        messageText = (TextView) findViewById(R.id.text_message);
        logger.append("OnCreate method\n");
        messageText.setText( logger.toString() );
    }

    @Override
    public void onPause() {
        super.onPause(); // Always call the superclass when overriding the methods
        logger.append("OnPause method\n");
        messageText.setText( logger.toString() );
    }

    @Override
    public void onResume() {
        super.onPause(); // Always call the superclass when overriding the methods
        logger.append("OnResume method\n");
        messageText.setText( logger.toString() );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
