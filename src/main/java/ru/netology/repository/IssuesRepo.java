package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IssuesRepo {
    private Collection<Issues> issues = new LinkedList<>();

    public void save(Issues issue) {
        issues.add(issue);
    }

    public void saveAll(Collection<Issues> issues) {
        this.issues.addAll(issues);
    }

    public Collection<Issues> findAll() { return this.issues; }

    public boolean openIssue(Issues issue) {
        return issue.isOpen();
    }

}
