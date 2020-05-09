import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;


public class Track {
    private String name;
    private Integer time;

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Track(String name, Integer time) {
        this.name = name;
        this.time = time;
    }
    public Track() { }

    public static Optional<Track> findMaxStream(List<Track> tracks) {
        return tracks.stream().max(Comparator.comparing(Track::getTime));
    }
    public static Optional<Track> findMax(List<Track> tracks) {
        tracks.sort(Comparator.comparingInt(Track::getTime));
        return tracks.size() > 0 ? Optional.of(tracks.get(tracks.size()-1)) : Optional.empty();
    }
    public static Optional<Track> findMaxFor(List<Track> tracks) {
        if(tracks.isEmpty())
            return Optional.empty();
        Track temp = tracks.get(0);
        for (int i = 0; i < tracks.size(); i++) {
            if(tracks.get(i).time > temp.time){
                temp=tracks.get(i);
            }
        }
        return Optional.of(temp);
    }

    public static Optional<Track> findMinStream(List<Track> tracks) {
        return tracks.stream().min(Comparator.comparing(Track::getTime));
    }
    public static Optional<Track> findMin(List<Track> tracks) {
        tracks.sort(Comparator.comparingInt(Track::getTime));
        return tracks.size() > 0 ? Optional.of(tracks.get(0)) : Optional.empty();

    }
    public static Optional<Track> findMinFor(List<Track> tracks) {
        if(tracks.isEmpty())
            return Optional.empty();
        Track temp = tracks.get(0);
        for (int i = 0; i < tracks.size(); i++) {
            if(tracks.get(i).time < temp.time){
                temp=tracks.get(i);
            }
        }
        return Optional.of(temp);
    }
}
