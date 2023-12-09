package ru.nsu.fit.publify.publify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.nsu.fit.publify.publify.enums.ContentType;

@Table(name = "article_item")
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class ArticleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Enumerated(EnumType.STRING)
    private ContentType contentType;
    private Integer sequenceNumber;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
