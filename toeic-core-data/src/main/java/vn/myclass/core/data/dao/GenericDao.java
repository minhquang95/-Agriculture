package vn.myclass.core.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 5/7/2017.
 */
public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
    T Update(T entity);
    void Save (T entity);
    T FindID(ID var1);
     Object [] findProperty (Map<String,Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
     Integer Delete(List<ID> ids);

}
