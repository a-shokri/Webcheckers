package com.webcheckers.model.db;

public class DBManagerFactory {
    static IDataManager dataManager = null;
    public static IDataManager getDataManager(){
        if( dataManager == null )
            dataManager = new DBManager();
        return dataManager;
    }
}
