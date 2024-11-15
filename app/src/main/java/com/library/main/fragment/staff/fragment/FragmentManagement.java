package com.library.main.fragment.staff.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.library.R;
import com.library.intent.IntentBorrowForm;
import com.library.intent.IntentFineForm;
import com.library.intent.IntentImportForm;
import com.library.intent.IntentSellForm;
import com.library.main.fragment.staff.adapter.RecyclerHomeAdapter;
import com.library.utilities.HomeItemDecoration;

public class FragmentManagement extends Fragment implements RecyclerHomeAdapter.OnItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = requireContext();
        // GET RESOURCE.
        String[] titles = context.getResources().getStringArray(R.array.menu_02_titles);
        TypedArray imageIDs = context.getResources().obtainTypedArray(R.array.menu_02_images);
        int[] images = new int[imageIDs.length()];
        for (int i = 0; i < imageIDs.length(); i++) {
            images[i] = imageIDs.getResourceId(i, -1);
        }
        imageIDs.recycle();

        RecyclerView rvDisplay = view.findViewById(R.id.MainPage);
        rvDisplay.addItemDecoration(new HomeItemDecoration());
        rvDisplay.setLayoutManager(new GridLayoutManager(context, 2));
        rvDisplay.setAdapter(new RecyclerHomeAdapter(titles, images, this));
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getContext(), IntentBorrowForm.class));
                break;
            case 1:
                startActivity(new Intent(getContext(), IntentFineForm.class));
                break;
            case 2:
                startActivity(new Intent(getContext(), IntentImportForm.class));
                break;
            case 3:
                startActivity(new Intent(getContext(), IntentSellForm.class));
                break;
        }
    }
}
