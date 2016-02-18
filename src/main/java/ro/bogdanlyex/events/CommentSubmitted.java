package ro.bogdanlyex.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ro.bogdanlyex.entities.Comment;

public class CommentSubmitted extends ApplicationEvent {

    @Getter
    private Comment comment;

    public CommentSubmitted(Object source, Comment comment) {
        super(source);
        this.comment = comment;
    }



}
