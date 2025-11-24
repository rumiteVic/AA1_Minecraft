package com.example.aa1_minecraft.classes

enum class BiomasDisponibles(val nombre: String){
    MONTAÑAS("Montañas"),
    TAIGA("Taiga"),
    LLANURA("Llanura"),
    BOSQUE("Bosque"),
    ABEDULAR("Abedular"),
    BOSQUE_OSCURO("Bosque Oscuro"),
    PANTANO("Pantano"),
    JUNGLA("Jungla"),
    DESIERTO("Desierto"),
    SABANA("Sabana"),
    MESETA("Meseta")
}

enum class TipoBioma(
    val nombre: String,
    val biomas: List<BiomasDisponibles>
){
    BIOMAS_FRIOS(
        nombre = "Biomas Fríos",
        biomas = listOf(
            BiomasDisponibles.MONTAÑAS,
            BiomasDisponibles.TAIGA
        )
    ),

    BIOMAS_EXUBERANTES(
        nombre = "Biomas exuberantes",
        biomas = listOf(
            BiomasDisponibles.LLANURA,
            BiomasDisponibles.BOSQUE,
            BiomasDisponibles.ABEDULAR,
            BiomasDisponibles.BOSQUE_OSCURO,
            BiomasDisponibles.PANTANO,
            BiomasDisponibles.JUNGLA
        )
    ),

    BIOMAS_CALIDOS(
        nombre = "Biomas cálidos",
        biomas = listOf(
            BiomasDisponibles.DESIERTO,
            BiomasDisponibles.SABANA,
            BiomasDisponibles.MESETA
        )
    )
}

data class Biomas(
    val name: BiomasDisponibles,
    val description: String,
    val tipoBioma: TipoBioma,
    val versionImplementada: Float,
    val imageResourceID: Int
)
