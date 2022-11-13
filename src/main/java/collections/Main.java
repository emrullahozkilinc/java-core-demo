package collections;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        WebHistory history1 = new WebHistory();
        history1.setUrl(new URL("https://www.google.com"));
        history1.setCreationDate(LocalDateTime.now());

        WebHistory history2 = new WebHistory();
        history2.setUrl(new URL("https://www.youtube.com"));
        history2.setCreationDate(LocalDateTime.now());

        WebHistory history3 = new WebHistory();
        history3.setUrl(new URL("https://www.stackoverflow.com"));
        history3.setCreationDate(LocalDateTime.now());


        Deque<WebHistory> deque = new ArrayDeque();

        //add
        deque.add(history1);
        deque.addFirst(history2);
        deque.addLast(history3);

        //get last and first
        deque.getFirst();
        deque.getLast();

    }
}
