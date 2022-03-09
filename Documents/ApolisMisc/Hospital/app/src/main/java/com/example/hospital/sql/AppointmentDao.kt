package com.example.hospital.sql

import android.content.ContentValues
import android.content.Context
import com.example.hospital.data.Appointment

class AppointmentDao(context: Context) {

    val db = dbHelper(context).writableDatabase

    fun saveAppointment(doctorId : Int, patientId : Int, dateTime : Long){
        /*
          CREATE TABLE appointment(
            appointment_id INTEGER PRIMARY KEY AUTOINCREMENT,
            doctor_id INTEGER,
            patient_id INTEGER
            dateTime LONG /STRING for now
         */
        val contentValue = ContentValues()
        contentValue.apply {
            put("doctor_id",doctorId)
            put("patient_id",patientId)
            put("dateTime",dateTime)
        }
        db.insert("appointment",null, contentValue)
    }

    fun getAllAppointments() : List<Appointment>{

        val list = mutableListOf<Appointment>()
        //todo change
        val query = """
            SELECT doctor.name as doctor_name, patient.name as patient_name, dateTime, appointment_id
            FROM doctor, patient, appointment
            WHERE appointment.doctor_id = doctor.doctor_id AND appointment.patient_id=patient.patient_id
        """.trimIndent()

        val cursor = db.rawQuery(query,null)

        while (cursor.moveToNext()) {
            val doctorName = cursor.getString(cursor.getColumnIndexOrThrow("doctor_name"))
            val patientName = cursor.getString(cursor.getColumnIndexOrThrow("patient_name"))
            val dateTime = cursor.getLong(cursor.getColumnIndexOrThrow("dateTime"))
            val appointmentId = cursor.getInt(cursor.getColumnIndexOrThrow("appointment_id"))
            list.add(Appointment(doctorName,patientName,dateTime,appointmentId))
        }
        return list
    }
}