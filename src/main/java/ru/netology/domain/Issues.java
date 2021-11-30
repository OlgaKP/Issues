package ru.netology.domain;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Issues{
    private int id;
    private String title;
    private int number;
    private int date;
    private boolean open;
    private String author;
    private Set<String> label;
    private Set<String> assignee;
}

