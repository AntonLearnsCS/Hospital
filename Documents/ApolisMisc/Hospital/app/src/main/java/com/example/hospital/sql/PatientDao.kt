package com.example.hospital.sql

import android.content.ContentValues
import android.content.Context
import com.example.hospital.data.Patient

class PatientDao(context: Context) {

    val db = dbHelper(context).writableDatabase

    fun savePatientInformation(patient: Patient){
        val contentValue = ContentValues()
        contentValue.apply {
            put("name",patient.name)
            put("gender",patient.gender)
            put("mobile",patient.mobileNo)
        }
        db.insert("patient",null,contentValue)
    }

    fun getAllPatients() : List<Patient>{

        val listOfPatients = mutableListOf<Patient>()
        val cursor = db.query("patient",null,null,null,null,null,null)

        /*
             CREATE TABLE patient(
            patient_id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            gender TEXT
            mobile TEXT
         */
        while (cursor.moveToNext()) {
            val patientId = cursor.getInt(cursor.getColumnIndexOrThrow("patient_id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
            val mobile = cursor.getString(cursor.getColumnIndexOrThrow("mobile"))

            val patient : Patient = Patient(patientId,name,gender,mobile)
                listOfPatients.add(patient)
        }
        return listOfPatients.toList()
    }
}