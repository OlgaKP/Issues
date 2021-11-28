package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issues;
import ru.netology.repository.IssuesRepo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {
    private IssuesManager manager = new IssuesManager();

    Issues iss1 = new Issues(1, "Iss1", 10, "D1", "qweert", "11.01.2020", true, "Lena", "status", "Oleg");
    Issues iss2 = new Issues(2, "Iss2", 12, "D2", "q1234", "22.11.2014", false, "Olga", "theme", "Vic");
    Issues iss3 = new Issues(3, "Iss3", 11, "D3", "w2345", "11.01.2001", true, "Max", "component", "KOP");
    Issues iss4 = new Issues(4, "Iss4", 22, "D4", "q1234t", "06.03.2000", false, "Den", "type", "Vic");

    @BeforeEach
    public void setUp() {
        manager.addIssue(iss1);
        manager.addIssue(iss2);
        manager.addIssue(iss3);
        manager.addIssue(iss4);
    }

    @Test
    void shouldShowOpenedIssues() {
        Collection<Issues> actual = manager.openedIssues();
        Collection<Issues> expected = List.of(iss1, iss3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowClosedIssues() {
        Collection<Issues> actual = manager.closedIssues();
        Collection<Issues> expected = List.of(iss2, iss4);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowAuthorIssues() {
        Collection<Issues> actual = manager.filterByAuthor("Lena");
        Collection<Issues> expected = List.of(iss1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowAssigneeIssues() {
        Collection<Issues> actual = manager.filterByAssignee("Vic");
        Collection<Issues> expected = List.of(iss2, iss4);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowLabelIssues() {       // How to use SET????????????????????
        Collection<Issues> actual = manager.filterByLabel("type");
        Collection<Issues> expected = List.of(iss4);
        assertEquals(expected, actual);
    }

}