package org.example.analyzer.invertedindex;

import org.example.analyzer.Analyzer;
import org.example.analyzer.Token;

import java.util.*;

public class InvertedIndexServiceImpl implements InvertedIndexService {
    private Analyzer analyzer;
    private Map<String, Set<String>> invertedIndex = new HashMap<>();
    public InvertedIndexServiceImpl(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void addDocument(String id, String text){
        // analyze
        List<Token> tokenList = analyzer.analyze(text);
        // add all tokens
        for(Token token: tokenList) {
            Set<String> documents = invertedIndex.getOrDefault(token.term,
                    new HashSet<>());
            documents.add(id);
            invertedIndex.put(token.term, documents);
        }
    }
    public List<String> search(String queryText) {
        List<Token> tokenList = analyzer.analyze(queryText);
        Map<String, Integer> documentCount = new HashMap<>();

        for(Token token: tokenList) {
            Set<String> documents = invertedIndex.get(token.term);
            for(String doc: documents) {
                documentCount.put(doc,
                        documentCount.getOrDefault(doc, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(documentCount.keySet());
        result.sort((t1, t2) -> {
            if(Objects.equals(documentCount.get(t1), documentCount.get(t2)))
                return t1.compareTo(t2);
            return documentCount.get(t1) - documentCount.get(t2);
        });
        return result;
    }
}
