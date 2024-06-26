package matteomoscardini.u5w2d2.services;

import matteomoscardini.u5w2d2.entities.Author;
import matteomoscardini.u5w2d2.exceptions.NotFoundException;
import matteomoscardini.u5w2d2.repositories.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthorService {
    List<Author> authorList = new ArrayList<>();

    @Autowired
    AuthorDao authorDao;

    public List<Author> getAuthorList (){
        return this.authorDao.findAll();
    }

    public Author saveAuthor (Author newAuthor){
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + newAuthor.getName() + "+" + newAuthor.getSurname());
        return authorDao.save(newAuthor);
    }

    public Author findAuthorById(int id){
       return authorDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author findAuthorByIdAndUpdate(int id, Author updatedBody){
        Optional<Author> optionalAuthor = authorDao.findById(id);

        if (optionalAuthor.isPresent()) {
            Author found = optionalAuthor.get();
            found.setName(updatedBody.getName());
            found.setSurname(updatedBody.getSurname());
            found.setBirthDay(updatedBody.getBirthDay());
            return this.authorDao.save(found);
        } else {
            throw new NotFoundException(id);
        }
    }
    public void findAuthorByIdAndDelete(int id){
        Optional <Author> optionalAuthor = authorDao.findById(id);
        if (optionalAuthor.isPresent() ) {
            Author found = optionalAuthor.get();
            this.authorDao.delete(found);
        } else  {
            throw new NotFoundException(id);
        }
    }
}
