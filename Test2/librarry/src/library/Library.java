package library;

public class Library implements Comparable<Library>
{
    private Publication publication;
    private Author[] authors = new Author[7];

    public Library(Publication pub, Author author1)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[0] = new Author();
        this.authors[0] = new Author();
        this.authors[0] = new Author();
        this.authors[0] = new Author();
        this.authors[0] = new Author();
        this.authors[0] = new Author();
    }
    public Library(Publication pub, Author author1, Author author2)
{
    this.publication = pub;
    this.authors[0] = author1;
    this.authors[1] = author2;
    this.authors[2] = new Author();
    this.authors[3] = new Author();
    this.authors[4] = new Author();
    this.authors[5] = new Author();
    this.authors[6] = new Author();
}
    public Library(Publication pub, Author author1, Author author2, Author author3)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[1] = author2;
        this.authors[2] = author3;
        this.authors[3] = new Author();
        this.authors[4] = new Author();
        this.authors[5] = new Author();
        this.authors[6] = new Author();
    }
    public Library(Publication pub, Author author1, Author author2, Author author3, Author author4)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[1] = author2;
        this.authors[2] = author3;
        this.authors[3] = author4;
        this.authors[4] = new Author();
        this.authors[5] = new Author();
        this.authors[6] = new Author();
    }
    public Library(Publication pub, Author author1, Author author2, Author author3, Author author4, Author author5)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[1] = author2;
        this.authors[2] = author3;
        this.authors[3] = author4;
        this.authors[4] = author5;
        this.authors[5] = new Author();
        this.authors[6] = new Author();
    }
    public Library(Publication pub, Author author1, Author author2, Author author3, Author author4, Author author5, Author author6)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[1] = author2;
        this.authors[2] = author3;
        this.authors[3] = author4;
        this.authors[4] = author5;
        this.authors[5] = author6;
        this.authors[6] = new Author();
    }
    public Library(Publication pub, Author author1, Author author2, Author author3, Author author4, Author author5, Author author6, Author author7)
    {
        this.publication = pub;
        this.authors[0] = author1;
        this.authors[1] = author2;
        this.authors[2] = author3;
        this.authors[3] = author4;
        this.authors[4] = author5;
        this.authors[5] = author6;
        this.authors[6] = author7;
    }



    public Publication getPublication()
    {
        return publication;
    }


    public void putPublication()
    {
        Publication p = new Publication();
        Artical a = new Artical();
        ConferencePaper c = new ConferencePaper();

        if (this.publication.getClass() == a.getClass())
        {
            System.out.println(this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
            + "," + this.publication.getJournalName() + "(" + this.publication.getNumber() + ")" +this.publication.getPage());
        }
        else if (this.publication.getClass() == c.getClass())
        {
            System.out.println(this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + ", " + this.publication.getJournalName() + " " +this.publication.getPage());
        }
        else if (this.publication.getClass() == p.getClass())
        {
            System.out.println(this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + " " +this.publication.getPage());
        }
    }
    public String getPublicationDetail()
    {
        Publication p = new Publication();
        Artical a = new Artical();
        ConferencePaper c = new ConferencePaper();

        if (this.publication.getClass() == a.getClass())
        {
            return this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + "," + this.publication.getJournalName() + "(" + this.publication.getNumber() + ")" +this.publication.getPage();
        }
        else if (this.publication.getClass() == c.getClass())
        {
            return this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + ", " + this.publication.getJournalName() + " " +this.publication.getPage();
        }
        else if (this.publication.getClass() == p.getClass())
        {
            return this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + " " +this.publication.getPage();
        }
        else
            return this.publication.getAuthors() + "(" + this.publication.getYear() +") " + this.publication.getTitle()
                    + " " +this.publication.getPage();
    }
    public boolean searchInAuthorName(String name)
    {
        if(this.publication.getAuthors().equals(name))
        {
            return true;
        }
        else
            return  false;
    }
    public boolean searchInOneAuthorName(String name)
    {
        int i = 0;
        boolean flag = false;
        while(i < 7 )
        {
            if (this.authors[i].getName().equals(name))
                flag =  true;
            else if(this.authors[i].getName().equals(" "))
                i = 7;
            i++;
        }
        return flag;
    }

    public boolean searchInTitle(String title)
    {
        if(this.publication.getTitle().equals(title))
        {
            return true;
        }
        else
            return false;
    }

    public int compareTo(Library other)
    {
        if(this.publication.getYear().compareTo(other.publication.getYear()) != 0)
        return this.publication.getYear().compareTo(other.publication.getYear());
        else
            return this.publication.getTitle().compareTo(other.publication.getTitle());
}
}
