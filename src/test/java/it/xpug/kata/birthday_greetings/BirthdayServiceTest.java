package it.xpug.kata.birthday_greetings;

import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class BirthdayServiceTest {
    @Test
    public void xxx() throws ParseException, MessagingException, IOException {
        BirthdayService service = new BirthdayService();

        service.sendGreetings("somewhere.com", 25);
    }
}