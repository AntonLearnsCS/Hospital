package com.example.hospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.activities.*
import com.example.hospital.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddPatient.setOnClickListener {
            startActivity(Intent(baseContext,AddPatientActivity::class.java))
            //finish()
        }
        binding.btnAppointment.setOnClickListener {
            startActivity(Intent(baseContext,ListOfPatientsActivity::class.java))
            //finish()
        }
        binding.btnAddDoctor.setOnClickListener {
            startActivity(Intent(baseContext,AddDoctorActivity::class.java))
            //finish()
        }
        binding.btnViewAppointments.setOnClickListener {
            startActivity(Intent(baseContext,AppointmentListActivity::class.java))
        }
    }
}