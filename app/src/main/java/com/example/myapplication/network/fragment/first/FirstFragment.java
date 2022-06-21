package com.example.myapplication.network.fragment.first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFirstBinding;
import com.example.myapplication.network.LoveModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {
    private NavController controller;
    public static final String KEY = "eb9eb3337cmshc74b181b5972583p1a35c5jsn7ddb1b402dbe";
    public static final String HOST = "love-calculator.p.rapidapi.com";
    public static final String F = "f";
    public static final String S = "s";
    public static final String GO = "go";
    public static final String RESULT_HOME_KEY = "result";
    private FragmentFirstBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater);
        initController();
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnResult.setOnClickListener(v -> {
            result();
            closeFragment();
        });
    }

    private void result() {
        String first = binding.edFirstName.getText().toString().trim();
        String second = binding.edSecondName.getText().toString().trim();
        App.loveAPI.loveCall(first, second, KEY, HOST).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()){
                    String first = binding.edFirstName.getText().toString().trim();
                    String second = binding.edSecondName.getText().toString().trim();
                    Bundle bundle = new Bundle();
                    bundle.putString(F, first);
                    bundle.putString(S, second);
                    bundle.putString(GO, response.body().percentage);
                    getParentFragmentManager().setFragmentResult(RESULT_HOME_KEY, bundle);
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {

            }
        });
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        if (navHostController != null) {
            controller = navHostController.getNavController();

        }

    }

    private void closeFragment() {
        controller.navigate(R.id.secondFragment);
   }
}