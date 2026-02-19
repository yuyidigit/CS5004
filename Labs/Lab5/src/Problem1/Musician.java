package Problem1;


public class Musician extends AbstractArtist {

  private final String recordingCompany;
  private final String lastRecordAlbum;

  public Musician(Name name, int age, String[] genres, String[] awards,
      String recordingCompany, String lastRecordAlbum) {
    super(name, age, genres, awards);
    if (recordingCompany == null || lastRecordAlbum == null) {
      throw new IllegalArgumentException("recordingCompany/lastRecordAlbum cannot be null");
    }
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}

