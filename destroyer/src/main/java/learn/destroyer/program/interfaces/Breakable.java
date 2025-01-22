package learn.destroyer.program.interfaces;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;
import learn.destroyer.program.item.Item;
import learn.destroyer.program.item.Shard;

public interface Breakable {
    public Shard breakItem() throws ItemIsAlreadyBroken;
    public Shard breakItem(Item item) throws ItemIsAlreadyBroken;
    public Shard breakItem(Shard shard) throws ItemIsAlreadyBroken;
    public boolean isBroken();
}
