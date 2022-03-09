package com.example.hospital.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Appointment
import com.example.hospital.databinding.AppointmentListItemLayoutBinding
import java.text.SimpleDateFormat
import java.util.*

class AppointmentListViewHolder (val binding : AppointmentListItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind( appointment: Appointment){
        binding.tvAppointmentId.text  = appointment.appointmentId.toString()
        binding.tvPatientNameAppointment.text = appointment.patientName .toString()
        binding.tvDoctorNameAppointmentList.text = appointment.doctorName.toString()

        val timeStamp = appointment.dateTime
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val netDate = Date(timeStamp * 1000L)
        val properDateTimeFormat = sdf.format(netDate)

        binding.tvDateTimeList.text = properDateTimeFormat
    }
}