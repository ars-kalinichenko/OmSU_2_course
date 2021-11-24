package com.imit.tasks.third;

public class ContainsStringFilter implements IFilter {
    private final String pattern;

    public ContainsStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public Boolean apply(String sentence) {
        return sentence.contains(pattern);
    }
}
