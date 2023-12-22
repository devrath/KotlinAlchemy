package com.istudio.app.modules.module_demos.sealed_class.utils.superHero

sealed class SuperHero {
    abstract val comicCompany : String
    data class Superman(val superPower: String, override val comicCompany: String): SuperHero()
    data class WonderWoman(val superPower: String, override val comicCompany: String): SuperHero()
    data class Batman(val superPower: String, override val comicCompany: String): SuperHero()
}