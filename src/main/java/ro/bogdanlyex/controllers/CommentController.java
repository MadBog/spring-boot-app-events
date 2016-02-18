package ro.bogdanlyex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.bogdanlyex.entities.Comment;
import ro.bogdanlyex.events.CommentSubmittedEventPublisher;
import ro.bogdanlyex.repositories.CommentRepository;

@Controller
@RequestMapping
public class CommentController {


    @Autowired
    private CommentSubmittedEventPublisher commentSubmittedEventPublisher;

    @Autowired
    public CommentRepository commentRepository;

    @RequestMapping(value = "/comment")
    public String addComment(Model model) {
        model.addAttribute("commentModel", new Comment());
        return "comment";
    }

    @RequestMapping(value = "/comment/list")
    public String comments(Model model) {
        model.addAttribute("comments", commentRepository.findAll());
        return "commentList";
    }

    @RequestMapping(value = "/comment/save", method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("commentModel") Comment commentModel, BindingResult bindingResult) {
        commentModel.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        commentSubmittedEventPublisher.publishSubmittedComment(commentModel);
        return "redirect:/dashboard";
    }
}
