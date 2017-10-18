import Event.Event;
import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * Created by phanindra on 18/10/17.
 */
public class MapDbTest {

    @Test
    public void saveEventsToDB() {
        Event event = new Event();
        DB eventsDB = DBMaker.newFileDB(new File("eventsDB")).closeOnJvmShutdown().make();
        Map<Integer, Event> map = eventsDB.getHashMap("Events");

        Set<Integer> keys = map.keySet();
        int id=0;
        for(int key : keys) {
            id++;
        }
        map.put(id+1, event);
        eventsDB.commit();
        eventsDB.close();
    }

    @Test

    public void readEventsFromDB() {
        Event event = new Event();
        DB eventsDB = DBMaker.newFileDB(new File("eventsDB")).closeOnJvmShutdown().make();
        Map<Integer, Event> map = eventsDB.getHashMap("Events");

        Set<Integer> keys = map.keySet();
        int id=0;
        for(int key : keys) {
            id++;
        }
        map.put(id+1, event);
        System.out.println(map.size());
        eventsDB.commit();
        eventsDB.close();
    }



}
