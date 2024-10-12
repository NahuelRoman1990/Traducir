package com.example.traducir;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final String[] palabras = {"casa", "conejito", "perro", "gatito", "manzana", "perrito"};
    private final String[] traducciones = {"house", "bunny", "dog", "kitten", "apple", "puppy"};
    private final int[] imagenes = {
            R.drawable.casa,
            R.drawable.conejito,
            R.drawable.dog,
            R.drawable.gatito,
            R.drawable.manzana,
            R.drawable.perrito
    };

    private final MutableLiveData<Palabra> palabraTraducida = new MutableLiveData<>();

    public LiveData<Palabra> getPalabraTraducida() {
        return palabraTraducida;
    }

    public void translateWord(String palabra) {
        String palabraLower = palabra.trim().toLowerCase();
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(palabraLower)) {

                palabraTraducida.setValue(new Palabra(traducciones[i], imagenes[i]));
                return;
            }
        }

        palabraTraducida.setValue(new Palabra("No se puede traducir", R.drawable.defaulf));
    }
}
