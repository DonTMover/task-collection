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
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final  String FEMALE = "Female";
    private static final  String MALE = "Male";

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

    private static int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
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
//        persons.stream() Продолжить ...
        List<Person> selectedCandidates = persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Male") &&
                        getAge(person) >= 18 &&
                        getAge(person) <= 27)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup)
                        .reversed()
                        .thenComparing(person -> getAge(person)))
                .limit(200)
                .collect(Collectors.toList());
        selectedCandidates.stream().forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
//        List<Person> people = houses.stream()
//                .flatMap(house -> house.getPersonList().stream())
//                .collect(Collectors.toList());
//
//        people.stream()
//                .sorted(Comparator.comparing(person -> getAge(person) >= 65)
//        TODO: Temporarily Skiped
    }


    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
        List<Car> turkmenistanCars = cars.stream()
                .filter(car -> car.getCarMake().equalsIgnoreCase("Jaguar") ||
                        car.getColor().equalsIgnoreCase("White"))
                .collect(Collectors.toList());
        List<Car> uzbekistanCars = cars.stream()
                .filter(car -> car.getMass() < 1500 &&
                        car.getCarMake().equalsIgnoreCase("BMW") ||
                        car.getCarMake().equalsIgnoreCase("Lexus") ||
                        car.getCarModel().equalsIgnoreCase("Chrysler") ||
                        car.getCarMake().equalsIgnoreCase("Toyota"))
                .collect(Collectors.toList());
        List<Car> kazakhstanCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Black") &&
                        car.getMass() > 4000 ||
                        car.getCarMake().equalsIgnoreCase("GMC") ||
                        car.getCarMake().equalsIgnoreCase("Dodge"))
                .collect(Collectors.toList());
        List<Car> kyrgyzstanCars = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982 ||
                        car.getCarModel().equalsIgnoreCase("Civic") ||
                        car.getCarModel().equalsIgnoreCase("Cherokee"))
                .collect(Collectors.toList());
        List<Car> russiaCars = cars.stream()
                .filter(car -> !(car.getColor().equalsIgnoreCase("Yellow") ||
                        car.getColor().equalsIgnoreCase("Red") ||
                        car.getColor().equalsIgnoreCase("Green") ||
                        car.getColor().equalsIgnoreCase("Blue")) ||
                        car.getPrice() > 40000)
                .collect(Collectors.toList());
        List<Car> mongoliaCars = cars.stream()
                .filter(car -> !turkmenistanCars.contains(car) &&
                        !uzbekistanCars.contains(car) &&
                        !kazakhstanCars.contains(car) &&
                        !kyrgyzstanCars.contains(car) &&
                        !russiaCars.contains(car))
                .collect(Collectors.toList());
        double CarsSum = CarsSum(turkmenistanCars) +
                CarsSum(uzbekistanCars) +
                CarsSum(kazakhstanCars) +
                CarsSum(kyrgyzstanCars) +
                CarsSum(russiaCars) +
                CarsSum(mongoliaCars);
        System.out.println("CarsSum = " + CarsSum);

    }

    private static double CarsSum(List<Car> cars) {
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
        double FlowersSum = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice).reversed()
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())

                .filter(flower -> flower.getCommonName().startsWith("S") &&
                        flower.getCommonName().endsWith("C"))
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().contains("Aluminum") ||
                        flower.getFlowerVaseMaterial().contains("Steel"))
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * (5 * 365) * 0.8) //0.8 - цена куба воды
                .sum();
        System.out.println("FlowersSum = " + FlowersSum);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println("Surname=" +
                        student.getSurname() +
                        ",Age=" +
                        student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
        Set<String> studentGroups = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet());
        System.out.println("studentGroups = " + studentGroups);

    }

    public static void task18() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
        LinkedHashMap<String, Double> averageAgeStudentsOfFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        averageAgeStudentsOfFaculty.forEach((faculty, averageAge) -> System.out.println("faculty=" + faculty + ",averageAge=" + averageAge));

    }

    public static void task19() throws RuntimeException {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Set<String> groups = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet());
        try (Scanner scanner = new Scanner(System.in)) {
            String targetGroup = scanner.next();
//        students.stream() Продолжить ...
            if (targetGroup != null) {
                if (groups.contains(targetGroup)) {
                    List<Student> StudentsExamBetter4 = students.stream()
                            .filter(student -> student.getGroup().equals(targetGroup))
                            .filter(student -> examinations.stream()
                                    .anyMatch(examination -> examination.getStudentId() == student.getId() &&
                                            examination.getExam3() > 4))
                            .collect(Collectors.toList());
                    System.out.println("collect = " + StudentsExamBetter4);
                } else {
                    throw new RuntimeException("targetGroup not in Groups Set");
                }
            } else {
                throw new RuntimeException("targetGroup not found!");
            }
        }

    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
        Optional<String> facultyWithHighestAverageExam1 = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(student -> {
                            return examinations.stream()
                                    .filter(exam -> exam.getStudentId() == student.getId())
                                    .mapToInt(Examination::getExam1)
                                    .findFirst()
                                    .orElse(0);
                        })))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        facultyWithHighestAverageExam1.ifPresent(faculty -> System.out.println("faculty=" + faculty));
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
        Map<String, Long> studensCountByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
        System.out.println("studensCountByGroup = " + studensCountByGroup);
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
        Map<String, Integer> minAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.minBy(Comparator.comparingInt(Student::getAge))))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get().getAge()));
        System.out.println("minAgeByFaculty = " + minAgeByFaculty);

    }
}
