package fr.univtln.dapm.bda.hsearch_elasticsearch;

import java.io.IOException;
import java.util.*;

import fr.univtln.dapm.bda.hsearch_elasticsearch.domain.Author;
import fr.univtln.dapm.bda.hsearch_elasticsearch.domain.Book;
import fr.univtln.dapm.bda.hsearch_elasticsearch.domain.Genre;
import fr.univtln.dapm.bda.hsearch_elasticsearch.search.IndexSearchApi;

public class Main {
	public static void main(String[] args) throws IOException {

		// Instanciation de notre classe IndexSearchApi pour indexer et rechercher
		IndexSearchApi api = new IndexSearchApi();

		// Réindexation à chaque nouvel appel de la classe Main (à commenter si besoin).
		api.purgeIndex();
		api.indexFilesInFolder(Main.class.getResource("/data/raw").getFile());

		// Recherche.
		System.out.println("Recherche de 'pilgrime tale' dans le titre : "
				+ api.searchInTitle("pilgrimge tale"));
		System.out.println("Recherche du mot-clé 'soldier' dans le content : "
				+ api.searchInContent("soldier"));
		System.out.println("Recherche exacte de  'Produced by John Bickers' dans le contenue : "
				+ api.PhrasesearchInContent("Produced by John Bickers"));
		System.out.println("Recherche exacte d'un titre et d'un content : "
				+ api.searchTitleContent("Eric Brighteyes 2721.txt","Produced by John Bickers"));
		Genre genre = new Genre();
		genre.setType("drama");
		genre.setDescription("save the drama for your moma");
		Author author = new Author();
		author.setFirstName("abderrazzak");
		author.setLastName("boulaghla");
		author.setBiography("just a geeks life ");
		Book book = new Book();
		book.setId(4);
		book.setContent("nothing to do here");
		book.setTitle("Allan's Wife 2727.txt");
		List<Book> list = new ArrayList<>();
		list.add(book);
		author.setListBook(list);

		System.out.println("Le livre de l'auteur abderrazzak boulaghla : "
				+ api.searchAuthor("abderrazzak", "boulaghla"));
		System.out.println("Le livre du genre abderrazzak boulaghla est : "
				+ api.searchGenre("abderrazzak", "boulaghla"));
		System.exit(0);
	}
}
