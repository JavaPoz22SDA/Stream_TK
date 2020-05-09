import java.util.List;

public class Album {
    private List<Track> tracks;
    private String name;

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
}
