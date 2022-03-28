package co.com.sofka.models.contactus;

public class ContactUsModel {

    private int subjectHeading;
    private String email;
    private String message;

    public int getSubjectHeading() {
        return subjectHeading;
    }

    public void setSubjectHeading(int subjectHeading) {
        this.subjectHeading = subjectHeading;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
