package com.example.harajtask.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemsProperties(
var title:String,
var username :String,
var thumbURL :String,
var commentCount: String ,
var city:String,
var date:String,
var body:String
): Parcelable