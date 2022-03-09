package com.example.hospital.data

import android.os.Parcel
import android.os.Parcelable

data class Appointment(val doctorName : String, val patientName : String, val dateTime : Long,
                       val appointmentId : Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readLong(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(doctorName)
        parcel.writeString(patientName)
        parcel.writeLong(dateTime)
        parcel.writeInt(appointmentId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Appointment> {
        override fun createFromParcel(parcel: Parcel): Appointment {
            return Appointment(parcel)
        }

        override fun newArray(size: Int): Array<Appointment?> {
            return arrayOfNulls(size)
        }
    }
}