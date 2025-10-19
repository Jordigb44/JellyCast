package dev.jdtech.jellyfin.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "movies")
data class JellyCastMovieDto(
    @PrimaryKey
    val id: UUID,
    val serverId: String?,
    val name: String,
    val originalTitle: String?,
    val overview: String,
    val runtimeTicks: Long,
    val premiereDate: LocalDateTime?,
    val communityRating: Float?,
    val officialRating: String?,
    val status: String,
    val productionYear: Int?,
    val endDate: LocalDateTime?,
    val chapters: List<JellyCastChapter>?,
)

fun JellyCastMovie.toJellyCastMovieDto(serverId: String? = null): JellyCastMovieDto =
    JellyCastMovieDto(
        id = id,
        serverId = serverId,
        name = name,
        originalTitle = originalTitle,
        overview = overview,
        runtimeTicks = runtimeTicks,
        premiereDate = premiereDate,
        communityRating = communityRating,
        officialRating = officialRating,
        status = status,
        productionYear = productionYear,
        endDate = endDate,
        chapters = chapters,
    )
