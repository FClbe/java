package library;

public class Author
{
    private String name;
    private String firstname;
    private String lastname;
    private String email;
    private String organization;
    public Author(String firstname, String lastname, String email, String organization)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.organization = organization;
    }
    public Author()
    {
        this.name = " ";
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.organization = "";
    }

    public Author(String name) {
        this.name = name;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.organization = "";
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
