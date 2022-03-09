package com.example.hospital.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospital.adapters.DoctorAdapter
import com.example.hospital.data.Doctor
import com.example.hospital.data.Patient
import com.example.hospital.databinding.ActivityListOfDoctorsBinding
import com.example.hospital.sql.DoctorDao

class ListOfDoctorsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListOfDoctorsBinding
    private lateinit var dao : DoctorDao
    private lateinit var adapter: DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListOfDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = DoctorDao(baseContext)
        val listOfDoctors : List<Doctor> = dao.getAllDoctors()

        adapter = DoctorAdapter(listOfDoctors)
        binding.rvListDoctors.adapter = adapter

        binding.rvListDoctors.layoutManager = LinearLayoutManager(baseContext)

        val selectedPatient : Patient = intent.extras?.get("patient") as Patient
        adapter.setOnDoctorClickListener(object : DoctorAdapter.onDoctorClickListener{
            override fun onDoctorClicked(doctor: Doctor) {

                val intent = Intent(baseContext, AppointmentActivity::class.java)
                intent.putExtra("doctor",doctor)
                intent.putExtra("patient",selectedPatient)
                startActivity(intent)
                finish()
            }

        })
    }
}