package ru.netology.manager;

import ru.netology.domain.Issues;
import ru.netology.repository.IssuesRepo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepo repo = new IssuesRepo();

    public IssuesManager(IssuesRepo repo) {  this.repo = repo; }
    public IssuesManager() {    }

    Collection<Issues> issues = repo.findAll();

    // added issue
    public void addIssue(Issues issue) {
        repo.save(issue);
    }

    // list of opened, closed
    public Collection<Issues> openedIssues() {
        Collection<Issues> result = new LinkedList<>();
        for (Issues issue: issues) {
            if (repo.openIssue(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issues> closedIssues() {
        Collection<Issues> result = new LinkedList<>();
        for (Issues issue: issues) {
            if (!repo.openIssue(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    // filter: author, assignee, label???
    public Collection<Issues> findBy(Predicate<Issues> filter) {
        Collection<Issues> result = new LinkedList<>();
        for (Issues issue: issues) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issues> filterByAuthor(String text) {
//        Collection<Issues> issues = repo.findAll();
//        Collection<Issues> result = new LinkedList<>();
//        for (Issues issue: issues) {
//            if (issue.getAuthor().contains(text)) {
//                result.add(issue);
//            }
//        }
//        return result;
        return findBy(issue -> issue.getAuthor().equalsIgnoreCase(text));
    }

    public Collection<Issues> filterByAssignee(String text) {
        return findBy(issue -> issue.getAssignee().equals(text));
    }

    // How to use SET????????????????????
    public Collection<Issues> filterByLabel(String text) {
        return findBy(issue -> issue.getLabel().equals(text));
    }

    // to open, to close Issues
    public void newIssue(int id) {
        Collection<Issues> result = new LinkedList<>();
        // How to create new issue on id????????????????????
    }

    public void closeIssue(int id) {
        Collection<Issues> result = new LinkedList<>();
        for (Issues issue: issues) {
            if (repo.openIssue(issue) && issue.getId() == id) {
                issue.isOpen() = false;  //???????
                result.add(issue);
            }
        }
    }

}
