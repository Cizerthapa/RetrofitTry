package com.cizer.tryretrofit;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cizer.tryretrofit.utilities.ApiClient;

import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Contactfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Contactfrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etName, etMail, etDesc;

    Button clickSend;
    
    Retrofit apiService;

    public Contactfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Contactfrag.
     */
    // TODO: Rename and change types and number of parameters
    public static Contactfrag newInstance(String param1, String param2) {
        Contactfrag fragment = new Contactfrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contactfrag, container, false);

        // Initialize EditText and Button
        etName = view.findViewById(R.id.etName);
        etMail = view.findViewById(R.id.etMail);
        etDesc = view.findViewById(R.id.etDesc);
        clickSend = view.findViewById(R.id.submitBtn);

        // Set onClickListener for the Button
        clickSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve values from EditText fields
                String name = etName.getText().toString().trim();
                String email = etMail.getText().toString().trim();
                String message = etDesc.getText().toString().trim();

                // Do something with the retrieved values, such as validation or processing

                // For example, you can log the values
                Log.d("EditTextValues", "Name: " + name);
                Log.d("EditTextValues", "Email: " + email);
                Log.d("EditTextValues", "Message: " + message);

                // Create an instance of ApiClient
                ApiClient apiClient = new ApiClient();

                // Call the sendMessage method on the ApiClient instance
                apiClient.sendMessage(name, email, message, getContext());

            }
        });
        return view;
    }
}