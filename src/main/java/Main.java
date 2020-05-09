import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs",378), new Track("Time Was",451));

        List<Track> trackList = new ArrayList<Track>() { };
        String s = tracks.stream().min(Comparator.comparing(Track::getTime)).toString();
        //Optional<Track> min = tracks.stream().min(Comparator.comparing(Track::getName));
        //Optional<Track> max = tracks.stream().max(Comparator.comparing(Track::getName));
       // System.out.println(s);
        System.out.println("Min stream = " +Track.findMinStream(tracks));
        System.out.println("Max strean = " + Track.findMaxStream(tracks));
        System.out.println();
        System.out.println("Min for = " + Track.findMinFor(tracks));
        System.out.println("Max for = " + Track.findMaxFor(tracks));
        System.out.println();
        System.out.println("Min  = " + Track.findMin(tracks));
        System.out.println("Max  = " + Track.findMax(tracks));

        System.out.println("Album time: " + Album.calculateAlbumTimeStream(tracks));
        System.out.println("Album time: " + Album.calculateAlbumTimeFor(tracks));
        Integer count = Stream.of(1, 2, 3, 4, 5).reduce(0, (integer, integer2) -> integer + integer2);

    }
}
