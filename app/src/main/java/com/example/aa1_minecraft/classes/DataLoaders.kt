package com.example.aa1_minecraft.clases

import com.example.aa1_minecraft.R
import com.example.aa1_minecraft.classes.BibliotecaInfo
import com.example.aa1_minecraft.classes.Biomas
import com.example.aa1_minecraft.classes.BiomasDisponibles
import com.example.aa1_minecraft.classes.Crafteos
import com.example.aa1_minecraft.classes.SkinsInfo
import com.example.aa1_minecraft.classes.TipoBioma

class DataLoaders (){
    fun loadEncantamientosInfo() : List<Encantamientos>{
        return listOf(
            Encantamientos( EncantamientosDisponibles.IRROMPIBILIDAD, "Reduce la probabilidad de que un objeto sufra daños.", 5, 1.7f, 5, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.RESPIRACION, "Extiende el tiempo de respiración bajo el agua.", 3, 1.7f, 2, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.FILO, "Aumenta el daño de armas cuerpo a cuerpo.", 5, 1.7f, 10, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.EFICIENCIA, "Aumenta la velocidad al minar", 5, 1.8f, 10, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.PROTECCION_CONTRA_EL_FUEGO, "Reduce el daño por fuego y el tiempo de quemadura.", 4, 1.7f, 5, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.AFINIDAD_ACTUATICA, "Aumenta la velocidad de las herramientas al minar bajo agua.", 1, 1.7f, 2, false, R.drawable.enchanted)
        )
    }
    fun loadMobsInfo() : List<Mobs>{
        return listOf(
            Mobs("Pollo", 2, null, "El pollo es un mob pacífico incapaz de volar, solo planea en su caída", "Huevo, Carne de Pollo", MobPacifico.PASIVO, 1.7f, R.raw.chicken_sound,R.drawable.chicken),
            Mobs("Enderman", 20, 5f, "El Enderman es un mob neutral, puede teletransportarse y agarrar una serie de bloques.", "Enderperla", MobPacifico.NEUTRAL, 1.8f, R.raw.enderman_sound,R.drawable.enderman),
            Mobs("Zombie", 10, 3f, "El Zombie es una criatura muerta, la cual aparece usualmente en grupos", "Carne podrida", MobPacifico.HOSTIL, 1.7f, R.raw.zombie_sound,R.drawable.zombie)
        )
    }
    fun loadCrafteosInfo() : List<Crafteos> {
        return listOf(
            Crafteos("Mesa de crafteo", "Puede usarse cualquier placa de madera" ,1.7f,R.drawable.crafting_grid),
            Crafteos("Plank", "Puede usarse cualquier Madera", 1.7f, R.drawable.crafting_grid_1),
            Crafteos("Palo", "Es un Palo", 1.7f,  R.drawable.crafting_grid_2),
            Crafteos("Pico de diamante", "Quiero ser minero", 1.8f,R.drawable.crafting_grid_3),
            Crafteos("Espada de diamante", "Tu sable", 1.8f,R.drawable.crafting_grid_4),
            Crafteos("Azada de diamante", "Una azada", 1.8f,R.drawable.crafting_grid_5),
            Crafteos("Casco de diamante", "Un casco", 1.8f,R.drawable.crafting_grid_6),
            Crafteos("Pechera de diamante", "A sacar pecho, machote", 1.8f,R.drawable.crafting_grid_7),
            Crafteos("Mallas de diamante", "Cubrete mejor tus partes", 1.8f,R.drawable.crafting_grid_8),
            Crafteos("Botas de diamante", "Esta pieza no cubre nada, matao", 1.8f,R.drawable.crafting_grid_10)

        )
    }

    fun loadBiomasInfo() : List<Biomas>{
        return listOf(
            Biomas( BiomasDisponibles.LLANURA, description = "Una Llanura cualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.llanura),
            Biomas( BiomasDisponibles.BOSQUE, description = "Un Bosque cualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.bosque),
            Biomas( BiomasDisponibles.MONTAÑAS, description = "Unas Montañas cualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.monta_as),
            Biomas( BiomasDisponibles.TAIGA, description = "Una Taiga hecho de cuadrados", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.taiga),
            Biomas( BiomasDisponibles.DESIERTO, description = "Un Desierto hecho de cuadrados", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.8f, R.drawable.desert),
            Biomas( BiomasDisponibles.SABANA, description = "Una Sabana cualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.savanna),
            Biomas( BiomasDisponibles.JUNGLA, description = "Una Jungla de mierda", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.8f, R.drawable.jungle)
        )
    }

    fun loadSkinsInfo() : List<SkinsInfo>{
        return listOf(
            SkinsInfo(
                name = "Steve",
                imageRes = R.drawable.steve
            ),
            SkinsInfo(
                name = "Alex",
                imageRes = R.drawable.alex
            ),
            SkinsInfo(
                name = "Juxray",
                imageRes = R.drawable.yo
            ),
            SkinsInfo(
                name = "Morita",
                imageRes = R.drawable.ella
            ),
            SkinsInfo(
                name = "Finn",
                imageRes = R.drawable.su_padre
            ),
            SkinsInfo(
                name = "Jake",
                imageRes = R.drawable.la_mascota
            ),
            SkinsInfo(
                name = "Notch",
                imageRes = R.drawable.su_madre
            ),
            SkinsInfo(
                name = "Victoria",
                imageRes = R.drawable.su_prometido
            )
        )
    }
    fun loadBibliotecaInfo() : List<BibliotecaInfo>{
        return listOf(
            BibliotecaInfo(
                title = "ENCANTAMIENTOS",
                imageRes = R.drawable.enchanted,
                route = "encantamientos"
            ),
            BibliotecaInfo(
                title = "MOBS",
                imageRes = R.drawable.chicken,
                route = "mobs"
            ),
            BibliotecaInfo(
                title = "CRAFTEOS",
                imageRes = R.drawable.mesa_crafteo,
                route = "crafteos"
            ),
            BibliotecaInfo(
                title = "BIOMAS",
                imageRes = R.drawable.biomas,
                route = "biomas"
            )
        )
    }
}
