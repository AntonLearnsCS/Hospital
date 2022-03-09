package com.example.hospital.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospital.adapters.PatientAdapter
import com.example.hospital.data.Patient
import com.example.hospital.databinding.ActivityListOfPatientsBinding
import com.example.hospital.sql.PatientDao

class ListOfPatientsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListOfPatientsBinding
    private lateinit var adapter : PatientAdapter
    private lateinit var dao : PatientDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListOfPatientsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dao = PatientDao(baseContext)
        val listOfPatients : List<Patient> = dao.getAllPatients()

        adapter = PatientAdapter(listOfPatients)

        binding.rvListPatients.adapter = adapter

        binding.rvListPatients.layoutManager = LinearLayoutManager(baseContext)

        adapter.setOnPatientClickListener(object : PatientAdapter.onPatientClickListener{
            override fun onPatientClicked(patient: Patient) {

                val intent = Intent(baseContext, ListOfDoctorsActivity::class.java)
                intent.putExtra("patient",patient)
                startActivity(intent)
                finish()
            }

        })

    }
}