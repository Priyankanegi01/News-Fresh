package com.priyanka.newsfresh.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.priyanka.newsfresh.POJO.ModelClass;
import com.priyanka.newsfresh.POJO.mainNews;
import com.priyanka.newsfresh.R;
import com.priyanka.newsfresh.Utils.ApiUtilities;
import com.priyanka.newsfresh.Utils.Config;
import com.priyanka.newsfresh.adapter.NewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainentFragment extends Fragment {
    ArrayList<ModelClass> modelClassArrayList;
    NewsAdapter newsAdapter;
    String country="in";
    private RecyclerView recyclerView;
    private String category="entertainment";
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_enetertainment,null);
        recyclerView=view.findViewById(R.id.enetertainment_recyclerView);
        modelClassArrayList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter=new NewsAdapter(getContext(),modelClassArrayList);
        recyclerView.setAdapter(newsAdapter);
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100, Config.api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {
                Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


