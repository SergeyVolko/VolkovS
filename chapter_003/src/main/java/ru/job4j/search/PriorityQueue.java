package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 26.03.2018
 */

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        int index = (int) tasks.stream().filter(task1 -> task1.getPriority() < task.getPriority()).count();
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }


    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 7));
        queue.put(new Task("middle", 3));
        queue.put(new Task("new", 1));
        Task result = queue.take();
        System.out.println(result.getDesc());
    }
}
