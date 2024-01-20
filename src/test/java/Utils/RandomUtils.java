package Utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String inputEmail = faker.internet().emailAddress();
    public String inputGender = getGender();
    public String inputPhone = faker.phoneNumber().subscriberNumber(10);
    public String randomDay = String.valueOf(faker.number().numberBetween(1,28));
    public String randomMonth = getMonth();
    public String randomYear = String.valueOf(faker.number().numberBetween(1900, 2050));
    public String inputSubject = getSubject();
    public String inputHobby = getHobbie();
    public String pictureName = "1.jpeg";
    public String inputAddress = faker.address().fullAddress();
    public String inputAddress2 = faker.address().fullAddress();
    public String inputCity = getCity();
    public String inputState = getState(inputCity);
    public String findColor = "border-color";
    public String colorName = "rgb(220, 53, 69)";



    public String getMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getHobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getSubject() {
        return faker.options().option("Maths", "Arts", "English", "Biology", "Hindi", "Commerce");
    }
    public String getState(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Noida", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Merrut", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
    public String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer");
    }
}



