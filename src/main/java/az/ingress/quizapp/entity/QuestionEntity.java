package az.ingress.quizapp.entity;

import az.ingress.quizapp.enums.QuestionResponseSelectionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedEntityGraph(
        name = "Question.answers",
        attributeNodes = @NamedAttributeNode("answers")
)
public class QuestionEntity {

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    UUID id;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    String description;

    @CreatedDate
    LocalDateTime createdAt;

    @NotNull
    @Max(11)
    Integer weight;

    @Enumerated(EnumType.STRING)
    QuestionResponseSelectionType type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    Set<az.ingress.quiz.domain.AnswerEntity> answers;
}
