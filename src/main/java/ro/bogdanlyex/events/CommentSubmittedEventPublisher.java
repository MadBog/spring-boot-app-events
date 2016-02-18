package ro.bogdanlyex.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import ro.bogdanlyex.entities.Comment;

@Component
public class CommentSubmittedEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publishSubmittedComment(Comment comment) {
        publisher.publishEvent(new CommentSubmitted(this, comment));
    }
}
