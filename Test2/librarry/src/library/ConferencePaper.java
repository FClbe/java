package library;

public class ConferencePaper extends Publication
{
    private String proceedingName;
    public ConferencePaper(String title, String authors,  String year, String proceedingName,
                           String Page)
    {
        super(title, authors, year,Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2,  String year,
                           String proceedingName,  String Page)
    {
        super(title, authors1, authors2, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2, String authors3,  String year,
                           String proceedingName,  String Page)
    {
        super(title, authors1, authors2, authors3, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2, String authors3, String authors4,
                           String year, String proceedingName, String Page) {
        super(title, authors1, authors2, authors3, authors4, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2, String authors3, String authors4,
                           String authors5, String year, String proceedingName, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2, String authors3, String authors4,
                           String authors5, String authors6, String year, String proceedingName, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, authors6, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper(String title, String authors1, String authors2, String authors3, String authors4,
                           String authors5, String authors6, String authors7, String year, String proceedingName, String Page) {
        super(title, authors1, authors2, authors3, authors4, authors5, authors6, authors7, year, Page);
        this.proceedingName = proceedingName;
    }

    public ConferencePaper()
    {
        super();
        this.proceedingName = " ";
    }

    public String getProceedingName() {
        return proceedingName;
    }
}
