package com.example.hospital.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Doctor
import com.example.hospital.databinding.DoctorItemLayoutBinding

class DoctorViewHolder (val binding : DoctorItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(doctor: Doctor){
        binding.tvDoctorName.text = doctor.name
        binding.tvDoctorSpecialty.text = doctor.specialty
        binding.tvDoctorDegree.text = doctor.degree
    }
}