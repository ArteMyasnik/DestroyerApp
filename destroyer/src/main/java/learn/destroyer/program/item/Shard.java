package learn.destroyer.program.item;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;

public class Shard extends Item{
    private static int counterShards = 0;
    private final boolean isBroken;

    protected Shard(String name) {
        super(name);
        counterShards++;
        isBroken = false;
    }

    @Override
    public boolean isBroken() {
        return isBroken;
    }

    public Shard breakItem() throws ItemIsAlreadyBroken {
        if (this.isBroken()) {
            throw new ItemIsAlreadyBroken("Item " + this.getName() + " is already broken!");
        }
        System.out.println("Объект " + this.getName() + " разлетается на мелкие кусочки!");
        Shard.counterShards--;
        return new BrokenShard(this.getName());
    }

    @Override
    public Shard breakItem(Item item) throws ItemIsAlreadyBroken {
        return super.breakItem(item);
    }

    @Override
    public Shard breakItem(Shard shard) throws ItemIsAlreadyBroken {
        Shard.counterShards--;
        return super.breakItem(shard);
    }
}