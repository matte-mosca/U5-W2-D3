package matteomoscardini.u5w2d2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostPayload {

    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
    private int authorId;
}
