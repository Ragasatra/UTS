package ranggasaputra.uts.Presnter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import ranggasaputra.uts.MainActivity;
import ranggasaputra.uts.R;

public class MainSlider extends Activity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider_main);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
    }

    public void SKIP (View view){
        Intent intent = new Intent(MainSlider.this, MainActivity.class);
        startActivity(intent);


    }
}
