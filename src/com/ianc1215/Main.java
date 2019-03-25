package com.ianc1215;

import com.ianc1215.api.PlantManager;

public class Main {

    public static void main(String[] args) {

        PlantManager plantManager = PlantManager.getInstance();

        plantManager.createPlant(
                "Example Plant",
                new PlantManager.PlantType[]{PlantManager.PlantType.CROP},
                new PlantManager.PlantBiome[]{PlantManager.PlantBiome.DESERT},
                true,
                true,
                false,
                true
        );

        plantManager.createPlant(
                "Another Example Plant",
                new PlantManager.PlantType[]{PlantManager.PlantType.CROP, PlantManager.PlantType.REAGENT},
                new PlantManager.PlantBiome[]{PlantManager.PlantBiome.FOREST, PlantManager.PlantBiome.DESERT},
                true,
                true,
                false,
                false
        );

    }
}
