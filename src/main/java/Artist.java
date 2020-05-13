import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Artist {
    private String name;
    private String origin;

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }
    public static List<String> getNamesAndOrigins(List <Artist> artists) {
        List<String> list = artists.stream()
                .map((Artist a) -> {return a.getName() + ", " + a.getOrigin();})
                .collect(Collectors.toList());
        return list;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
