package matteomoscardini.u5w2d2.controllers;


import matteomoscardini.u5w2d2.entities.BlogPost;
import matteomoscardini.u5w2d2.payloads.BlogPostPayload;
import matteomoscardini.u5w2d2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    private List<BlogPost> getAllBlogPosts() {
        return this.blogPostService.getBlogPostList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPostPayload body){
        return this.blogPostService.saveBlogpost(body);
    }

    @GetMapping("/{blogPostId}")
    private BlogPost getSingleBlogPost(@PathVariable int blogPostId){
        return this.blogPostService.findById(blogPostId);
    }

    @PutMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private BlogPost findSinglePostAndUpdate(@PathVariable int blogPostId, @RequestBody BlogPost body){
        return this.blogPostService.findByIdAndUpdate(blogPostId, body);
    }
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBlogPost(@PathVariable int blogPostId){
        this.blogPostService.findByIdAndDelete(blogPostId);
    }
}
