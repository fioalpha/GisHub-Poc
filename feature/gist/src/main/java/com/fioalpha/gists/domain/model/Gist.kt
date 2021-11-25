package com.fioalpha.gists.domain.model

data class Gist(
    val name: String,
    val thumbnails: String,
    val files: File
)

data class File(
    val type: String,
)
