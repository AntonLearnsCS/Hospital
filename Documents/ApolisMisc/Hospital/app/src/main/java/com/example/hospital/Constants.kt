package com.example.hospital

object Constants {

    const val CREATE_DOCTOR_TABLE = """
        CREATE TABLE doctor(
            doctor_id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            specialty TEXT,
            degree TEXT
        )
    """

    const val CREATE_PATIENT_TABLE = """
        CREATE TABLE patient(
            patient_id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            gender TEXT,
            mobile TEXT
        )
    """
    const val CREATE_APPOINTMENT_TABLE = """
        CREATE TABLE appointment(
            appointment_id INTEGER PRIMARY KEY AUTOINCREMENT,
            doctor_id INTEGER,
            patient_id INTEGER,
            dateTime LONG
        )
    """


}