package ru.netology.domain;
import java.util.LinkedList;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Issues {
    private int id;
    private String title;
    private int number;
    private String description;
    private String files;
    private String date;
    private boolean open;
    private String author;
    private String label;
    private String assignee;
}

