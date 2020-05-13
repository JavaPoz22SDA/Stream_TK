import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs",378), new Track("Time Was",451));
        Album album = new Album(tracks,"Default");

        List<Artist> artists = Arrays.asList(new Artist("John Coltrane", "US"),
                new Artist("John Lennon", "UK"), new Artist("The Beatles", "UK"));
        List<Track> tracks1 = Arrays.asList(new Track("Black Eyes", 184), new Track("Alibi",183),
                new Track("Shallow",216),new Track("Out of Time",172));
        Album album1 = new Album(tracks1,"A Star Is Born");

        List<Track> tracks2 = Arrays.asList(new Track("Hello", 294), new Track("Remedy",245),
                new Track("Million Years Ago",227),new Track("When We Were Young",291),
                new Track("Woter Under The Bridge",240));
        Album album2 = new Album(tracks2,"25");

        List<Track> tracks3 = Arrays.asList(new Track("Stand by Me", 180), new Track("On the Horizon",144));
        Album album3 = new Album(tracks3,"Don't Play That");

        List<Album> albums = Arrays.asList(album,album1,album2,album3);



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

        System.out.println(Artist.getNamesAndOrigins(artists).toString());
        System.out.println(Album.getAlbumWithAtMostThreeTracks(albums));
    }
}
