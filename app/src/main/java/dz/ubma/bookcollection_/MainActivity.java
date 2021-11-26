package dz.ubma.bookcollection_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import dz.ubma.bookcollection_.fragments.home_fragment;
import dz.ubma.bookcollection_.recycler.home_fragment2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl,new home_fragment2());
        ft.addToBackStack(null);
        ft.commit();
    }
}