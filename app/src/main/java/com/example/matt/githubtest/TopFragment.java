package com.example.matt.githubtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopFragment extends Fragment {

    private EditText topText;
    private EditText bottomText;
    TopFragmentListener activityCommander;

    public interface TopFragmentListener {
        void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCommander = (TopFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.top_fragment, container, false);

       topText = view.findViewById(R.id.topTextInput);
       bottomText = view.findViewById(R.id.bottomTextInput);
       final Button button = view.findViewById(R.id.button);

       button.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       buttonClicked(v);
                   }
               }
       );

        return view;
    }

    public void buttonClicked(View view) {
        activityCommander.createMeme(topText.getText().toString(), bottomText.getText().toString());
    }
}
