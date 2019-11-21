/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.model.db;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bm3302
 */
public interface IDataManager {
    public Integer save(Object obj);
    public void delete(Object obj);
    public void update(Object obj);
    public Object findById(Class classType, Serializable id);
    public List<Object> find (Class classType, Map<String,Object> fieldValueMap);
    
}
