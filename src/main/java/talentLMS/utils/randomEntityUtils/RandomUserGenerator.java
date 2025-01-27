package talentLMS.utils.randomEntityUtils;

import com.github.javafaker.Faker;
import talentLMS.entity.User;

import java.util.Locale;

public class RandomUserGenerator {

    // Явно задаем локаль
    Faker faker = new Faker(new Locale("en"));

    public String randomFirstName(){
        return faker.name().fullName();
    }

    public String randomLastName(){
        return faker.name().lastName();
    }

    public String randomEmail(){
        return faker.internet().emailAddress();
    }



    public String randomUserName(){
        return faker.name().username();
    }

    public User randomUser(){
        return new User(randomFirstName(), randomLastName(), randomUserName(),randomEmail());
    }
}
