import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(50);
        pq.add(40);
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(5);
        System.out.println(pq.peek());
        System.out.println(pq);

    }
}
