package com.example.hospital.sql

import android.content.ContentValues
import android.content.Context
import com.example.hospital.data.Doctor

class DoctorDao(context: Context) {
    val db = dbHelper(context).writableDatabase

    /*
        CREATE TABLE doctor(
            doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            specialty TEXT
            degree TEXT
        )
     */

    fun saveDoctorInformation( doctor: Doctor){
        val contentValue = ContentValues()
        contentValue.apply {
            put("name",doctor.name)
            put("specialty",doctor.specialty)
            put("degree",doctor.degree)
        }
        db.insert("doctor",null,contentValue)
    }
    fun getAllDoctors() : List<Doctor>{

        val listOfDoctors = mutableListOf<Doctor>()
        val cursor = db.query("doctor",null,null,null,null,null,null)

        /*
          doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            specialty TEXT
            degree TEXT
         */
        while (cursor.moveToNext()) {
            val doctorId = cursor.getInt(cursor.getColumnIndexOrThrow("doctor_id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val specialty = cursor.getString(cursor.getColumnIndexOrThrow("specialty"))
            val degree = cursor.getString(cursor.getColumnIndexOrThrow("degree"))

            val doctor : Doctor = Doctor(doctorId,name,specialty,degree)
            listOfDoctors.add(doctor)
        }
        return listOfDoctors.toList()
    }
}