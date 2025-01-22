package learn.destroyer.program;

import learn.destroyer.program.exceptions.checked.ItemIsAlreadyBroken;
import learn.destroyer.program.helper.ItemsHashMap;
import learn.destroyer.program.item.Item;

public class Program {
    public void program() throws ItemIsAlreadyBroken {

        var manager = new ItemsHashMap();

        var unknown0 = Item.create();
        var unknown1 = Item.create();
        var unknown2 = Item.create();

        var chair = Item.create("Chair");
        var table = Item.create("Table", true);

        manager.addItem(chair);
        manager.addItem(table);
        manager.addItem(unknown0);
        manager.addItem(unknown1);
        manager.addItem(unknown2);

        manager.breakItem(chair.getName(), chair.getName());

        manager.breakItem(table.getName(), table.getName());
        manager.breakItem(table.getName(), table.getName());
    }
}
