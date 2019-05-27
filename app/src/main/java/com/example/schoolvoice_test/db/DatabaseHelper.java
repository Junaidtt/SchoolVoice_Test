package com.example.schoolvoice_test.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolvoice_test.model.Actions;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "information.db";
    private static final int DB_VERSION = 1;
    private Dao<Actions, Integer> actionsDao;
    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {

            TableUtils.createTable(connectionSource, Actions.class);

        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {

            TableUtils.dropTable(connectionSource, Actions.class,true);

        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        onCreate(database, connectionSource);
    }




    public Dao<Actions, Integer> getInformationDao() throws SQLException,
            java.sql.SQLException {
        if (actionsDao == null) {
            actionsDao = getDao(Actions.class);
        }
        return actionsDao;
    }

}
