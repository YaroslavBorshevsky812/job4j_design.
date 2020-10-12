package Generics.AppStore;

import java.util.ArrayList;
import java.util.List;

public class RoleStore<T extends Base> implements Store<T>{

    private final List<T> roles = new ArrayList<>();

    @Override
    public void add(T model) {
        roles.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public T findById(String id) {

        return null;
    }
}
