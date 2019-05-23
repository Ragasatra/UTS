package ranggasaputra.uts.view;
/**
 * Created by Rangga on 19/05/2019.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import ranggasaputra.uts.Presnter.MainSlider;
import ranggasaputra.uts.R;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splash = new Thread(){
            public void run (){
            try
            {
                sleep(3500);
            }
            catch (InterruptedException a)
            {
                a.printStackTrace();
            }
            finally {
                startActivity(new Intent(SplashScreen.this,MainSlider.class));
                finish();
            }
            }
        };
        splash.start();
    }
}
