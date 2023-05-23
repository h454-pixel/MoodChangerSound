package com.examplenextqx.moodchangersounds

import android.os.Parcel
import android.os.Parcelable

class ModelF (
    var name: String? = null,
    var img: Int = 0,
    var musicType: Int = 0,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(img)
        parcel.writeInt(musicType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelF> {
        override fun createFromParcel(parcel: Parcel): ModelF {
            return ModelF(parcel)
        }

        override fun newArray(size: Int): Array<ModelF?> {
            return arrayOfNulls(size)
        }
    }
}