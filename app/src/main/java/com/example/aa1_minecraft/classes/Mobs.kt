package com.example.aa1_minecraft.clases

enum class MobPacifico(val nombre: String) {
    PASIVO("Pasivo"),
    NEUTRAL("Neutral"),
    HOSTIL("Hostil"),
    JEFE("Jefe"),
    JINETE("Jinete")
}

class Mobs(
    val name: String,
    val health: Int,
    val attack: Float?,
    val description: String,
    val itemDrop: String,
    val pacific: MobPacifico,
    val versionImplementada: Float,
    val audioResourceID: Int,
    val imageResourceID: Int
)
