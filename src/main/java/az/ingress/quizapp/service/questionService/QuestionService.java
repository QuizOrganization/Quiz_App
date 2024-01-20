package az.ingress.quizapp.service.questionService;


import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface QuestionService {
    QuestionDto getQuestion(UUID id);
    QuestionDto createOrUpdate(UUID id, QuestionDto questionDto);
    void delete(UUID Id);
    Page<QuestionDto> searchQuestions(UUID parentId, Pageable pageable);
}
