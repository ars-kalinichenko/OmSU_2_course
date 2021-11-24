package com.imit.tasks.third;

public class EndStringFilter implements IFilter {
    private final String pattern;

    public EndStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public Boolean apply(String sentence) {
        return sentence.endsWith(pattern);
    }
}
