package com.beyond.imakeup;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class HomeFragment extends Fragment {

    private GridView grid ;
   View v;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("iMakeup");

        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

          v=inflater.inflate(R.layout.fragment_home, container, false);


        grid =v.findViewById(R.id.grid_home);

        String [] arr={"ميكاب ارتست","صالونات","فساتين","نصائح"};
        grid.setAdapter(new CustomGrid(getActivity(),R.layout.home_grid,arr));


        return v;
    }
}
