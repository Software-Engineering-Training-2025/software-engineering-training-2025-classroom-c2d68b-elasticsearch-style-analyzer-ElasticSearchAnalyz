package org.example.analyzer.charfilter;

import org.example.analyzer.enums.CharFilterType;

public class CharFilterFactory {
    public static CharFilter getCharFilterType(CharFilterType type) {
        if(type == CharFilterType.HTML_STRIP) {
            return new HtmlStrip();
        }
        if(type == CharFilterType.MAPPING_SMART_QUOTES) {
            return new MappingSmartQuotes();
        }
        if(type == CharFilterType.NORMALIZE_DASHES) {
            return new NormalizeDash();
        }
        throw new RuntimeException("not supported");
    }
}
