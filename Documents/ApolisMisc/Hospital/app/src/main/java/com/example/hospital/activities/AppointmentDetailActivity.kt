package com.example.hospital.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.data.Appointment
import com.example.hospital.databinding.ActivityAppointmentDetailBinding
import java.text.SimpleDateFormat
import java.util.*

class AppointmentDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAppointmentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appointment = intent.extras?.getParcelable<Appointment>("appointment") as Appointment

        val timeStamp = appointment.dateTime
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val netDate = Date(timeStamp * 1000L)
        val properDateTimeFormat = sdf.format(netDate)

        binding.tvDateTimeAppointmentDetail.text = properDateTimeFormat
        binding.tvDoctorNameAppointmentDetail.text = appointment.doctorName
        binding.tvPatientNameAppointmentDetail.text = appointment.patientName
    }
}