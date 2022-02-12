package com.miladro.overridingequalmethodtut;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PersonEqualMethodUnitTest {

    @Test
    public void TestReflexivity_GivenAPersonObjectWithOverriddenEqualsMethod_WhenCallEqualsMethodWithItselfAsTheArgument_ThenTrueShouldBeReturned() {
        //Given
        Person person = new Person();
        person.setFirstName("John");
        person.setFirstName("Doe");
        person.setAge(20);

        //When
        boolean result = person.equals(person);

        //Then
        assertTrue(result);
    }

    @Test
    public void TestSymmetricity_GivenTwoEquivalentPersonObjectsWithOverriddenEqualsMethod_WhenCallEqualsMethodOnFirstObjectWithSecondObjectAsArgumentAndViseVersa_ThenTheReturningResultShouldBeTrue() {
        //Given
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setAge(20);

        Person person2 = new Person();
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setAge(20);

        //When
        boolean firstComparison = person1.equals(person2);
        boolean secondComparison = person2.equals(person1);

        //Then
        assertTrue(firstComparison);
        assertTrue(secondComparison);
    }

    @Test
    public void TestTransitivity_GivenThreeEquivalentPersonObjectsWithOverriddenEqualsMethod_WhenFirstEqualsSecondAndSecondEqualsThird_ThenFirstShouldBeEqualToThirdAlso() {
        //Given
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setAge(20);

        Person person2 = new Person();
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setAge(20);

        Person person3 = new Person();
        person3.setFirstName("John");
        person3.setLastName("Doe");
        person3.setAge(20);

        //When
        boolean firstEqualsSecond = person1.equals(person2);
        boolean secondEqualsThird = person2.equals(person3);
        assertTrue(firstEqualsSecond);
        assertTrue(secondEqualsThird);

        //Then
        boolean firstEqualsThird = person1.equals(person3);
        assertTrue(firstEqualsThird);
    }

    @Test
    public void TestConsistency_GivenMultiplePersonObjectsWithOverriddenEqualsMethod_WhenCompareThemUsingEqualsMethodMultipleTimes_ThenTheReturningResultShouldBeTheSameAllTheTime() {
        //Given
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setAge(20);

        Person person2 = new Person();
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setAge(20);

        //When
        int trueResultCounter = 0;
        Random random = new Random(); // or new Random(someSeed);
        int counter = random.nextInt(500);
        for (int i = 1; i <= counter; i++) {
            if (person1.equals(person2))
                trueResultCounter++;
        }

        //Then
        assertEquals(trueResultCounter, counter);
    }

    @Test
    public void TestNonNullity_GivenAPersonObjectWithOverriddenEqualsMethod_WhenCompareItToNullValueUsingEqualsMethodMultipleTimes_ThenFalseShouldBeReturned() {
        //Given
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setAge(20);

        //When
        boolean result = person1.equals(null);

        //Then
        assertEquals(false, result);
    }
}
