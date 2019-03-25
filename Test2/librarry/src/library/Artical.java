package library;

public class Artical extends Publication
{
    private String journalName;
    private String number;
    public Artical(String title, String authors,  String year, String journalName, String number,  String Page) {
        super(title, authors, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String year, String journalName, String number,
                    String Page) {
        super(title, authors1, authors2, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String authors3,  String year, String journalName,
                   String number,  String Page) {
        super(title, authors1, authors2, authors3, year,Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String authors3, String authors4,
                   String year, String journalName, String number, String Page) {
        super(title, authors1, authors2, authors3, authors4, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String authors3, String authors4,
                   String authors5, String year, String journalName, String number, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String authors3, String authors4,
                   String authors5, String authors6, String year, String journalName, String number, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, authors6, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical(String title, String authors1, String authors2, String authors3, String authors4,
                   String authors5, String authors6, String authors7, String year, String journalName, String number, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, authors6, authors7, year, Page);
        this.journalName = journalName;
        this.number = number;
    }

    public Artical()
    {
        super();
        this.journalName = " ";
        this.number = " ";
    }

    public String getJournalName() {
        return journalName;
    }

    public String getNumber()
    {
        return number;
    }

}
