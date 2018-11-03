package com.learning.manojkumar.resume;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.learning.manojkumar.resume.controller.SectionsPagerAdapter;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView call, email, pdfOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = (TextView)findViewById(R.id.call);
        email = (TextView)findViewById(R.id.email);
        pdfOnline = (TextView)findViewById(R.id.pdf);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+"970-443-9251"));
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Intent.ACTION_VIEW));
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, "manojkumarsmks@gmail.com");
                startActivity(intent);
            }
        });

        pdfOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://drive.google.com/file/d/1khoL-WKrDZ156Hoo38D2dyaMtUPYP-p2/view?usp=sharing"));
                startActivity(browserIntent);
            }
        });



        // Set the viewpager
        viewPager = findViewById(R.id.viewpager);

        //Create the adapter
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        //Set the adapter
        viewPager.setAdapter(pagerAdapter);

        // Initialize TabLayout
        tabLayout = findViewById(R.id.tabLayout);

        // Give TabLayout the ViewPager
        tabLayout.setupWithViewPager( viewPager);

    }
}
