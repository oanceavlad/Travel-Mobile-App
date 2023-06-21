package com.example.travelapp
import android.os.Parcel
import android.os.Parcelable

data class PlaceData(
    val id:Int?,
    //title=atractie
    val title:String?,
    //locatie cu icon
    //imediat sub denumire
    //descriere scurta de activitati care se fac
    val description:String?,
    val overview:String?,
    val location:String?,
    //rating dupa locatie
    val rating:String?

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(overview)
        parcel.writeString(location)
        parcel.writeString(rating)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaceData> {
        override fun createFromParcel(parcel: Parcel): PlaceData {
            return PlaceData(parcel)
        }

        override fun newArray(size: Int): Array<PlaceData?> {
            return arrayOfNulls(size)
        }
    }

}
