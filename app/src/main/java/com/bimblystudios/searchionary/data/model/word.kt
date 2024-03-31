package com.bimblystudios.searchionary.data.model

data class Word (
    val word: String? = null,
    val phonetic: String? = null,
    val phonetics: List<Phonetic>? = null,
    val meanings: List<Meaning>? = null,
    val license: License? = null,
    val sourceUrls: List<String>? = null
)

data class License (
    val name: String? = null,
    val url: String? = null
)

data class Meaning (
    val partOfSpeech: String? = null,
    val definitions: List<Definition>? = null,
    val synonyms: List<String>? = null,
    val antonyms: List<String>? = null
)

data class Definition (
    val definition: String? = null,
    val synonyms: List<String>? = null,
    val antonyms: List<Any?>? = null,
    val example: String? = null
)

data class Phonetic (
    val text: String? = null,
    val audio: String? = null,
    val sourceURL: String? = null,
    val license: License? = null
)
