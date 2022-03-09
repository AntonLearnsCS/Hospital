package com.example.hospital.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Doctor
import com.example.hospital.databinding.DoctorItemLayoutBinding
import com.example.hospital.viewholder.DoctorViewHolder

class DoctorAdapter(val list : List<Doctor>) : RecyclerView.Adapter<DoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = DoctorItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return DoctorViewHolder((view))
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            onDoctorSelected.onDoctorClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    private lateinit var onDoctorSelected : onDoctorClickListener

    interface onDoctorClickListener{
        fun onDoctorClicked(doctor: Doctor)
    }
    fun setOnDoctorClickListener(listener: onDoctorClickListener){
        onDoctorSelected = listener
    }
}