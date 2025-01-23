package demoqa.utils.randomEntityUtils;

import com.github.javafaker.Faker;
import demoqa.entity.User;

public class RandomUserGenerator {

    Faker faker = new Faker();

    public String randomFirstName(){
        return faker.name().fullName();
    }

    public String randomLastName(){
        return faker.name().lastName();
    }

    public String randomEmail(){
        return faker.internet().emailAddress();
    }

    public String randomPassword(){
        return faker.internet().password();
    }

    public String randomUserName(){
        return faker.name().username();
    }

    public User randomUser(){
        return new User(randomFirstName(), randomLastName(), randomUserName(),randomEmail(), randomPassword());
    }
}
