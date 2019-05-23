package ranggasaputra.uts.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import ranggasaputra.uts.Model.FriendFragment;
import ranggasaputra.uts.Model.KontakFragment;
import ranggasaputra.uts.Model.ProfileFragment;
import ranggasaputra.uts.R;

public class Bottom_navigation extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        loadFragment(new ProfileFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    public void BukaWhatsapp (View view){
       String url ="https://api.whatsapp.com/send?";
        Intent BukaWhatsapp = new Intent(Intent.ACTION_VIEW);
        BukaWhatsapp.setData(Uri.parse((url)));
        startActivity(BukaWhatsapp);


        }

    public void BukaGmail (View view){
        String url ="mailto:cpion25@gmail.com";
        Intent BukaGmail = new Intent(Intent.ACTION_VIEW);
        BukaGmail.setData(Uri.parse((url)));
        startActivity(BukaGmail);


    }

    public void BukaInstagram (View view){
        String url ="https://www.instagram/com/ragasatra02";
        Intent BukaInstagram = new Intent(Intent.ACTION_VIEW);
        BukaInstagram.setData(Uri.parse((url)));
        startActivity(BukaInstagram);


    }




    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;

            case R.id.navigation_kontak:
                fragment = new KontakFragment();
                break;

            case R.id.navigation_friend:
                fragment = new FriendFragment();
                break;

        }

        return loadFragment(fragment);

    }
}
