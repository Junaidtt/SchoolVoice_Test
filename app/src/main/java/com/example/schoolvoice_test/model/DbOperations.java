package com.example.schoolvoice_test.model;

import android.content.Context;

import com.example.schoolvoice_test.db.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class DbOperations {

    DatabaseHelper databaseHelper = null;
    private Dao<Actions, Integer> actionsDoa;


    // fetch liked views from Action table
    public  List<Actions>getLikesData(Context context){
         List<Actions> actionList = null;
        try {
            actionsDoa = getHelper(context).getInformationDao();
            actionList = actionsDoa.query(actionsDoa.queryBuilder().where().eq("isLiked",true).prepare());

        }catch (java.sql.SQLException e){

            e.printStackTrace();
        }

        return  actionList;
    }

    // fetch views from action table
    public List<Actions> getViewsList(Context context){
        List<Actions> actionList = null;
        try {

            actionsDoa = getHelper(context).getInformationDao();
            actionList =  actionsDoa.queryForAll();

        }catch (java.sql.SQLException e){

            e.printStackTrace();
        }

        return actionList;
    }

    // get views count
    public int getViewsCount(Context context){
        List<Actions> actionList = null;
        int count = 0;
        try {
            actionsDoa = getHelper(context).getInformationDao();
            actionList =  actionsDoa.queryForAll();

        }catch (java.sql.SQLException e) {

            e.printStackTrace();
        }
        return actionList.size();
    }

    // get likes count
    public int getLikesCount(Context context){
        List<Actions> actionList = null;
        int count = 0;
        try {
            actionsDoa = getHelper(context).getInformationDao();
            actionList =  actionsDoa.query(actionsDoa.queryBuilder().where().eq("isLiked",true).prepare());

        }catch (java.sql.SQLException e) {

            e.printStackTrace();
        }
        return actionList.size();
    }



    public void prepareData(Context context){

        final Actions actions1 = new Actions();
        actions1.image = "http://www.gstatic.com/tv/thumb/persons/983712/983712_v9_ba.jpg";
        actions1.name = "L Messi";
        actions1.isLiked = false;
        actions1.time = "3 m";

        final Actions actions2 = new Actions();
        actions2.image = "http://www.gstatic.com/tv/thumb/persons/673351/673351_v9_ba.jpg";
        actions2.name = "C Ronoldo";
        actions2.isLiked = true;
        actions2.time = "2 m";

        final Actions actions3 = new Actions();
        actions3.image = "https://pbs.twimg.com/media/DiaNjZrXUAE-K4r.jpg";
        actions3.name = "K Mbape";
        actions3.isLiked = false;
        actions3.time = "6 m";

        final Actions actions4 = new Actions();
        actions4.image = "https://scd.france24.com/en/files/imagecache/home_1024/images/afp/204e187999be8c358bf21e6a64aaf1f2cd222beb.jpg";
        actions4.name = "Neymer Jr";
        actions4.isLiked = true;
        actions4.time = "9 m";

        final Actions actions5 = new Actions();
        actions5.image = "https://gmsrp.cachefly.net/images/18/05/23/634fce6feff2e2aebd69d20af7e65a4e/960.jpg";
        actions5.name = "M Sale";
        actions5.isLiked = false;
        actions5.time = "1 m";

        final Actions actions6 = new Actions();
        actions6.image = "https://ronaldo.com/wp-content/uploads/2019/03/GettyImages-1136231477-696x483.jpg";
        actions6.name = "A Greizzmenn";
        actions6.isLiked = true;
        actions6.time = "1 m";



        try {
            final Dao<Actions, Integer> informationDao = getHelper(context).getInformationDao();
            informationDao.create(actions1);
            informationDao.create(actions2);
            informationDao.create(actions3);
            informationDao.create(actions4);
            informationDao.create(actions5);
            informationDao.create(actions6);


        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
    }

    // Check for empty table or not
    public boolean isEmptyData(Context context) throws android.database.SQLException {
        boolean isEmpty = true;
        List<Actions> actions = null;
        final Dao<Actions, Integer> informationDao;
        try {
            informationDao = getHelper(context).getInformationDao();
            actions = informationDao.queryForAll();

            if (actions.size() > 0){
                isEmpty = false;
            }else {
                isEmpty = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isEmpty;
    }


    // function to handle release On Destroy method
    public void releaseDb(){

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }



    private DatabaseHelper getHelper(Context context) {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}
