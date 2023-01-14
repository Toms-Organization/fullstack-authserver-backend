package springsecdatajpa.demo.service;


import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.repository.BlogPostRepository;

import java.util.List;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;


    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost getBlogByTopic(String topic){
        return blogPostRepository.findByTopic(topic);
    }

    public void saveBlogPost(BlogPost blogPost1) {
        blogPostRepository.save(blogPost1);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }
}
