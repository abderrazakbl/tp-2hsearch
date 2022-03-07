package fr.univtln.dapm.bda.hsearch_elasticsearch.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
@Embeddable
@Entity
@Indexed
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	@FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
	private String title;
	@FullTextField(analyzer = "m1_did_analyzer", projectable = Projectable.YES, termVector = TermVector.WITH_POSITIONS_OFFSETS)
	@Lob
	private String content;
	private transient double score;

    @ManyToOne
	@IndexedEmbedded(structure = ObjectStructure.NESTED)
	private Author author;

	@ManyToOne
	@IndexedEmbedded(structure = ObjectStructure.NESTED)
	private Genre genre;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", content="
				+ (content.length() < 50 ? content.toString() : content.substring(0, 50)) + " - " +author.getListBook()+ " - "+getAuthor() +"]";
	}

}
