package java8.effective;


import sun.misc.Cleaner;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-17 14:02
 */
public class Room implements AutoCloseable {

    private static class State implements Runnable {
        int num;

        State(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("clean room");
            num = 0;
        }
    }

    private final State state;
    private final Cleaner cleaner;

    public Room(int num) {
        state = new State(num);
        cleaner = Cleaner.create(this, state);
    }

    @Override
    public void close() throws Exception {
        cleaner.clean();
    }

    public static void main(String[] args) {
//        try (Room room=new Room(7)){
//            System.out.println("a");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        new Room(99);
        System.gc();
    }

}