public class ElasticERL extends DataStore {

    int EINThreshold;
    DataStore store;
    public ElasticERL(int size){
        if (size < 25000){
            store = new smallData();
        } else if (size >= 25000){
            store = new bigData();
        }

    }

    private void SetEINThreshold (int size){
        this.EINThreshold = size;
    }

    public String generate(){
        int min = 10000000;
        int max = 99999999;

        int generatedKey = (int)Math.floor(Math.random()*(max-min+1)+min);
        return String.valueOf(generatedKey);
    }

    public String[] allKeys(ElasticERL erl) {return this.store.allKeys(erl);}
    public void add(ElasticERL erl, String key, String value) {
        this.store.add(erl,key,value);
    }
    public void remove(ElasticERL erl, String key) {this.store.remove(erl,key);}
    public String getValue(ElasticERL erl, String key) {
        return this.store.getValue(erl,key);
    }
    public String nextKey(ElasticERL erl, String key) {
        return this.store.nextKey(erl,key);
    }
    public String prevKey(ElasticERL erl, String key) {return this.store.prevKey(erl,key);}
    public int rangeKey(String key1, String key2) {
        return this.store.rangeKey(key1, key2);
    }
}
//for small data set we decided to choose a doubly linked list
class smallData extends DataStore {

    LinkedListCustom list = new LinkedListCustom();

    //Return keys works!
    public String[] allKeys(ElasticERL erl) {return this.list.print();}

    //Works
    public void add(ElasticERL erl, String key, String value) {list.addNode(key,value);}

    //works
    public void remove(ElasticERL erl, String key) {list.deleteValue(key);}

    //works
    public String getValue(ElasticERL erl, String key) {return list.getValue(key);}

    //works
    public String nextKey(ElasticERL erl, String key) {return list.nextKey(key);}

    //works
    public String prevKey(ElasticERL erl, String key) {return list.prevKey(key);}
    //works
    public int rangeKey(String key1, String key2) {return list.rangeKey(key1,key2);}



}

class bigData extends DataStore {

    MyAvlTree MAT = new MyAvlTree();

    public String[] allKeys(ElasticERL erl) {
//        return MAT.allKeys();
        return new String[0];
    }
    public void add(ElasticERL erl, String key, String value) {
        MAT.insertElement(key,value);
    }
    public void remove(ElasticERL erl, String key) {}
    public String getValue(ElasticERL erl, String key) {
        return String.valueOf(MAT.searchElement(key));
    }
    public String nextKey(ElasticERL erl, String key) {
        return key;
    }
    public String prevKey(ElasticERL erl, String key) {
        return key;
    }
    public int rangeKey(String key1, String key2) {
        return 0;
    }

}



