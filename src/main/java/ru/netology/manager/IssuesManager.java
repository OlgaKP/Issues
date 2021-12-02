package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepo;

import java.util.*;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepo repo = new IssuesRepo();

    public IssuesManager(IssuesRepo repo) {  this.repo = repo; }
    public IssuesManager() {    }

    Collection<Issue> issues = repo.findAll();

    // added issue
    public void addIssue(Issue issue) {
        repo.save(issue);
    }

    // list of opened, closed
    public Collection<Issue> openedIssues() {
        Collection<Issue> result = new LinkedList<>();
        for (Issue issue: issues) {
            if (issue.isOpen()) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> closedIssues() {
        Collection<Issue> result = new LinkedList<>();
        for (Issue issue: issues) {
            if (!issue.isOpen()) {
                result.add(issue);
            }
        }
        return result;
    }

    // filter: author, assignee, label
    public Collection<Issue> findBy(Predicate<Issue> filter) {
        Collection<Issue> result = new LinkedList<>();
        for (Issue issue: issues) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> filterByAuthor(String text) {
//        Collection<Issues> result = new LinkedList<>();
//        for (Issues issue: issues) {
//            if (issue.getAuthor().contains(text)) {
//                result.add(issue);
//            }
//        }
//        return result;
        return findBy(issue -> issue.getAuthor().equals(text));
//        return findBy(issue -> issue.getAuthor().equalsIgnoreCase(text));
    }

    public Collection<Issue> filterByAssignee(String text) {
        return findBy(issue -> issue.getAssignee().contains(text));
    }

    public Collection<Issue> filterByLabel(String text) {
        return findBy(issue -> issue.getLabel().contains(text));
    }

    // to open, to close Issues
    public void toOpenIssue(int id) {
        for (Issue issue: issues) {
            if (!issue.isOpen() && issue.getId() == id) {
                issue.setOpen(true);
            }
        }
    }

    public void toCloseIssue(int id) {
        for (Issue issue: issues) {
            if (issue.isOpen() && issue.getId() == id) {
                issue.setOpen(false);
            }
        }
    }
}
