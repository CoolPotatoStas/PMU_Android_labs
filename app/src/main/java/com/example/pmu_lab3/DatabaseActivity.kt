package com.example.pmu_lab3

import android.annotation.SuppressLint
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.util.Log
import androidx.navigation.ui.AppBarConfiguration


class DatabaseActivity : AppCompatActivity() {

    private val appBarConfiguration: AppBarConfiguration? = null
    val txtData = "123445"
    private val nHandler: Handler = Handler()

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val mydb = MyDatabase(this)
        val sqdb: SQLiteDatabase = mydb.getWritableDatabase()
        val insertQuery = "INSERT INTO " +
                MyDatabase.TABLE_NAME + " (" + MyDatabase.UNAME + ") VALUES ('" +
                txtData + "')"
        sqdb.execSQL(insertQuery)
        val cursor: Cursor = sqdb.query(
            MyDatabase.TABLE_NAME, arrayOf(
                MyDatabase.UID, MyDatabase.UNAME
            ),
            null,
            null,
            null,
            null,
            null
        )
        while (cursor.moveToNext()) {
            val id: Int = cursor.getInt(cursor.getColumnIndex(MyDatabase.UID))
            val name: String = cursor.getString(cursor.getColumnIndex(MyDatabase.UNAME))
            Log.i("LOG_TAG", "ROW" + id + "HAS UNAME" + name)
        }
        cursor.close()
        sqdb.close()
        mydb.close()
    }

}