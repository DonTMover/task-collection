package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private final static String FEMALE = "Female";
    private final static String MALE = "Male";

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        List<Animal> filteredAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(4 * 7)
                .limit(7)
                .collect(Collectors.toList());
        filteredAnimals.stream().forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        List<String> filteredAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .map(animal -> {
                    String breed = animal.getBread();

                    if (animal.getGender().equalsIgnoreCase(FEMALE)) {
                        breed = breed.toUpperCase();
                    }
                    return breed;

                })
                .collect(Collectors.toList());
        filteredAnimals.stream().forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        Set<String> originStartsWithA = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .collect(Collectors.toSet());
        originStartsWithA.stream().forEach(System.out::println);

    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        long femaleAnimal = animals.stream()
                .filter(animal -> animal.getGender().equalsIgnoreCase(FEMALE))
                .count();
        System.out.println("femaleAnimal = " + femaleAnimal);

    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        boolean hasHungarianAnimal = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Hungarian"));
        System.out.println("hasHungarianAnimal = " + hasHungarianAnimal);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        Set<String> uniqueGenders = animals.stream()
                .map(Animal::getGender)
                .collect(Collectors.toSet());
        boolean allGendersAreValid = uniqueGenders.size() == 2 &&
                uniqueGenders.contains(MALE) &&
                uniqueGenders.contains(FEMALE);
        System.out.println("allGendersAreValid = " + allGendersAreValid);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        boolean noneFromOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equalsIgnoreCase("Oceania"));

        System.out.println("noneFromOceania = " + noneFromOceania);

    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        int maxAge = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElse(0);
        System.out.println("maxAge = " + maxAge);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        int minBreedLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(charArray -> charArray.length)
                .min()
                .orElse(0);
        System.out.println("minBreedLength = " + minBreedLength);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        int sumOfAges = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println("sumOfAges = " + sumOfAges);

    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
        double averageIndonesianAge = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .orElse(0);
        System.out.println("averageIndonesianAge = " + averageIndonesianAge);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        LocalDate currentDate = LocalDate.now();
//        persons.stream() Продолжить ...
        List<Person> selectedCandidates = persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Male") &&
                        Period.between(person.getDateOfBirth(), currentDate).getYears() >= 18 &&
                        Period.between(person.getDateOfBirth(), currentDate).getYears() <= 27)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup)
                        .reversed()
                        .thenComparing(person -> Period.between(person.getDateOfBirth(), currentDate).getYears()))
                .limit(200)
                .collect(Collectors.toList());
        selectedCandidates.stream().forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
//        houses.stream()
//                .filter(house -> house.getBuildingType().equalsIgnoreCase("Hospital"))
//                .flatMap(house -> house.getPersonList().stream())
//                .
    }


    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
