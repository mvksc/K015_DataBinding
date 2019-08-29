package mdev.k015_databinding

import android.os.Parcel
import android.os.Parcelable

data class ModelDateTime(val mDate: String?, val mTime: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mDate)
        parcel.writeString(mTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelDateTime> {
        override fun createFromParcel(parcel: Parcel): ModelDateTime {
            return ModelDateTime(parcel)
        }

        override fun newArray(size: Int): Array<ModelDateTime?> {
            return arrayOfNulls(size)
        }
    }
}