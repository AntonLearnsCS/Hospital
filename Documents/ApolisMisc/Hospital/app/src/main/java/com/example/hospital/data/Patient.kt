package com.example.hospital.data

import android.os.Parcel
import android.os.Parcelable

data class Patient(val patientId : Int, val name: String, val gender : String, val mobileNo : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(patientId)
        parcel.writeString(name)
        parcel.writeString(gender)
        parcel.writeString(mobileNo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Patient> {
        override fun createFromParcel(parcel: Parcel): Patient {
            return Patient(parcel)
        }

        override fun newArray(size: Int): Array<Patient?> {
            return arrayOfNulls(size)
        }
    }
}