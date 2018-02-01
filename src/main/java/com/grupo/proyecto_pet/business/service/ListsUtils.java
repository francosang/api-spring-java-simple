package com.grupo.proyecto_pet.business.service;

import java.util.Iterator;
import java.util.List;

public class ListsUtils<T> {

    public void hibernateMerge(List<T> horariosExitentes, List<T> horariosRequest, ItemMerger<T> itemMerger) {
        Iterator<T> existentesIterator = horariosExitentes.iterator();
        while (existentesIterator.hasNext()) {
            T existente = existentesIterator.next();

            boolean remove = true;
            for (T request : horariosRequest){
                boolean isEquals = existente.equals(request);
                if (isEquals) {
                    remove = false;
                    break;
                }
            }

            if (remove) existentesIterator.remove();
        }

        for (T existente : horariosExitentes) {

            Iterator<T> requestIterator = horariosRequest.iterator();
            while (requestIterator.hasNext()) {
                T request = requestIterator.next();

                //verifico si el detalle en la base corresponde al mismo detalle recibido
                if (existente.equals(request)) {
                    itemMerger.merge(existente, request);

                    requestIterator.remove();
                }
            }
        }

        horariosExitentes.addAll(horariosRequest);
    }

    public interface ItemMerger<T> {
        void merge(T existente, T request);
    }

}

