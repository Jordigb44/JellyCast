package dev.jdtech.jellyfin.database

import androidx.room.TypeConverter
import dev.jdtech.jellyfin.models.JellyCastChapter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jellyfin.sdk.model.DateTime
import java.time.ZoneOffset
import java.util.UUID

class Converters {
    @TypeConverter
    fun fromStringToUUID(value: String?): UUID? = value?.let { UUID.fromString(it) }

    @TypeConverter
    fun fromUUIDToString(value: UUID?): String? = value?.toString()

    @TypeConverter
    fun fromDateTimeToLong(value: DateTime?): Long? = value?.toEpochSecond(ZoneOffset.UTC)

    @TypeConverter
    fun fromLongToDatetime(value: Long?): DateTime? = value?.let { DateTime.ofEpochSecond(it, 0, ZoneOffset.UTC) }

    @TypeConverter
    fun fromJellyCastChaptersToString(value: List<JellyCastChapter>?): String? = value?.let { Json.encodeToString(value) }

    @TypeConverter
    fun fromStringToJellyCastChapters(value: String?): List<JellyCastChapter>? = value?.let { Json.decodeFromString(value) }
}
