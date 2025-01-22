package learn.destroyer.program.item;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;

public class BrokenShard extends Shard{


    protected BrokenShard(String name) {
        super(name);
    }

    @Override
    public boolean isBroken() {
        return true;
    }

    @Override
    public Shard breakItem() throws ItemIsAlreadyBroken {
        throw new ItemIsAlreadyBroken("Item " + this.getName() + " is already broken!");
    }

    @Override
    public Shard breakItem(Item item) throws ItemIsAlreadyBroken {
        throw new ItemIsAlreadyBroken("Item " + this.getName() + " is already broken!");
    }
}
