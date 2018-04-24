package it.xpug.kata.birthday_greetings;

public class BirthdayGreeting {
    private final String recipient;
    private final String subject;
    private final String body;

    public BirthdayGreeting(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public static BirthdayGreeting generateMessageFor(Employee employee) {
        String recipient = employee.getEmail();
        String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        String subject = "Happy Birthday!";

        return new BirthdayGreeting(recipient, subject, body);
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
