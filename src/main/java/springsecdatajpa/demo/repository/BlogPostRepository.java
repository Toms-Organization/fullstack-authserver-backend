package springsecdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecdatajpa.demo.entity.BlogPost;


public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {


    BlogPost findByTopic(String topic);


}
