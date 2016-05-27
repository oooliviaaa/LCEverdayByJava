package KeyValueCache;

/**
 * Created by shuailu on 5/27/16.
 */

public interface DataSource<K, T> {

    T get(K key);
}
