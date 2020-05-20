package com.smit.tracertcovid_19;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class bookapointmentDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Are you experiencing any of the following:");
        builder.setMessage("• Severe difficulty breathing\n" +
                "• Severe chest pain\n" +
                "• Having a very hard time waking up\n" +
                "• Feeling confused\n" +
                "• Losing consciousness");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity().getApplication(), "Please call 911 or go directly to your nearest emergency department.", Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity().getApplication(), "These symptoms require immediate attention. You should call 911 immediately, or go directly to your nearest emergency department.", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity().getApplication(), "Please stay at home as much as possible and follow any local public health emergency requirements.", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }


}
