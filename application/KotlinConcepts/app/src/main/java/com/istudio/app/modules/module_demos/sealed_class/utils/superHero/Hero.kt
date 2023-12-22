package com.istudio.app.modules.module_demos.sealed_class.utils.superHero

class Hero(override val comicCompany: String) : SuperHero() {
   fun printCompany(){
       println(comicCompany)
   }
}