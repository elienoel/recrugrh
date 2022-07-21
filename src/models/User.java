package models;

public class User {
    String numcandidat;
    String nomcandidat;
    String prenomcandidat;
    String datenaiss;
    String note;

    public User() {
    }

    public User(String numcandidat, String nomcandidat, String prenomcandidat, String datenaiss, String contacts, String note) {
        this.numcandidat = numcandidat;
        this.nomcandidat = nomcandidat;
        this.prenomcandidat = prenomcandidat;
        this.datenaiss = datenaiss;
        this.contacts = contacts;
        this.note = note;
    }

    public String getNumcandidat() {
        return this.numcandidat;
    }

    public void setNumcandidat(String numcandidat) {
        this.numcandidat = numcandidat;
    }

    public String getNomcandidat() {
        return this.nomcandidat;
    }

    public void setNomcandidat(String nomcandidat) {
        this.nomcandidat = nomcandidat;
    }

    public String getPrenomcandidat() {
        return this.prenomcandidat;
    }

    public void setPrenomcandidat(String prenomcandidat) {
        this.prenomcandidat = prenomcandidat;
    }

    public String getDatenaiss() {
        return this.datenaiss;
    }

    public void setDatenaiss(String datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getContacts() {
        return this.contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public User numcandidat(String numcandidat) {
        setNumcandidat(numcandidat);
        return this;
    }

    public User nomcandidat(String nomcandidat) {
        setNomcandidat(nomcandidat);
        return this;
    }

    public User prenomcandidat(String prenomcandidat) {
        setPrenomcandidat(prenomcandidat);
        return this;
    }

    public User datenaiss(String datenaiss) {
        setDatenaiss(datenaiss);
        return this;
    }

    public User contacts(String contacts) {
        setContacts(contacts);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " numcandidat='" + getNumcandidat() + "'" +
            ", nomcandidat='" + getNomcandidat() + "'" +
            ", prenomcandidat='" + getPrenomcandidat() + "'" +
            ", datenaiss='" + getDatenaiss() + "'" +
            ", contacts='" + getContacts() + "'" +
            "}";
    }
    String contacts;

}
