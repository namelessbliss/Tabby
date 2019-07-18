package com.app.nb.tabby.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.nb.tabby.R;
import com.app.nb.tabby.adapter.ViewPagerAdapter;
import com.app.nb.tabby.fragment.PersonListFragment;
import com.app.nb.tabby.interfaces.OnPersonCreated;
import com.app.nb.tabby.model.Person;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    //indice de posicion del los fragments
    public static final int PERSON_FORM_FRAGMENT = 0;
    public static final int PERSON_LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
    }

    private void setToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout() {
        //Estabece tabs necesarias
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Formulario"));
        tabLayout.addTab(tabLayout.newTab().setText("Lista"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setViewPager() {
        // Establece adaptador del ViewPager
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), 2);

        viewPager.setAdapter(adapter);
        //Cuando agamos un cambio de pagina
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout(final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, "Seleccionado" + tab.getText(), Toast.LENGTH_SHORT).show();
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, "No seleccionado " + tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, "Reseleccionado " + tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void createdPerson(Person person) {
        //Obtenemos el ListFragment, pasamos el indice de posicion del mismo
        PersonListFragment fragment = (PersonListFragment) getSupportFragmentManager().getFragments().get(PERSON_LIST_FRAGMENT);
        // Llamada al metodo addPerson del fragment
        fragment.addPerson(person);
        //Mueve viewPager hacie el listFragment
        viewPager.setCurrentItem(PERSON_LIST_FRAGMENT);
    }
}
