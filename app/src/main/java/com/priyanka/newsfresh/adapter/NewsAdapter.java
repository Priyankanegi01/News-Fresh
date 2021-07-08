package com.priyanka.newsfresh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.priyanka.newsfresh.POJO.ModelClass;
import com.priyanka.newsfresh.R;
import com.priyanka.newsfresh.WebViewActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass>modelClassArrayList;

    public NewsAdapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NotNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_news_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsAdapter.ViewHolder holder, int position) {
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(context, WebViewActivity.class);
             intent.putExtra("url",modelClassArrayList.get(position).getUrl());
             context.startActivity(intent);
         }
     });
        holder.time.setText("Published At"+modelClassArrayList.get(position).getPublishedAt());
        holder.author.setText(modelClassArrayList.get(position).getTitle());
        holder.heading.setText(modelClassArrayList.get(position).getTitle());
        holder.content.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.main_heading);
            content=itemView.findViewById(R.id.content);
            author=itemView.findViewById(R.id.author);
            time=itemView.findViewById(R.id.time);
            cardView=itemView.findViewById(R.id.cardView);
            imageView=itemView.findViewById(R.id.imgview);

        }
    }
}
