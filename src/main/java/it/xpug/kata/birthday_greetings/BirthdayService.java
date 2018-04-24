package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.text.ParseException;

public class BirthdayService {

    private Employees employees;
    private MessageSender messageSender;

    public BirthdayService(Employees employees, MessageSender messageSender) {
        this.employees = employees;
        this.messageSender = messageSender;
    }

    public BirthdayService() {

    }

    public void sendGreetings(String fileName, XDate xDate, String smtpHost, int smtpPort) throws IOException, ParseException, AddressException, MessagingException {
        employees = new FileEmployees(fileName);
        messageSender = new SMTPMessageSender(smtpHost, smtpPort);

        sendGreetings(xDate);
    }

    public void sendGreetings(XDate xDate) {
        for (Employee employee : employees.all()) {
            if (employee.isBirthday(xDate)) {
                BirthdayGreeting greeting = BirthdayGreeting.generateMessageFor(employee);

                messageSender.send(greeting);
            }
        }
    }
}
