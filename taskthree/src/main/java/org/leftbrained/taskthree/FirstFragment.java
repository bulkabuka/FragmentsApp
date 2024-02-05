package org.leftbrained.taskthree;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    public interface FirstFragmentReceiver {
        void firstReceive(String data);
    }

    private FirstFragmentReceiver firstReceiver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        receiveData = view.findViewById(R.id.first_data);
        dataToSend = view.findViewById(R.id.first_text);
        sendData = view.findViewById(R.id.first_post);

        sendData.setOnClickListener(v -> {
            if (firstReceiver != null) {
                String data = dataToSend.getText().toString();
                assert firstReceiver != null;
                firstReceiver.firstReceive(data);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentReceiver) {
            firstReceiver = (FirstFragmentReceiver) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        firstReceiver = null;
    }

    public void dataReceived(String data) {
        receiveData.setText(data);
    }
}