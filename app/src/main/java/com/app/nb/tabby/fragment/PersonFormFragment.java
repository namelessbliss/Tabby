package com.app.nb.tabby.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.app.nb.tabby.R;
import com.app.nb.tabby.interfaces.OnPersonCreated;
import com.app.nb.tabby.model.Country;
import com.app.nb.tabby.model.Person;
import com.app.nb.tabby.utils.Utils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFormFragment extends Fragment {

    private EditText etName;
    private Spinner spinnerCountry;
    private Button btnCreate;

    private List<Country> countries;

    private OnPersonCreated onPersonCreated;


    public PersonFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person_form, container, false);

        etName = view.findViewById(R.id.etName);
        spinnerCountry = view.findViewById(R.id.spinnerCountry);
        btnCreate = view.findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewPerson();
            }
        });

        countries = Utils.getCountries();

        ArrayAdapter<Country> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);


        return view;
    }

    private void createNewPerson() {
        if (!etName.getText().toString().isEmpty()) {
            Country country = (Country) spinnerCountry.getSelectedItem();
            Person person = new Person(etName.getText().toString(), country);

            onPersonCreated.createdPerson(person);
        }
    }

    //Evento para enlazar el listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPersonCreated) {
            onPersonCreated = (OnPersonCreated) context;
        } else {
            throw new RuntimeException(context.toString() + " debe implementar OnPersonCreated");
        }
    }


    //Evento para desenlzar el listener
    @Override
    public void onDetach() {
        super.onDetach();
        onPersonCreated = null;
    }
}
