

package com.edu.myfacerecognizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // show the screen (our splash image)
        setContentView(R.layout.splash);

        // setup handler to close the splash screen
        Handler x = new Handler();
        x.postDelayed(new splashhandler(), 3000);
    }

    class splashhandler implements Runnable {

        public void run() {

            // start new activity
            startActivity(new Intent(getApplication(), login.class));
            // close out this activity
            finish();

        }
    }
}
