package ru.netology.repository;

import ru.netology.domain.Issues;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IssuesRepo {
    private Collection<Issues> issues = new LinkedList<>();
//    HashSet<Issues> set = new HashSet<>();

    public void save(Issues issue) {
        issues.add(issue);
    }

    public void saveAll(Collection<Issues> issues) {
        this.issues.addAll(issues);
    }

    public Collection<Issues> findAll() { return this.issues; }
//    public HashSet<Issues> findAll() {
//        return this.set;
//    }

    public boolean openIssue(Issues issue) {
        return issue.isOpen();
    }

}
