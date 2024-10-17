package com.example.yagodelimafranca;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.yagodelimafranca.R;

public class    MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.mydialog,null);

        Button buttonSim = v.findViewById(R.id.buttonSim);
        buttonSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), MainActivity.class);
                startActivity(it);
                dismiss();
            }
        });
        Button buttonNao = v.findViewById(R.id.buttonNao);
        buttonNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), ActivityOrdemJogada.class);
                startActivity(it);
                dismiss();
            }
        });
        builder.setView(v);
        return builder.create();
    }
}//class
