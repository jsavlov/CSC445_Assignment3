package StateMachinePackage;

import io.atomix.copycat.Query;

/*

 */
public class Get implements Query<Object> {
    public Object key;

    public Get() {
    }

    public Get(Object key) {
        this.key = key;
    }
}
