package matteomoscardini.u5w2d2.services;

import matteomoscardini.u5w2d2.entities.Author;
import matteomoscardini.u5w2d2.entities.BlogPost;
import matteomoscardini.u5w2d2.exceptions.NotFoundException;
import matteomoscardini.u5w2d2.payloads.BlogPostPayload;
import matteomoscardini.u5w2d2.repositories.AuthorDao;
import matteomoscardini.u5w2d2.repositories.BlogPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BlogPostService {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    BlogPostDao blogPostDao;


    public List<BlogPost> getBlogPostList(){
        return this.blogPostDao.findAll();
    }

    public BlogPost saveBlogpost (BlogPostPayload body) {
        Author author = authorDao.findById(body.getAuthorId())
                .orElseThrow(() -> new NotFoundException(body.getAuthorId()));

        BlogPost newPost = new BlogPost(body.getCategory(), body.getTitle(), body.getCover(), body.getContent(), body.getReadingTime());
        newPost.setAuthor(author);

        return this.blogPostDao.save(newPost);
    }

    public BlogPost findById(int id) {
        return blogPostDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost){
        Optional<BlogPost> optionalBlogPost = blogPostDao.findById(id);

        if (optionalBlogPost.isPresent()) {
            BlogPost found = optionalBlogPost.get();
            found.setAuthor(optionalBlogPost.get().getAuthor());
            found.setTitle(optionalBlogPost.get().getTitle());
            found.setCategory(optionalBlogPost.get().getCategory());
            found.setContent(optionalBlogPost.get().getContent());
            return this.blogPostDao.save(found);
        } else {
            throw new NotFoundException(id);
        }
        }

    public void findByIdAndDelete(int id){
    Optional<BlogPost> optionalBlogPost = blogPostDao.findById(id);
    if (optionalBlogPost.isPresent()) {
        BlogPost found = optionalBlogPost.get();
        this.blogPostDao.delete(found);
    } else {
        throw new NotFoundException(id);
    }
    }
}
