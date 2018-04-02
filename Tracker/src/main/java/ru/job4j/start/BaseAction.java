package ru.job4j.start;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final String name, final int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s %s", this.name, this.key);
    }
}
