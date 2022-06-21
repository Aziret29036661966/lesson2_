package com.example.myapplication.network.fragment.first;

import static com.example.myapplication.network.fragment.first.FirstFragment.F;
import static com.example.myapplication.network.fragment.first.FirstFragment.GO;
import static com.example.myapplication.network.fragment.first.FirstFragment.S;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFirstBinding;
import com.example.myapplication.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getParentFragmentManager().setFragmentResultListener(
                FirstFragment.RESULT_HOME_KEY,
                getViewLifecycleOwner(),
                (requestKey, result) -> {
                    String text = result.getString(F);
                    String text2 = result.getString(S);
                    String textR = result.getString(GO);
                    binding.txtRNames.setText(textR);
                    binding.txtFName.setText(text);
                    binding.txtSName.setText(text2);
                });
    }

}