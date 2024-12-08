package com.example.demo;

import com.example.demo.entities.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testCreatePet() {
        Pet pet = new Pet();
        pet.setName("Max");
        pet.setAnimalType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(5);

    }

}
