package com.javaschool.ev.dao.api;
import java.util.List;


public interface AbstractDAO <E,ID> {

    E findById(ID id);

    List<E> getAll();

    E save(E entity);

    E update (E entity);

    E delete (E entity);

    E deleteById (ID entityId);

}
