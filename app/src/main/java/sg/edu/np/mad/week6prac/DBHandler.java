package sg.edu.np.mad.week6prac;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION =1;
    public static String DATABASE_NAME="user.db";
    public static String USER="User";
    public static String COLUMN_NAME="Name";
    public static String COLUMN_DESCRIPTION="Description";
    public static String COLUMN_ID="ID";

    public static String COLUMN_FOLLOWED="Followed";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CRETE_ACCOUNTS_TABLE="CREATE TABLE "+USER+"("+COLUMN_NAME+" TEXT,"+COLUMN_DESCRIPTION+" TEXT,"+COLUMN_ID+" TEXT,"+COLUMN_FOLLOWED+" TEXT)";
        db.execSQL(CRETE_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+USER);
        onCreate(db);

    }

    public void addUser(User user){
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,user.getName());
        values.put(COLUMN_DESCRIPTION,user.getDescription());
        values.put(COLUMN_ID,user.getId());
        values.put(COLUMN_FOLLOWED,user.isFollowed());


        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(USER,null,values);
        db.close();
    }

    public List<User> getUsers(){
        String query="SELECT * FROM "+USER;
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(!cursor.moveToFirst()){
            return null;
        }
        do{
            User queryResult=new User();
            queryResult.setName(cursor.getString(0));
            queryResult.setDescription(cursor.getString(1));
            queryResult.setId(cursor.getInt(1));
            int value=cursor.getInt(5);
            boolean result = (value == 1) ? true : false;
            queryResult.setFollowed(result);


            users.add(queryResult);

        }
        while (cursor.moveToNext());
        cursor.close();
        db.close();
        return users;
    }


    public void updateUser(User user) {
        String query;
        //check if hotel is saved (if true, update database to false)
        if(user.isFollowed())
        {
            query="UPDATE " +USER+
                    " SET "+COLUMN_FOLLOWED+" = "+false+
                    " WHERE "+COLUMN_ID+"="+user.getId();
        }
        else{
            query="UPDATE " +USER+
                    " SET "+COLUMN_FOLLOWED+" = "+true+
                    " WHERE "+COLUMN_ID+"="+user.getId();
        }
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(query);
    }

}

