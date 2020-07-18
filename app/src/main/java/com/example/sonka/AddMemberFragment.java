package com.example.sonka;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AddMemberFragment extends Fragment {

    private Button button;
    private EditText editText;
    private Spinner spinner;
    private FragmentAddNameListener listener;
    MyDatabaseHelper myDatabaseHelper;

    public interface FragmentAddNameListener{
        void addMemberDb (CharSequence addName);
        void addRoleDb (CharSequence addRole);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_member, container, false);

        button = view.findViewById(R.id.btn_addMember);
        editText = view.findViewById(R.id.et_AddMember);
        spinner = view.findViewById(R.id.sp_addRole);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence addName = editText.getText();
                CharSequence addRole = spinner.getSelectedItem().toString();
                listener.addMemberDb(addName);
                listener.addRoleDb(addRole);
            }
        });

        return view;
    }

    public void insertMemberToDb (CharSequence newMember){
        myDatabaseHelper.insertMember(editText.getText().toString(), spinner.getSelectedItem().toString());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAddNameListener){
            listener = (FragmentAddNameListener) context;
        }else {
            throw  new RuntimeException(context.toString()+"Implement FragmentAddNameListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}