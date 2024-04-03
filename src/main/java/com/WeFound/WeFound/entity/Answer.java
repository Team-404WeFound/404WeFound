package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.AnswerResponseDTO;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "answer")
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Answer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answer_id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")//게시물 작성자 id
    //private Long user_id;
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")//게시물 id
    //private Long question_id;
    private Question question;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime create_at;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime update_at;


    @Builder
    public Answer(Long answer_id,String content,User user,Question question,LocalDateTime create_at,LocalDateTime update_at){
        this.answer_id = answer_id;
        this.content = content;
        this.user = user;
        this.question = question;
        this.create_at = create_at;
        this.update_at = update_at;
    }



    public void update(String content) {
        this.content=content;
    }

    public AnswerResponseDTO toResponse() {
        return AnswerResponseDTO.builder()
                .answer_id(answer_id)
                .content(content)
                .create_at(create_at)
                .update_at(update_at)
                .build();
    }


}