package com.tahirferli.loremipsum.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;

import com.tahirferli.loremipsum.LoremApp;
import com.tahirferli.loremipsum.R;
import com.tahirferli.loremipsum.adapters.PicsumAdapter;
import com.tahirferli.loremipsum.dagger.LoremComponent;
import com.tahirferli.loremipsum.databinding.FragmentMainBinding;
import com.tahirferli.loremipsum.model.Picsum;
import com.tahirferli.loremipsum.repos.PicsumRepo;

import java.util.List;

import javax.inject.Inject;

public class MainFragment extends Fragment {

    @Inject
    PicsumRepo picsumRepo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,
                container, false);

        MainActivity activity = (MainActivity) getActivity();
        LoremApp app = (LoremApp) activity.getApplication();
        LoremComponent component = app.getComponent();
        component.inject(this);

        PicsumAdapter adapter = getAdapter();
        binding.picsumRv.setAdapter(adapter);

        picsumRepo.getPicsumLiveData().observe(requireActivity(), new Observer<List<Picsum>>() {
            @Override
            public void onChanged(List<Picsum> picsums) {
                adapter.submitList(picsums);
            }
        });

        return binding.getRoot();
    }

    private PicsumAdapter getAdapter() {
        return new PicsumAdapter(new DiffUtil.ItemCallback<Picsum>() {
            @Override
            public boolean areItemsTheSame(@NonNull Picsum oldItem, @NonNull Picsum newItem) {
                return oldItem.getPicId().equals(newItem.getPicId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Picsum oldItem, @NonNull Picsum newItem) {
                return oldItem.getPicId().equals(newItem.getPicId());
            }
        });
    }
}
