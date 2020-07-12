package com.example.sonka;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AddMemberFragment extends Fragment {

    private onFragAddMemberBtn listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_member, container, false);

        Button btn_addMemeber = view.findViewById(R.id.btn_addMember);
        btn_addMemeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.addMemberBtn();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onFragAddMemberBtn) {
            listener = (onFragAddMemberBtn) context;
        }else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }


    }

    public interface onFragAddMemberBtn{
        public void addMemberBtn();
    }

}