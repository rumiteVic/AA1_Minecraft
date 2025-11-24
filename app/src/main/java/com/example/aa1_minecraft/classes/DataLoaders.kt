package com.example.aa1_minecraft.clases

import com.example.aa1_minecraft.R
import com.example.aa1_minecraft.classes.Biomas
import com.example.aa1_minecraft.classes.BiomasDisponibles
import com.example.aa1_minecraft.classes.Crafteos
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
            Mobs("Pollo", 2, null, "El pollo es un mob pacífico incapaz de volar, solo planea en su caída", "Huevo, Carne de Pollo", MobPacifico.PASIVO, 1.7f, R.drawable.chicken),
            Mobs("Enderman", 20, 5f, "El Enderman es un mob neutral, puede teletransportarse y agarrar una serie de bloques.", "Enderperla", MobPacifico.NEUTRAL, 1.8f, R.drawable.enderman),
            Mobs("Zombie", 10, 3f, "El Zombie es una criatura muerta, la cual aparece usualmente en grupos", "Carne podrida", MobPacifico.HOSTIL, 1.7f, R.drawable.zombie)
        )
    }
    fun loadCrafteosInfo() : List<Crafteos> {
        return listOf(
            Crafteos("Mesa de crafteo", "Puede usarse cualquier placa de madera" ,1.7f,R.drawable.mesa_crafteo),
            Crafteos("Madera", null, 1.7f,R.drawable.mesa_crafteo)
        )
    }
    fun loadBiomasInfo() : List<Biomas> {
        return listOf(
            Biomas( BiomasDisponibles.LLANURA, description = "Una Llanura qualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.llanura),
            Biomas( BiomasDisponibles.BOSQUE, description = "Un Bosque qualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.bosque),
            Biomas( BiomasDisponibles.MONTAÑAS, description = "Unas Montañas qualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.monta_as),
            Biomas( BiomasDisponibles.TAIGA, description = "Una Taiga hecho de cuadrados", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.taiga),
            Biomas( BiomasDisponibles.DESIERTO, description = "Un Desierto hecho de cuadrados", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.8f, R.drawable.biomas),
            Biomas( BiomasDisponibles.SABANA, description = "Una Sabana qualquiera", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.7f, R.drawable.savanna),
            Biomas( BiomasDisponibles.JUNGLA, description = "Una Jungla de mierda", TipoBioma.BIOMAS_EXUBERANTES, versionImplementada= 1.8f, R.drawable.biomas)
        )
    }
}
