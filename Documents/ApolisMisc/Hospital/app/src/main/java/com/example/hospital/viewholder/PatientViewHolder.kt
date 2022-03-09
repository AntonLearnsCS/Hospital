package com.example.hospital.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Patient
import com.example.hospital.databinding.PatientItemLayoutBinding

class PatientViewHolder(val binding: PatientItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(patient: Patient){
        binding.tvName.text = patient.name
        binding.tvGender.text = patient.gender
        binding.tvMobileNo.text = patient.mobileNo
    }
}