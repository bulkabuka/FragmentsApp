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

public class SecondFragment extends Fragment {
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    public interface SecondFragmentReceiver {
        void secondReceive(String data);
    }

    private SecondFragmentReceiver secondReceiver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        receiveData = view.findViewById(R.id.second_data);
        dataToSend = view.findViewById(R.id.second_text);
        sendData = view.findViewById(R.id.second_post);

        sendData.setOnClickListener(v -> {
            if (secondReceiver != null) {
                String data = dataToSend.getText().toString();
                assert secondReceiver != null;
                secondReceiver.secondReceive(data);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SecondFragmentReceiver) {
            secondReceiver = (SecondFragmentReceiver) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        secondReceiver = null;
    }

    public void dataReceived(String data) {
        receiveData.setText(data);
    }
}