package com.example.contactapp


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "contacts")
@Parcelize
data class Contact (
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,

    @ColumnInfo(name = "fname") //changes the first name col to fname
    var firstName: String?,

    @ColumnInfo(name = "lname")
    var lastName: String?,

    @ColumnInfo(name="PhoneNumber")
    var phone: String?,

    @ColumnInfo(name="Email")
    var email: String?,

    @ColumnInfo(name="Address")
    var address: String?

): Parcelable
