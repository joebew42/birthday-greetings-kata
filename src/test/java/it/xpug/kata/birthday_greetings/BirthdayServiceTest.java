package it.xpug.kata.birthday_greetings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayServiceTest {

    @Mock private Employees employees;
    @Mock private MessageSender messageSender;

    private BirthdayService service;

    @Before
    public void setUp() throws Exception {
        service = new BirthdayService(employees, messageSender);
    }

    @Test public void
    with_no_employees_a_greeting_message_is_not_sent() {
        when(employees.all()).thenReturn(noEmployees());

        service.sendGreetings(new XDate());

        verify(messageSender, never()).send(any(BirthdayGreeting.class));
    }

    private List<Employee> noEmployees() {
        return emptyList();
    }
}