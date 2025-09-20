package org.example.analyzer.invertedindex;

import java.util.List;

public class TimedInvertedIndex extends InvertedIndexDecorator{

    public TimedInvertedIndex(InvertedIndexService invertedIndexService){
        super(invertedIndexService);
    }
    @Override
    public void addDocument(String id, String text) {
        long start = System.currentTimeMillis();
        wrapper.addDocument(id, text);
        long end = System.currentTimeMillis();
        System.out.println("Add document time " + (end - start));
    }

    @Override
    public List<String> search(String textQuery) {
        long start = System.currentTimeMillis();
        List<String> results = wrapper.search(textQuery);
        long end = System.currentTimeMillis();
        System.out.println("Search time " + (end - start));
        return results;
    }
}
