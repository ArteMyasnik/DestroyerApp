package learn.destroyer.program.item;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;
import learn.destroyer.program.interfaces.Breakable;

import java.util.Objects;

public class Item implements Breakable {
    private final boolean isBroken;
    private final String name;
    private static int counterItems = 0;

    protected Item() {
        this.name = "UnknownItem" + counterItems;
        this.isBroken = false;
        counterItems++;
    }

    protected Item(String name) {
        this.name = name;
        this.isBroken = false;
        counterItems++;
    }

    public static Item create() {
        return new Item();
    }

    public static Item create(String name) {
        return new Item(name);
    }

    public static Item create(String name, boolean isBroken) {
        if (isBroken) {
            return new Shard(name);
        } else {
            return new Item(name);
        }
    }

    public Shard breakItem() throws ItemIsAlreadyBroken{
        if (this.isBroken()) {
            throw new ItemIsAlreadyBroken("Item " + this.getName() + " is already broken!");
        }
        System.out.println("Объект " + this.getName() + " сломался!");
        Item.counterItems--;
        return new Shard(this.getName());
    }

    public Shard breakItem(Item item) throws ItemIsAlreadyBroken{
        if (item.isBroken()) {
            throw new ItemIsAlreadyBroken("Item " + item.getName() + " is already broken!");
        } else if (item.equals(this)) {
            Item.counterItems--;
            return this.breakItem();
        }
        System.out.println("Вы сломали " + item.getName() + " с помощью " + this.getName() + "!");
        Item.counterItems--;
        return new Shard(item.getName());
    }

    public Shard breakItem(Shard shard) throws ItemIsAlreadyBroken{
        if (shard.isBroken()) {
            throw new ItemIsAlreadyBroken("Item " + shard.getName() + " is already broken!");
        } else if (shard.equals(this)) {
            return this.breakItem();
        }
        System.out.println("Вы сломали " + shard.getName() + " с помощью " + this.getName() + " и он разлетелся на мелкие кусочки!");
        return new BrokenShard(shard.getName());
    }






    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public static int getCounterItems() {
        return counterItems;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isBroken() == item.isBroken() && Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBroken(), getName());
    }

    @Override
    public String toString() {
        return "Item{" +
                "isBroken=" + isBroken +
                ", name='" + name + '\'' +
                '}';
    }
}
