import java.util.List;
import java.util.stream.Collectors;

public class Album {
    private List<Track> tracks;
    private String name;
    private Artist artist;

    public Album(List<Track> tracks, String name) {
        this.tracks = tracks;
        this.name = name;
    }

    public static Integer calculateAlbumTimeStream(List<Track> tracks) {
        return tracks.stream().reduce(0, (partialTimeResult, track) -> partialTimeResult + track.getTime(), Integer::sum);
    }

    public static Integer calculateAlbumTimeFor(List<Track> tracks) {
        int result = 0;
        for (Track t : tracks) {
            result += t.getTime();
        }
        return result;
    }
    public static List<Album> getAlbumWithAtMostThreeTracks(List<Album> input){
        //List<Album> albums =
        return input.stream().filter(album -> album.tracks.size() >= 3).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Album{" +
                //"tracks=" + tracks +
                ", name='" + name + '\'' +
                '}';
    }
}
