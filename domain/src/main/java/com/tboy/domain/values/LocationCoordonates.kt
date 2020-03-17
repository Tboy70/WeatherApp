package com.tboy.domain.values

const val LYON = "Lyon"
const val PARIS = "Paris"
const val BORDEAUX = "Bordeaux"
const val LILLE = "Lille"

object LocationCoordonates {
    private val LYON_LOCATION = Pair(LYON, listOf(45.764042, 4.835659))
    private val PARIS_LOCATION = Pair(PARIS, listOf(48.856613, 2.352222))
    private val BORDEAUX_LOCATION = Pair(BORDEAUX, listOf(44.837788, -0.579180))
    private val LILLE_LOCATION = Pair(LILLE, listOf(50.629250, 3.057256))

    val allList = mutableListOf<Pair<String, List<Double>>>().apply {
        add(LYON_LOCATION)
        add(PARIS_LOCATION)
        add(BORDEAUX_LOCATION)
        add(LILLE_LOCATION)
    }
}