package com.ianc1215.json;

import org.json.JSONObject;

public class JSONWriter {

    public JSONWriter() {



    }

    public void readConfiguration() {



    }

    public void writeConfiguration() {

        // Create a new root JSON object
        JSONObject root = new JSONObject();

        // Iterate through each key value pair for all possible plants
        plantMap.forEach((k, v) -> {

            // Create a new plant configuration inside the root JSON object
            JSONObject plant = new JSONObject();

            plant.put("plantName", v.getPlantName());

            JSONArray types = new JSONArray();
            for(int i = 0; i < v.getPlantType().length; i++) {
                types.put(v.getPlantType()[i]);
            }

            plant.put("plantType", types);

            JSONArray biomes = new JSONArray();
            for(int i = 0; i < v.getPlantBiomes().length; i++) {
                biomes.put(v.getPlantBiomes()[i]);
            }

            plant.put("plantBiomes", biomes);

            plant.put("requiresSky", v.getRequiresSky());
            plant.put("requiresSunlight", v.getRequiresSunlight());
            plant.put("requiresMoonlight", v.getRequiresMoonlight());

            root.put(k.toString(), plant);

        });

    }

}
