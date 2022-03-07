package fr.univtln.dapm.bda.hsearch_elasticsearch.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

/**
 * Entité indexable représentant un genre.
 *
 * @author vincent
 *
 */

@Entity
@Indexed
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
    private String type;
    @FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
    private String description;

    @OneToMany (mappedBy = "genre")
    private List<Book> listBook;


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Genre{" +"id=" + id +", type='" + type + '\'' +", description='" + description + '\'' +'}';
    }

}
