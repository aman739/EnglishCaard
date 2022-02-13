package com.example.englishcaard.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.View;

import com.example.englishcaard.App;
import com.example.englishcaard.R;
import com.example.englishcaard.base.BaseFragment;
import com.example.englishcaard.databinding.FragmentWordsBinding;
import com.example.englishcaard.network.model.PixabayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textView232.setOnClickListener(view1 -> Navigation.findNavController(requireView()).navigate(R.id.categoryFragment));
        getImages();
    }

    private void getImages() {
        App.retrofitClient.providePixabayApi().getImages("25680573-99ab4b0392ec7236ffaa0c266",
                "flower").enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()){
                    Log.e("ololo", ""+response.body());

                }
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Log.e("ololo", t.getMessage());
            }
        });
    }
}
