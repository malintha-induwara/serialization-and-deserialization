package lk.ijse.gdse68;


import java.io.*;

public class ByteStreamMain {

    public static void main(String[] args) {
        // Create a new character
        GameCharacter hero = new GameCharacter("Phoenix", 100, 50);

        // Serialize the character
        try (FileOutputStream fileOut = new FileOutputStream("character.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(hero);
            System.out.println("Character saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the character
        try (FileInputStream fileIn = new FileInputStream("character.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            GameCharacter loadedHero = (GameCharacter) in.readObject();
            System.out.println("Character loaded successfully!");
            System.out.println("Name: " + loadedHero.getName());
            System.out.println("Health: " + loadedHero.getHealth());
            System.out.println("Power: " + loadedHero.getPower());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

