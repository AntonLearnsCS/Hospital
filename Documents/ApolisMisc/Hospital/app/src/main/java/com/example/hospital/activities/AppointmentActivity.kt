package com.example.hospital.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospital.MainActivity
import com.example.hospital.data.Doctor
import com.example.hospital.data.Patient
import com.example.hospital.databinding.ActivityAppointmentBinding
import com.example.hospital.sql.AppointmentDao
import java.text.SimpleDateFormat
import java.util.*

class AppointmentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAppointmentBinding
    private lateinit var dao : AppointmentDao
    private lateinit var doctor : Doctor
    private lateinit var patient: Patient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dao = AppointmentDao(baseContext)

        doctor = intent.extras?.getParcelable<Doctor>("doctor") as Doctor
        patient = intent.extras?.getParcelable<Patient>("patient") as Patient

        binding.btnSaveAppointment.setOnClickListener {
            val dateTime = "${binding.tvSelectedDate.text} ${binding.tvSelectedTime.text}"

            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val date = simpleDateFormat.parse(dateTime)
            //source: https://stackoverflow.com/questions/65273195/kotlin-convert-datetime-to-10-digit-timestamp
            val timestamp : Long? = (date?.time)?.div(1000L)

            if (dateTime.isEmpty()){
                return@setOnClickListener
            }
            timestamp?.let { it1 -> dao.saveAppointment(doctor.doctorId, patient.patientId, it1) }
            val intent = Intent(baseContext,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnDate.setOnClickListener {
            selectDate()
        }
        binding.btnSelectTime.setOnClickListener {
            selectTime()
        }
    }

    fun selectTime(){
        val calendar = Calendar.getInstance()
        val currentHours = calendar.get(Calendar.HOUR)
        val currentMinutes = calendar.get(Calendar.MINUTE)
        val tpd = TimePickerDialog(this,
            {
                dialog, hours, minutes ->
                val currentTime = "$hours:$minutes"
                binding.tvSelectedTime.text = currentTime
            },
        currentHours,
        currentMinutes,
        false)
        tpd.show()
    }
    fun selectDate(){
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            {
                dialog,year,month,day ->
                val selectedDate = "$year-$month-$day"
                    binding.tvSelectedDate.text = selectedDate
            },
            currentYear,
            currentMonth,
            currentDay
        )
        dpd.show()
    }
}