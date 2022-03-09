package com.example.hospital.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hospital.Constants

class dbHelper (context: Context) : SQLiteOpenHelper(context,"Hospital",null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constants.CREATE_APPOINTMENT_TABLE)
        db?.execSQL(Constants.CREATE_DOCTOR_TABLE)
        db?.execSQL(Constants.CREATE_PATIENT_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}