package com.example.hospital.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.MainActivity
import com.example.hospital.data.Doctor
import com.example.hospital.databinding.ActivityAddDoctorBinding
import com.example.hospital.sql.DoctorDao

class AddDoctorActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddDoctorBinding
    private lateinit var dao : DoctorDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = DoctorDao(baseContext)

        binding.btnSaveDoctor.setOnClickListener {
            val doctor = Doctor(0,binding.etDoctorName.text.toString(), binding.etSpecialty.text.toString(),
                            binding.etDegree.text.toString())
            dao.saveDoctorInformation(doctor)
            startActivity(Intent(baseContext, MainActivity::class.java))
            finish()
        }
    }
}