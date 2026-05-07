package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class PriorityQuestIterator implements QuestIterator {

    private final List<Quest> filtered;
    private int index = 0;

    public PriorityQuestIterator(List<Quest> quests, QuestPriority priority) {
        this.filtered = new ArrayList<>();

        for (Quest q : quests) {
            if (q.getPriority() == priority) {
                filtered.add(q);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < filtered.size();
    }

    @Override
    public Quest next() {
        return filtered.get(index++);
    }
}
