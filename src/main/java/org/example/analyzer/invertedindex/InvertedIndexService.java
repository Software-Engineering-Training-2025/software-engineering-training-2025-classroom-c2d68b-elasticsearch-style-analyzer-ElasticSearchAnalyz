package org.example.analyzer.invertedindex;

import java.util.List;

public interface InvertedIndexService {
    void addDocument(String id, String text);
    List<String> search(String textQuery);
}
