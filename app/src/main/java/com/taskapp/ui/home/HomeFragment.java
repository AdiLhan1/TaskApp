package com.taskapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.taskapp.R;
import com.taskapp.Task;
import com.taskapp.TaskAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

        private HomeViewModel homeViewModel;
        private RecyclerView recyclerView;
        private List<Task> list = new ArrayList<>();
        private TaskAdapter adapter;

    public Task task;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initList();
    }
    private void initList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter = new TaskAdapter(list);
        adapter.notifyDataSetChanged();
    }

    public void addTask(Task task){
        list.add(task);


    }
}