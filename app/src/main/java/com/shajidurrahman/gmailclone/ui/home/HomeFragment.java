package com.shajidurrahman.gmailclone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shajidurrahman.gmailclone.CustomAdapter;
import com.shajidurrahman.gmailclone.EmailModel;
import com.shajidurrahman.gmailclone.R;
import com.shajidurrahman.gmailclone.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    String[] arr = {"sdfl", "sdfl", "sdfl", "sdfl", "sdfl", "sdfl", "sdfl"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<EmailModel> emailModelArrayList = new ArrayList<>();
        emailModelArrayList.add(new EmailModel("dfds", "How are you shajidur rahman "));
        emailModelArrayList.add(new EmailModel("dfdfdfdsf", "How are you sdlfdsf rahmdfddfdan "));
        emailModelArrayList.add(new EmailModel("fddsf", "How are you dfsderetrerewrwe rahdsfdfdfsdffffdfdman "));
        emailModelArrayList.add(new EmailModel("fd", "How are you dfdsfds dfdsfdsf "));
        emailModelArrayList.add(new EmailModel("dff", "How are you shajidur rahman "));

        CustomAdapter cs = new CustomAdapter(emailModelArrayList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(cs);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}