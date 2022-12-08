abstract class DataStore {

    public abstract String[] allKeys(ElasticERL erl);

    public  abstract void add(ElasticERL erl, String key, String value);

    public abstract  void remove(ElasticERL erl, String key);

    public abstract  String getValue(ElasticERL erl, String key);

    public abstract  String nextKey(ElasticERL erl, String key);

    public abstract  String prevKey(ElasticERL erl, String key);

    public abstract  int rangeKey(String key1, String key2);
}
