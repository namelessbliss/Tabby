package com.app.nb.tabby.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.nb.tabby.R;
import com.app.nb.tabby.adapter.PersonAdapter;
import com.app.nb.tabby.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonListFragment extends Fragment {

    private List<Person> people;
    private ListView listView;
    private PersonAdapter adapter;


    public PersonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);

        people = new ArrayList<>();
        listView = view.findViewById(R.id.listViewPerson);
        adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, people);
        listView.setAdapter(adapter);

        return view;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        adapter.notifyDataSetChanged();
    }

}
