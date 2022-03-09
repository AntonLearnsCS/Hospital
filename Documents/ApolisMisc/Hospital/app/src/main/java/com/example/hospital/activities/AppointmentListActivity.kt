package com.example.hospital.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospital.adapters.ListAppointmentAdapter
import com.example.hospital.databinding.ActivityAppointmentListBinding
import com.example.hospital.sql.AppointmentDao

class AppointmentListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAppointmentListBinding
    private lateinit var adapter : ListAppointmentAdapter
    private lateinit var dao : AppointmentDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = AppointmentDao(baseContext)
        val listOfAppointments = dao.getAllAppointments()

        adapter = ListAppointmentAdapter(listOfAppointments)

        binding.rvListAppointments.adapter = adapter

        binding.rvListAppointments.layoutManager = LinearLayoutManager(baseContext)

        adapter.setAppointmentSelectedListener{
            appointment, position ->
            val intent = Intent(baseContext, AppointmentDetailActivity::class.java)
            intent.putExtra("appointment",appointment)
            startActivity(intent)
            finish()
        }

    }
}