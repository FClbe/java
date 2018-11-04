package library;

public class Publication
{
    private String title;
    private String[] authors = {" ", " ", " ", " ", " ", " ", " "};
    private String year;
    private String Page;


    public Publication(String title, String authors, String year, String Page)
    {
        this.title = title;
        this.authors[0] = authors;
        this.year = year;
        this.Page = Page;

    }
    public Publication(String title, String authors1, String authors2,  String year,  String Page)
    {
        this.title = title;
        this.authors[0] = authors1;
        this.authors[1] = authors2;
        this.year = year;
        this.Page = Page;
    }
    public Publication(String title, String authors1, String authors2, String authors3,  String year,  String Page)
    {
    this.title = title;
    this.authors[0] = authors1;
    this.authors[1] = authors2;
    this.authors[2] = authors3;
    this.year = year;
    this.Page = Page;

    }
    public Publication(String title, String authors1, String authors2, String authors3, String authors4,  String year,  String Page)
    {
        this.title = title;
        this.authors[0] = authors1;
        this.authors[1] = authors2;
        this.authors[2] = authors3;
        this.authors[3] = authors4;
        this.year = year;
        this.Page = Page;

    }
    public Publication(String title, String authors1, String authors2, String authors3, String authors4,  String authors5,
                       String year,  String Page)
    {
        this.title = title;
        this.authors[0] = authors1;
        this.authors[1] = authors2;
        this.authors[2] = authors3;
        this.authors[3] = authors4;
        this.authors[4] = authors5;
        this.year = year;
        this.Page = Page;

    }
    public Publication(String title, String authors1, String authors2, String authors3, String authors4,  String authors5,
                       String authors6, String year,  String Page)
    {
        this.title = title;
        this.authors[0] = authors1;
        this.authors[1] = authors2;
        this.authors[2] = authors3;
        this.authors[3] = authors4;
        this.authors[4] = authors5;
        this.authors[5] = authors6;
        this.year = year;
        this.Page = Page;

    }
    public Publication(String title, String authors1, String authors2, String authors3, String authors4,  String authors5,
                       String authors6, String authors7, String year,  String Page)
    {
        this.title = title;
        this.authors[0] = authors1;
        this.authors[1] = authors2;
        this.authors[2] = authors3;
        this.authors[3] = authors4;
        this.authors[4] = authors5;
        this.authors[5] = authors6;
        this.authors[6] = authors7;
        this.year = year;
        this.Page = Page;

    }
    public Publication()
    {
        this.title = " ";
        this.year = " ";
        this.Page = " ";

    }
    public String getAuthors()
    {
        if(authors[1] == " ")
            return authors[0];
        else if (authors[2] == " ")
            return authors[0] + " & " +authors[1];
        else if (authors[3] == " ")
            return authors[0] + " & " +authors[1] + " & " +authors[2];
        else if (authors[4] == " ")
            return authors[0] + " & " +authors[1] + " & " +authors[2] + " & " +authors[3];
        else if (authors[5] == " ")
            return authors[0] + " & " +authors[1] + " & " +authors[2] + " & " +authors[3] + " & " +authors[4];
        else if (authors[6] == " ")
            return authors[0] + " & " +authors[1] + " & " +authors[2] + " & " +authors[3] + " & " +authors[4] + " & " +authors[5];
        else
            return authors[0] + " & " +authors[1] + " & " +authors[2] + " & " +authors[3] + " & " +authors[4] + " & " +authors[5] + " & " +authors[6];
    }

    public String getTitle() {
        return title;
    }

    public  String getYear() {
        return year;
    }

    public String getPage()
    {
        return Page;
    }

    public String getJournalName()
    {
        return "";
    }

    public String getNumber(){return "";}
    public String getProceedingName() {
        return " ";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAuthor(String author) {this.authors[0] = author;}
}

