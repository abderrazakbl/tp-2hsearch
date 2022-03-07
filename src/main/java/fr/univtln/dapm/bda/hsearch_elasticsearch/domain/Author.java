package fr.univtln.dapm.bda.hsearch_elasticsearch.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

/**
 * Entité indexable représentant un author.
 *
 * @author vincent
 *
 */

@Entity
@Indexed
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
    private String firstName;
    @FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
    private String lastName;
    @FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
    private String Biography;

    @OneToMany(mappedBy = "author")
    private List<Book> listBook;

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    @Override
    public String toString() {
        return "Author [firstName=" + firstName + ", lastName=" + lastName + ", Biography="
                + getBiography()+"]";
    }

}
