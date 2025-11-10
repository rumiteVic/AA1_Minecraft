package com.example.aa1_minecraft.clases

import androidx.annotation.DrawableRes

enum class TipoItem(val nombre: String) {
    ESPADA("Espada"),
    PICO("Pico"),
    PALA("Pala"),
    HACHA("Hacha"),
    CASCO("Casco"),
    PETO("Peto"),
    PANTALONES("Pantalones"),
    BOTAS("Botas"),
    ARCO("Arco"),
    CANA_DE_PESCAR("Caña de pescar")
}
enum class EncantamientosDisponibles(val nombre: String,
                                     val itemsCompatibles: List<TipoItem>) {
    IRROMPIBILIDAD("Irrompibilidad",
        listOf(
            TipoItem.ESPADA,
            TipoItem.PICO,
            TipoItem.PALA,
            TipoItem.HACHA,
            TipoItem.CASCO,
            TipoItem.PETO,
            TipoItem.PANTALONES,
            TipoItem.BOTAS,
            TipoItem.ARCO,
            TipoItem.CANA_DE_PESCAR
        )
    ),
    RESPIRACION("Respiración",
        listOf(TipoItem.CASCO)),
    FILO("Filo",listOf(TipoItem.ESPADA, TipoItem.HACHA)),
    EFICIENCIA("Eficiencia",listOf(TipoItem.PICO, TipoItem.PALA, TipoItem.HACHA)),
    PROTECCION_CONTRA_EL_FUEGO("Protección contra el fuego",listOf(TipoItem.CASCO, TipoItem.PETO, TipoItem.PANTALONES, TipoItem.BOTAS)),
    AFINIDAD_ACTUATICA("Afinidad actuática",listOf(TipoItem.CASCO))
}

data class Encantamientos(
    val encantamiento: EncantamientosDisponibles,
    val efecto: String,
    val nivelMaximo: Int,
    val versionImplementada: Float,
    val pesoEncantamiento: Int,
    val halladoEnTesoro: Boolean,
    @DrawableRes val imageResourceID: Int
)
