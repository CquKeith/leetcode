package DesignPattern.IteratorPattern.IterateNames;

/**
 * @author chenmengliang
 * @date 2019/10/9 19:40
 **/
public class NameRepository implements Container {

    String[] names;

    public NameRepository() {

        this.names = new String[10];
        for (int i = 0; i < 10; i++) {
            names[i] = "Name"+i;
        }
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }


    private class NameIterator implements Iterator {

        private int index;

        public NameIterator() {
            index = 0;
        }

        @Override
        public Object next() {

            String name = null;

            try {
                name = names[index++];
            } catch (Exception e) {
                e.printStackTrace();
            }

            return name;
        }

        @Override
        public boolean hasNext() {
            return index < names.length;
        }
    }



}

