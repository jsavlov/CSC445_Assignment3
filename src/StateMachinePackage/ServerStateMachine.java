package StateMachinePackage;

import io.atomix.copycat.server.Commit;
import io.atomix.copycat.server.StateMachine;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class ServerStateMachine extends StateMachine {
    private Map<Object, Object> map = new HashMap<>();

    public Object put(Commit<PutCommand> commit) {
        try {
            map.put(commit.operation().key(), commit.operation().value());
        } finally {
            commit.close();
        }
        return null;
    }

    public Object get(Commit<GetQuery> commit) {
        try {
            return map.get(commit.operation().key());
        } finally {
            commit.close();
        }
    }

}
