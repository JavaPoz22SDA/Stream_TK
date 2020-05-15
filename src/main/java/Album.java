import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames=new HashSet<>();
        for(Album album: albums){
            for(Track track:album.tracks){
                if(track.getTime()>400){
                    String name=track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
    public Set<String> findLongTracksStream(List<Album> albums){
            return albums
                    .stream()
                    .flatMap(album -> album.tracks.stream())
                    .filter(track -> track.getTime() > 400)
                    .map(Track::getName)
                    .collect(Collectors.toSet());
    }
}
