package fr.univtln.dapm.bda.hsearch_elasticsearch.search;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class M1DidAnalyzer implements LuceneAnalysisConfigurer {//ElasticsearchAnalysisConfigurer

	@Override
	public void configure(LuceneAnalysisConfigurationContext context) {
		context.analyzer("m1_did_analyzer").custom().tokenizer(StandardTokenizerFactory.class)
				.tokenFilter(LowerCaseFilterFactory.class).tokenFilter(StopFilterFactory.class)
				.tokenFilter(ASCIIFoldingFilterFactory.class).tokenFilter(SnowballPorterFilterFactory.class)
				.param("language", "English").tokenFilter(EdgeNGramFilterFactory.class).param("minGramSize", "3")
				.param("maxGramSize", "7");
	}

}
