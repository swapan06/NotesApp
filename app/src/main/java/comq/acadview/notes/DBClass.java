package comq.acadview.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {
    public DBClass(Context context) {
        super(context,"USERDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NOTES(Title  text,Type text) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int Title, int Type) {
        db.execSQL("DROP TABLE IF EXISTS NOTES");
        onCreate(db);

    }
    public void addData(String title_r,String type_r)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title",title_r);
        contentValues.put("Type",type_r);


        SQLiteDatabase db=getWritableDatabase();
        db.insert("NOTES",null,contentValues);

    }
    public Cursor getData()
    {
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.query("NOTES",null,null,null,null,null,null);
        return cursor;
    }
    void onUpdate(String title,String content) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("Title",title);
        cv.put("Type",content);
        String arr[] = {};

        sqLiteDatabase.update("NOTES",cv,"Title = ?  AND Type = ?",arr);

    }

    void onDelete(String title) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String arr[] = {title};
        sqLiteDatabase.delete("NOTES","Title = ?",arr);

    }
}

