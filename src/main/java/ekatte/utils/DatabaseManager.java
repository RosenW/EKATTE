package ekatte.utils;

import ekatte.entities.Area;
import ekatte.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public class DatabaseManager {
    public void saveDataToDB(String data, JpaRepository repository) {
        String[] rows = data.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            if(i>1){
                String[] cols = row.split("@@");
                Municipality municipality = new Municipality();

                municipality.setId(cols[0].substring(3));
//                municipality.set(cols[0].substring(3,5));
//                municipality.setId(cols[0].substring(3,5));
//                repository.save(area);
            }
        }
    }
}
