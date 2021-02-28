package com.moriswala.firstcompose.model

import androidx.compose.runtime.Immutable

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Puppy(
    val id: Long,
    val name: String,
    val type: String,
    val thumbUrl: String,
    val thumbContentDesc: String,
    val description: String = "",
    val price: Int
)

/**
 * A fake repo
 */
object PuppyRepo {
    fun getPuppy(puppyId: Long): Puppy = puppies.find { it.id == puppyId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") puppyId: Long): List<Puppy> = puppies
}

val puppies = listOf(
    Puppy(
        id = 0,
        name = "Eos ut prompta consectetuer, vis at putent nominati disputando et.",
        type = "German Shepherd",
        thumbUrl = "https://source.unsplash.com/-Go4DH2pZbc",
        thumbContentDesc = "",
        price = 700,
    ),
    Puppy(
        id = 1,
        name = "Mel omnesque phaedrum prodesset id, vis in laoreet omnesque salutatus.",
        type = "Bulldog",
        thumbUrl = "https://source.unsplash.com/kjcivvWaD5I",
        thumbContentDesc = "",
        price = 1200
    ),
    Puppy(
        id = 2,
        name = "No nam brute elitr insolens, errem omittam ne per. At vix labores.",
        type = "Poodle",
        thumbUrl = "https://source.unsplash.com/795upe4hZRw",
        thumbContentDesc = "",
        price = 1800
    ),
    Puppy(
        id = 3,
        name = "Primis interesset necessitatibus ea pri, dicant prompta cum ex. Vel mollis melius.",
        type = "Labrador Retriever",
        thumbUrl = "https://source.unsplash.com/B2GIlAjMdS8",
        thumbContentDesc = "",
        price = 2200
    ),
    Puppy(
        id = 4,
        name = "Mel choro dicam detracto eu, vis ad invidunt ocurreret delicatissimi. Mel harum.",
        type = "Golden Retriever",
        thumbUrl = "https://source.unsplash.com/Qb7D1xw28Co",
        thumbContentDesc = "",
        price = 1900
    ),
    Puppy(
        id = 5,
        name = "Eu mentitum accusata pri, tritani postulant incorrupte nam ei. Dolore vulputate ex.",
        type = "Siberian Husky",
        thumbUrl = "https://source.unsplash.com/u8bLZX6q3E4",
        thumbContentDesc = "",
        price = 1400
    ),
    Puppy(
        id = 6,
        name = "Veniam viderer atomorum ei cum, sed omnis scaevola convenire ea. Sed dicat.",
        type = "Chihuahua",
        thumbUrl = "https://source.unsplash.com/wAP_IBPhn-4",
        thumbContentDesc = "",
        price = 1700
    ),
    Puppy(
        id = 7,
        name = "Nostrud mandamus democritum vix et, tibique offendit sensibus nec id. Argumentum interesset.",
        type = "Dachshund",
        thumbUrl = "https://source.unsplash.com/jCM48W7y6Y8",
        thumbContentDesc = "",
        price = 2200
    ),
    Puppy(
        id = 8,
        name = "Elitr impetus consetetur nam in, illud adipisci et usu. Qui in fuisset.",
        type = "French Bulldog",
        thumbUrl = "https://source.unsplash.com/HpVgq2BIjbw",
        thumbContentDesc = "",
        price = 1400
    ),
    Puppy(
        id = 9,
        name = "Ex diceret praesent definitiones has, eam no magna soleat. Ut lorem sadipscing.",
        type = "Great Dane",
        thumbUrl = "https://source.unsplash.com/guFQZcuRGOE",
        thumbContentDesc = "",
        price = 700
    ),
    Puppy(
        id = 10,
        name = "Et habemus complectitur nam, mei ex error labitur. Sea no integre imperdiet.",
        type = "Rottweiler",
        thumbUrl = "https://source.unsplash.com/uE4Dy_EpoqI",
        thumbContentDesc = "",
        price = 600
    ),
    Puppy(
        id = 11,
        name = "In epicurei patrioque vim, an sea exerci detracto luptatum, in usu iudico.",
        type = "Pomeranian",
        thumbUrl = "https://source.unsplash.com/wfXIDJkq1TM",
        thumbContentDesc = "",
        price = 400
    ),
    Puppy(
        id = 12,
        name = "Mea sonet verterem signiferumque ei, commodo impedit argumentum cu pro, cibo sanctus.",
        type = "Pembroke Welsh Corgi",
        thumbUrl = "https://source.unsplash.com/nTZLz0TqRhs",
        thumbContentDesc = "",
        price = 400
    )
)
