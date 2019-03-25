package com.ianc1215.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlantManager {

    private static PlantManager instance = null;

    public enum PlantType {

        FOOD,
        REAGENT,
        CROP,
        FLOWER,

    }

    public enum PlantBiome {

        DESERT,
        FOREST,
        TUNDRA,

    }

    private class PlantConfiguration {

        private String plantName;
        private PlantType[] plantType;
        private PlantBiome[] plantBiome;
        private Boolean requiresSky;
        private Boolean requiresSunlight;
        private Boolean requiresMoonlight;
        private Boolean requiresWater;

    }

    // This is static so we only get one per instance of PlantManager, this makes object management easier.
    private static class PlantStorage {

        static Map<String, PlantConfiguration> plantConfigurationMap = new HashMap<>();

    }

    public static PlantManager getInstance() {

        if (instance == null) {

            instance = new PlantManager();

        }

        return instance;

    }

    public void createPlant(String plantName, PlantType[] plantType, PlantBiome[] plantBiome, Boolean requiresSky, Boolean requiresSunlight, Boolean requiresMoonlight, Boolean requiresWater) {

        PlantConfiguration newPlant = new PlantConfiguration();

        newPlant.plantName = plantName;
        newPlant.plantType = plantType;
        newPlant.plantBiome = plantBiome;
        newPlant.requiresSky = requiresSky;
        newPlant.requiresSunlight = requiresSunlight;
        newPlant.requiresMoonlight = requiresMoonlight;
        newPlant.requiresWater = requiresWater;

        PlantStorage.plantConfigurationMap.put(plantName, newPlant);

    }

    public void destroyPlant(String plantName) {

        if (PlantStorage.plantConfigurationMap.containsKey(plantName)) {

            PlantStorage.plantConfigurationMap.remove(plantName);

        }

    }

    public Set<String> queryPlants() {

        return PlantStorage.plantConfigurationMap.keySet();

    }

}
