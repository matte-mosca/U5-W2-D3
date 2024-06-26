package matteomoscardini.u5w2d2.controllers;

import matteomoscardini.u5w2d2.entities.Author;
import matteomoscardini.u5w2d2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return this.authorService.getAuthorList();
    };

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Author saveAuthor(@RequestBody Author body){
        return this.authorService.saveAuthor(body);
    }

    @GetMapping ("/{authorId}")
    private Author getSingleAuthor(@PathVariable int authorId) {
        return this.authorService.findAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private void deleteAuthor(@PathVariable int authorId) {
        this.authorService.findAuthorByIdAndDelete(authorId);
    }
}
