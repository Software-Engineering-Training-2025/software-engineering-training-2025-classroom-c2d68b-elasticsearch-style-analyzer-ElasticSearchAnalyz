package org.example.analyzer.invertedindex;

public abstract class InvertedIndexDecorator implements InvertedIndexService {
    protected InvertedIndexService wrapper;

    public InvertedIndexDecorator(InvertedIndexService invertedIndexService) {
        wrapper = invertedIndexService;
    }

}
