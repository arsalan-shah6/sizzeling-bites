package com.app.sizzlingbites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OnBoardingFragment3 extends Fragment {
    Button button;
    public OnBoardingFragment3(){}

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view2= (ViewGroup) inflater.inflate( R.layout.fragment_on_boarding_3,container,false );
        button=view2.findViewById( R.id.letsgo );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getActivity(),DashboardActivity.class) );
            }
        } );
        return view2;
    }
}
