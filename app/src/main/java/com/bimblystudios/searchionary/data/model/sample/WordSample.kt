package com.bimblystudios.searchionary.data.model.sample

import com.bimblystudios.searchionary.data.model.Definition
import com.bimblystudios.searchionary.data.model.License
import com.bimblystudios.searchionary.data.model.Meaning
import com.bimblystudios.searchionary.data.model.Phonetic
import com.bimblystudios.searchionary.data.model.Word
import retrofit2.Retrofit

class WordSample {
    val wordSuccess = listOf(
        Word(
            word = "mean",
            phonetic = "/miːn/",
            phonetics = listOf(
                Phonetic(
                    text = "/miːn/",
                    audio = "https://api.dictionaryapi.dev/media/pronunciations/en/mean-us.mp3",
                    sourceURL = "https://commons.wikimedia.org/w/index.php?curid=1217918",
                    license = License(
                        name = "BY-SA 3.0",
                        url = "https://creativecommons.org/licenses/by-sa/3.0"
                    )
                )
            ),
            meanings = listOf(
                Meaning(
                    partOfSpeech = "verb",
                    definitions = listOf(
                        Definition(
                            definition = "To lament.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        )
                    ),
                    synonyms = emptyList(),
                    antonyms = emptyList()
                ),
                Meaning(
                    partOfSpeech = "verb",
                    definitions = listOf(
                        Definition(
                            definition = "To intend.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "To convey (a meaning).",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "To have conviction in (something said or expressed); to be sincere in (what one says).",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "Does she really mean what she said to him last night?"
                        ),
                        Definition(
                            definition = "To cause or produce (a given result); to bring about (a given result).",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "One faltering step means certain death."
                        ),
                        Definition(
                            definition = "(usually with to) To be of some level of importance.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "Formality and titles mean nothing in their circle."
                        )
                    ),
                    synonyms = listOf(
                        "bring about",
                        "cause",
                        "lead to",
                        "result in",
                        "convey",
                        "indicate",
                        "signify",
                        "imply",
                        "intend",
                        "serious"
                    ),
                    antonyms = emptyList()
                ),
                Meaning(
                    partOfSpeech = "adjective",
                    definitions = listOf(
                        Definition(
                            definition = "Common; general.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Of a common or low origin, grade, or quality; common; humble.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "a man of mean parentage / a mean abode"
                        ),
                        Definition(
                            definition = "Low in quality or degree; inferior; poor; shabby.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "a mean appearance / mean dress"
                        ),
                        Definition(
                            definition = "Without dignity of mind; destitute of honour; low-minded; spiritless; base.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "a mean motive"
                        ),
                        Definition(
                            definition = "Of little value or worth; worthy of little or no regard; contemptible; despicable.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Ungenerous; stingy; tight-fisted.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "He's so mean. I've never seen him spend so much as five pounds on presents for his children."
                        ),
                        Definition(
                            definition = "Disobliging; pettily offensive or unaccommodating",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Selfish; acting without consideration of others; unkind.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "It was mean to steal the girl's piggy bank, but he just had to get uptown and he had no cash of his own."
                        ),
                        Definition(
                            definition = "Intending to cause harm, successfully or otherwise; bearing ill will towards another",
                            synonyms = listOf("cruel", "malicious"),
                            antonyms = emptyList(),
                            example = "Watch out for her, she's mean. I said good morning to her, and she punched me in the nose."
                        ),
                        Definition(
                            definition = "Powerful; fierce; strong",
                            synonyms = listOf("damaging", "harsh"),
                            antonyms = emptyList(),
                            example = "It must have been a mean typhoon that levelled this town."
                        ),
                        Definition(
                            definition = "Accomplished with great skill; deft; hard to compete with.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "He hits a mean backhand."
                        ),
                        Definition(
                            definition = "Difficult, tricky.",
                            synonyms = emptyList(),
                            antonyms = emptyList(),
                            example = "This problem is mean!"
                        )
                    ),
                    synonyms = listOf(
                        "base",
                        "ignoble",
                        "selfish",
                        "unkind",
                        "vile",
                        "cheap",
                        "grotty",
                        "inferior",
                        "low",
                        "naff",
                        "quality",
                        "rough and ready",
                        "shoddy",
                        "tacky",
                        "cruel",
                        "malicious",
                        "cruel",
                        "malicious",
                        "nasty",
                        "spiteful",
                        "damaging",
                        "fierce",
                        "harsh",
                        "strong",
                        "damaging",
                        "harsh",
                        "deft",
                        "skilful",
                        "skillful",
                        "top-notch"
                    ),
                    antonyms = listOf(
                        "honorable",
                        "lofty",
                        "noble"
                    )
                ),
                Meaning(
                    partOfSpeech = "noun",
                    definitions = listOf(
                        Definition(
                            definition = "(now chiefly in the plural) A method or course of action used to achieve some result.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "(in the singular) An intermediate step or intermediate steps.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Something which is intermediate or in the middle; an intermediate value or range of values; a medium.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "The middle part of three-part polyphonic music; now specifically, the alto part in polyphonic music; an alto instrument.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "The average of a set of values, calculated by summing them together and dividing by the number of terms; the arithmetic mean.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Any function of multiple variables that satisfies certain properties and yields a number representative of its arguments; or, the number so yielded; a measure of central tendency.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Either of the two numbers in the middle of a conventionally presented proportion, as 2 and 3 in 1:2=3:6.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        )
                    ),
                    synonyms = emptyList(),
                    antonyms = emptyList()
                ),
                Meaning(
                    partOfSpeech = "adjective",
                    definitions = listOf(
                        Definition(
                            definition = "Having the mean (see noun below) as its value.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "Middling; intermediate; moderately good, tolerable.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        )
                    ),
                    synonyms = emptyList(),
                    antonyms = emptyList()
                )
            ),
            license = License(
                name = "CC BY-SA 3.0",
                url = "https://creativecommons.org/licenses/by-sa/3.0"
            ),
            sourceUrls = listOf(
                "https://en.wiktionary.org/wiki/mean"
            )
        ),
        Word(
            word = "data",
            phonetic = "/ˈdaetə/",
            phonetics = listOf(
                Phonetic(
                    text = "/ˈdaetə/",
                    audio = "https://api.dictionaryapi.dev/media/pronunciations/en/data-au-nz.mp3",
                    sourceURL = "https://commons.wikimedia.org/w/index.php?curid=35316551",
                    license = License(
                        name = "BY-SA 4.0",
                        url = "https://creativecommons.org/licenses/by-sa/4.0"
                    )
                ),
                Phonetic(
                    text = "/ˈdætə/",
                    audio = "https://api.dictionaryapi.dev/media/pronunciations/en/data-ca-ie-us.mp3",
                    sourceURL = "https://commons.wikimedia.org/w/index.php?curid=197143",
                    license = License(
                        name = "BY-SA 3.0",
                        url = "https://creativecommons.org/licenses/by-sa/3.0"
                    )
                ),
                Phonetic(
                    text = "/ˈdeɪtə/",
                    audio = "https://api.dictionaryapi.dev/media/pronunciations/en/data-ie-uk-us.mp3",
                    sourceURL = "https://commons.wikimedia.org/w/index.php?curid=197144",
                    license = License(
                        name = "BY-SA 3.0",
                        url = "https://creativecommons.org/licenses/by-sa/3.0"
                    )
                )
            ),
            meanings = listOf(
                Meaning(
                    partOfSpeech = "noun",
                    definitions = listOf(
                        Definition(
                            definition = "(plural: data) A measurement of something on a scale understood by both the recorder (a person or device) and the reader (another person or device). The scale is arbitrarily defined, such as from 1 to 10 by ones, 1 to 100 by 0.1, or simply true or false, on or off, yes, no, or maybe, etc.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "(plural: data) A fact known from direct observation.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "(plural: data) A premise from which conclusions are drawn.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        ),
                        Definition(
                            definition = "(plural: datums) A fixed reference point, or a coordinate system.",
                            synonyms = emptyList(),
                            antonyms = emptyList()
                        )
                    ),
                    synonyms = emptyList(),
                    antonyms = emptyList()
                )
            ),
            license = License(
                name = "CC BY-SA 3.0",
                url = "https://creativecommons.org/licenses/by-sa/3.0"
            ),
            sourceUrls = listOf(
                "https://en.wiktionary.org/wiki/data",
                "https://en.wiktionary.org/wiki/datum"
            )
        )
    )
}