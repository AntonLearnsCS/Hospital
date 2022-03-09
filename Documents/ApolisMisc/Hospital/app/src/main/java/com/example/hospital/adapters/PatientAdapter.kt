package com.example.hospital.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.data.Patient
import com.example.hospital.databinding.PatientItemLayoutBinding
import com.example.hospital.viewholder.PatientViewHolder

class PatientAdapter(val list : List<Patient>) : RecyclerView.Adapter<PatientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = PatientItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return PatientViewHolder((view))    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            onPatientSelected.onPatientClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    private lateinit var onPatientSelected : onPatientClickListener

    interface onPatientClickListener{
        fun onPatientClicked(patient: Patient)
    }
    fun setOnPatientClickListener(listener: onPatientClickListener){
        onPatientSelected = listener
    }
}