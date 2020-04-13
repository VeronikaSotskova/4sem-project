package ru.itis.semestrproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account author;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    private String title;

    @Lob
    private String content;

    @Builder.Default
    @OneToMany
    private List<Comment> comments = new LinkedList<>();
}
