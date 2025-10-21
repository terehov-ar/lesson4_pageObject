package data;

import com.github.javafaker.*;

public class TestData {

    static Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = faker.phoneNumber().subscriberNumber(10),
            notValidMinNumber = faker.phoneNumber().subscriberNumber(8),
            notValidMaxNumber = faker.phoneNumber().subscriberNumber(16),
            day = String.valueOf(faker.number().numberBetween(1, 29)),
            month = faker.options().option("January", "June", "August", "December"),
            year = String.valueOf(faker.number().numberBetween(1900, 2100)),
            subject = faker.options().option("English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            attachment = faker.options().option("Locators_table.pdf", "2. Git. GitHub.pdf"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR","Uttar Pradesh","Haryana","Rajasthan"),
            city = TestData.chooseLocation(state);


    public static String chooseLocation(String state) {

        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }

}
