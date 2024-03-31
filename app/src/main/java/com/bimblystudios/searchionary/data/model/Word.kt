package com.bimblystudios.searchionary.data.model

data class Word (
    val word: String,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val meanings: List<Meaning>,
    val license: License,
    val sourceUrls: List<String>,
    val favorite: Boolean = false
)

data class License (
    val name: String,
    val url: String
)

data class Meaning (
    val partOfSpeech: String,
    val definitions: List<Definition>,
    val synonyms: List<String>,
    val antonyms: List<String>
)

data class Definition (
    val definition: String,
    val synonyms: List<String>,
    val antonyms: List<Any?>,
    val example: String? = null
)

data class Phonetic (
    val text: String,
    val audio: String,
    val sourceURL: String,
    val license: License
)