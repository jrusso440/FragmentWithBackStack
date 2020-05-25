package com.example.fragmentwithbackstack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFrag1WithoutBack, btnFrag2WithoutBack, btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrag1WithoutBack = (Button) findViewById(R.id.btnfr1without);
        btnFrag2WithoutBack = (Button) findViewById(R.id.btnfr2without);
        btnback = (Button) findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BackStackActivity.class);
                startActivity(intent);
            }
        });

        btnFrag1WithoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new OneFragment(), false, "one");
            }
        });

        btnFrag2WithoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new TwoFragment(), false, "two");
            }
        });

    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_frame, fragment, tag);
        ft.commitAllowingStateLoss();
    }

}