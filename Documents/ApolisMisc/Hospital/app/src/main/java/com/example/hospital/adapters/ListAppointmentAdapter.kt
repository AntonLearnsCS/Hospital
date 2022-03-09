package com.example.hospital.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Appointment
import com.example.hospital.databinding.AppointmentListItemLayoutBinding
import com.example.hospital.viewholder.AppointmentListViewHolder

class ListAppointmentAdapter(val list : List<Appointment>) : RecyclerView.Adapter<AppointmentListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentListViewHolder {
        val view = AppointmentListItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return AppointmentListViewHolder((view))
    }

    override fun onBindViewHolder(holder: AppointmentListViewHolder, position: Int) {
       holder.bind(list[position])
        holder.itemView.setOnClickListener {
            appointmentSelectedListener(list[position], position)
        }
    }

    override fun getItemCount(): Int = list.size

        private lateinit var appointmentSelectedListener : (Appointment, Int) -> Unit

        fun setAppointmentSelectedListener (listener : (Appointment, Int) -> Unit){
            appointmentSelectedListener = listener
        }
}