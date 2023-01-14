package springsecdatajpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springsecdatajpa.demo.config.RsaKeyProperties;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.Authorities;
import springsecdatajpa.demo.entity.BlogPost;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.BlogPostService;
import springsecdatajpa.demo.service.LoginService;

import javax.annotation.PostConstruct;
import java.util.Set;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class DemoApplication {

	private final AppUserService appUserService;
	private final BlogPostService blogPostService;
	private final LoginService loginService;
	public DemoApplication(AppUserService appUserService, BlogPostService blogPostService, LoginService loginService) {
		this.appUserService = appUserService;
		this.blogPostService = blogPostService;
		this.loginService = loginService;
	}


	@PostConstruct
	public void initData() {
		// Add user
		//		AppUser u1 = new AppUser(3,"Bigge", "coolbigge", "bigge@gmail.com", Set.of(new Authorities(1, "read")));
		//		appUserService.saveAppUser(u1);


		// Add a blogpost

		//BlogPost blogPost1 = new BlogPost(1, "About me", "This is long text about me...");
		//BlogPost blogPost2 = new BlogPost(2, "Friday 13th", "Wonderful day that...");
		// blogPostService.saveBlogPost(blogPost1);
		//blogPostService.saveBlogPost(blogPost2);
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




}
