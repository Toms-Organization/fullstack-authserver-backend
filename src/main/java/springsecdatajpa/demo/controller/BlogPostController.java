package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.service.BlogPostService;

import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }


    @GetMapping("/getoneblogpostfromtopicname")
    public BlogPost getBlogPostByTopic(@RequestParam String topic){
       return blogPostService.getBlogByTopic(topic);
    }


    @GetMapping("/getallposts")
    public List<BlogPost> getBlogPostByTopic(){
        return blogPostService.getAllBlogPosts();
    }



}
