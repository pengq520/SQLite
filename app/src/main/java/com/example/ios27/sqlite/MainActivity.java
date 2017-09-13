package com.example.ios27.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //用于创建帮助器对象
    private MyOpenHelper oh;

    //用于创建数据库对象
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //创建数据库
    public void createDatabase(View view) {

        //创建帮助器对象
        oh = new MyOpenHelper(this, "people.db", null, 1);

        //创建数据库对象
        db = oh.getWritableDatabase();
    }

    //向数据库中添加数据
    public void Insert(View view) {

        //向学生表中添加10名学生
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"刘得意", 19, 1001, 60, 98, 75});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"王锐", 20, 1002, 63, 90, 96});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"何煜中", 19, 1003, 90, 73, 82});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"王磊", 21, 1004, 87, 86, 92});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"冯松", 19, 1005, 89, 98, 83});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"裴培", 20, 1006, 75, 82, 91});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"马骁", 19, 1007, 62, 67, 90});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"马婧", 20, 1008, 98, 84, 87});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"周俊升", 19, 1009, 57, 68, 96});
        db.execSQL("insert into student(name, age, no, cpp, math, english) values(?, ?, ?, ?, ?, ?)", new Object[]{"贺祺", 21, 1010, 61, 96, 72});
    }

    //删除数据库中的数据
    public void Delete(View view) {

        //删除姓名为"刘得意"的学生的信息
        db.execSQL("delete from Student where name = ?", new Object[]{"刘得意"});
    }

    //修改数据库中的数据
    public void Update(View view) {

        //将数据库中所有人的学号减少1
        db.execSQL("update student set no = no -1");
    }

    //查询数据库中的数据
    public void Select(View view) {

        //查询数据库中学生的姓名和以其对应的C++成绩,返回值为一个结果集
        Cursor cursor = db.rawQuery("select name, cpp from student", null);

        while (cursor.moveToNext()) {

            //cursor.getColumnIndex("name")获得姓名所在的列
            String name = cursor.getString(cursor.getColumnIndex("name"));
            float cpp = cursor.getFloat(cursor.getColumnIndex("cpp"));

            //输出学生的姓名和与姓名对应的C++成绩
            Log.d("MainActivity", '[' + name + ", " + cpp + ']');
        }
    }
}
