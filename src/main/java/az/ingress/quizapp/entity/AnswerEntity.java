package az.ingress.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerEntity {

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    UUID id;

    @NotBlank
    String label;

    @NotBlank
    String description;

    boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @Getter(AccessLevel.NONE)
    az.ingress.quiz.domain.QuestionEntity question;
}
