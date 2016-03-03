package ro.bogdanlyex.handlers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ro.bogdanlyex.events.CommentSaved;

@Component
public class CommentHandler {

    @Async
    @EventListener
    public void commentAddedAsync(CommentSaved commentSaved) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(commentSaved.getComment());
    }
}
