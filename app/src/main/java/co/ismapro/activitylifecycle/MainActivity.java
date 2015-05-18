package co.ismapro.activitylifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //define an external class attribute to keep the textInformation
    TextView messageText;
    StringBuffer logger = new StringBuffer();
    String LOGGER = "LOGGER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            logger.append("Loaded From Saved Instance ->\n"+savedInstanceState.getString(LOGGER));
        }

        // Initialize textView for further manipulation
        messageText = (TextView) findViewById(R.id.text_message);
        logger.append("OnCreate method\n");
        showLogger();
    }

    @Override
    public void onPause() {
        super.onPause(); // Always call the superclass when overriding the methods
        logger.append("OnPause method\n");
        showLogger();
    }

    @Override
    public void onResume() {
        super.onPause(); // Always call the superclass when overriding the methods
        logger.append("OnResume method\n");
        showLogger();
    }

    @Override
    public void onStop() {
        super.onStop(); // ACSO
        logger.append("OnStop method\n");
        showLogger();
    }

    @Override
    public void onStart() {
        super.onStart(); // ACSO
        logger.append("OnStart method\n");
        showLogger();
    }

    @Override
    public void onRestart() {
        super.onRestart(); // ACSO
        logger.append("onRestart method\n");
        showLogger();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig); // Call the method even if it is override

        //check for the orientation change
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            logger.append("Orientation Change Landscape\n");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            logger.append("Orientation Change Portrait\n");
        }

        showLogger();
    }

    @Override
    public void onSaveInstanceState( Bundle savedInstanceState ) {
        super.onSaveInstanceState(savedInstanceState); // ACSO
        logger.append("Saved Instance State\n");
        savedInstanceState.putString(LOGGER, logger.toString());
    }

    /*
    * Utility Methods
    * */

    //show log information in the textview
    public void showLogger() {
        messageText.setText( logger.toString() );
    }

    /*
    * Action Bar Methods
    * */

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
            Intent intent = new Intent(this, CustomActivity.class );
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
