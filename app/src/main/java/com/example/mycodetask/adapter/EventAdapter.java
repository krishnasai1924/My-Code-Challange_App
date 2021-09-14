package com.example.mycodetask.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycodetask.modelclasses.Event;
import com.example.mycodetask.R;
import com.example.mycodetask.views.EventDetails;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    private final List<Event> productList;
    private final Context mContext;
    public EventAdapter(List<Event> productLists, Context context) {
        this.productList = productLists;
        this.mContext=context;
    }

    @NonNull
    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyViewHolder holder, int position) {
        Event list = productList.get(position);


        holder.event_name.setText(list.getTitle());
        holder.event_location.setText(list.getVenue().getDisplayLocation());
        Picasso.with(mContext)
                .load(list.getPerformers().get(0).getImages().getHuge())
                .resize(250,250)
                .into(holder.event_image);

        holder.linearLayout.setOnClickListener(v -> {
            Intent intent= new Intent(mContext, EventDetails.class);
            String id= String.valueOf(list.getId());
            intent.putExtra("eventId",id);
            mContext.startActivity(intent);
        });
        DateFormat dateFormat = null;
        String timeStampST = list.getAnnounceDate();
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
        holder.event_date.setText(dateStr);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_date, event_location,event_name;
        ImageView event_image;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_name =  itemView.findViewById(R.id.event_name);
            event_location =  itemView.findViewById(R.id.event_location);
            event_date = itemView.findViewById(R.id.event_date);
            event_image=itemView.findViewById(R.id.event_image);
            linearLayout=itemView.findViewById(R.id.eventList);
            itemView.setOnClickListener(view -> {
                int itemPosition = getLayoutPosition();
                Log.d("position","position"+itemPosition+++event_name.getText());
            });
        }
    }
}
