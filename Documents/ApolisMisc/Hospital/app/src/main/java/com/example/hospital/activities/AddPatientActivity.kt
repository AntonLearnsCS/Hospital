package com.example.hospital.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.MainActivity
import com.example.hospital.data.Patient
import com.example.hospital.databinding.ActivityAddPatientBinding
import com.example.hospital.sql.PatientDao

class AddPatientActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddPatientBinding
    private lateinit var dao : PatientDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = PatientDao(baseContext)

        binding.btnSavePatient.setOnClickListener {
            val patient = Patient(0, binding.etPatientName.text.toString(),
                                    binding.etGender.text.toString(),
                                    binding.etMobile.text.toString())

            dao.savePatientInformation(patient)
            startActivity(Intent(baseContext, MainActivity::class.java))
        }
    }
}