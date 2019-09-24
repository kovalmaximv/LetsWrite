package com.NeuroActivity.letswrite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private @Id @GeneratedValue Long id;
    private String theme;
    private String description;
    private String text;
}
