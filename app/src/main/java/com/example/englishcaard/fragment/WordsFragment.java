package com.example.englishcaard.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.englishcaard.App;
import com.example.englishcaard.base.BaseFragment;
import com.example.englishcaard.databinding.FragmentWordsBinding;
import com.example.englishcaard.network.model.Hits;
import com.example.englishcaard.network.model.PixabayResponse;
import com.example.englishcaard.ui.adapter.AdapterWords;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    private AdapterWords adapterWords;

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterWords = new AdapterWords();
        initListeners();

    }

    private void initListeners() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.fffff.getText().toString();
                App.retrofitClient.providePixabayApi().getImages("25680573-99ab4b0392ec7236ffaa0c266", text).enqueue(new Callback<PixabayResponse>() {
                    @Override
                    public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                        adapterWords.setList((ArrayList<Hits>) response.body().getHits());
                        binding.recyclerWords.setAdapter(adapterWords);


                    }

                    @Override
                    public void onFailure(Call<PixabayResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "nope", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }




}
