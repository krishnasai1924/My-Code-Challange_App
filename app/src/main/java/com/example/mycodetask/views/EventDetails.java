package com.example.mycodetask.views;

import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.mycodetask.interfaces.EventMainInterface;
import com.example.mycodetask.modelclasses.Event;
import com.example.mycodetask.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
//created by krishna...17/08/2021
public class EventDetails  extends DaggerAppCompatActivity implements EventMainInterface.view {
String eventId;
    @Inject
    EventMainInterface.presenter presenter;
    TextView title,location,eventDate;
    ImageView eventImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        intviews();

    }
    public void intviews(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        title=findViewById(R.id.eventTitle);
        location=findViewById(R.id.eventLocation);
        eventDate=findViewById(R.id.eventDate);
        eventImage= findViewById(R.id.eventImage);

        setSupportActionBar(toolbar);
        toolbar.setTitle("Notifications");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        Intent intent = getIntent();

        eventId = intent.getStringExtra("eventId");
        presenter.getEventData(eventId);

        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();

        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void loadEventData(Event event) {
        title.setText(event.getTitle());
        location.setText(event.getVenue().getDisplayLocation());
        Picasso.with(this)
                .load(event.getPerformers().get(0).getImages().getHuge())
                .resize(300,300)
                .into(eventImage);

        DateFormat dateFormat = null;
        String timeStampST = event.getAnnounceDate();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        }
        Date date = null;//You will get date object relative to server/client timezone wherever it is parsed
        try {
            assert dateFormat != null;
            date = dateFormat.parse(timeStampST);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm a"); //If you need time just put specific format for time like 'HH:mm:ss'
        assert date != null;
        String dateStr = formatter.format(date);
        System.out.println("date:"+ dateStr);
        eventDate.setText(dateStr);
    }
}