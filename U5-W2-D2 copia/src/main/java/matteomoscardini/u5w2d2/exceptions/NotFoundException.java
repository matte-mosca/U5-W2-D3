package matteomoscardini.u5w2d2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id){
        super("L'elemento con id " + id + " non è stato trovato");
    }
}
