package lk.ijse.gdse68;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JacksonMain {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Create a new character
        GameCharacter hero = new GameCharacter("Phoenix", 100, 50);

        // Serialize the character to JSON
        try {
            mapper.writeValue(new File("character.json"), hero);
            System.out.println("Character saved successfully!");

            // Print JSON
            String jsonString = mapper.writeValueAsString(hero);
            System.out.println("JSON: " + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the character from JSON
        try {
            GameCharacter loadedHero = mapper.readValue(new File("character.json"), GameCharacter.class);
            System.out.println("Character loaded successfully!");
            System.out.println("Name: " + loadedHero.getName());
            System.out.println("Health: " + loadedHero.getHealth());
            System.out.println("Power: " + loadedHero.getPower());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

