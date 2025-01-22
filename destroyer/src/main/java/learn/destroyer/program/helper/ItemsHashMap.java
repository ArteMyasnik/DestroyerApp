package learn.destroyer.program.helper;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;
import learn.destroyer.program.item.Item;
import learn.destroyer.program.item.Shard;

import java.util.HashMap;
import java.util.Map;

public class ItemsHashMap {
    private final Map<String, Item> items;

    public Map<String, Item> getItems() {
        return items;
    }

    public void printItems() {
        items.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public ItemsHashMap() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public void removeItem(String name) {
        items.remove(name);
    }

    public void breakItem(String weapon, String target) throws ItemIsAlreadyBroken {
        var weaponItem = items.get(weapon);
        var targetItem = items.get(target);
        if (weaponItem != null && targetItem != null) {
            var brokenItem = weaponItem.breakItem(targetItem);
            if (!brokenItem.isBroken()) {
                items.put(brokenItem.getName(), brokenItem);
            } else {
                items.remove(brokenItem.getName());
            }
        }
    }
}
