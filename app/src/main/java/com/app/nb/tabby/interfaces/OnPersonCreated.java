package com.app.nb.tabby.interfaces;

import com.app.nb.tabby.model.Person;

public interface OnPersonCreated {

    //Interfaz definida en fichero aparte para la comunicacion entre el Formulario y la Lista a traves
    // del MainActivity
    void createdPerson(Person person);
}
