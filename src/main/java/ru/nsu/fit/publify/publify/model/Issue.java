package ru.nsu.fit.publify.publify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "issue")
@Getter
@Setter
@Accessors(chain = true)
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer number;
    private Date releaseDate;
    private String cover;
    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

}
