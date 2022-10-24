package me.itanik.listofusers.data.persistence

import androidx.room.TypeConverter
import me.itanik.listofusers.data.network.dto.EyeColor
import me.itanik.listofusers.data.network.dto.FavoriteFruit
import java.util.*

class AppTypeConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

    @TypeConverter
    fun fromEyeColorOrdinal(ordinal: Int): EyeColor = EyeColor.values()[ordinal]

    @TypeConverter
    fun toEyeColorOrdinal(eyeColor: EyeColor): Int = eyeColor.ordinal

    @TypeConverter
    fun fromFavFruitOrdinal(ordinal: Int): FavoriteFruit = FavoriteFruit.values()[ordinal]

    @TypeConverter
    fun toFavFruitOrdinal(eyeColor: FavoriteFruit): Int = eyeColor.ordinal

    @TypeConverter
    fun fromIntListToString(intList: List<Int>): String = intList.joinToString(",")

    @TypeConverter
    fun fromStringToIntList(str: String): List<Int> = str.split(",").map { it.toInt() }
}