package models;

public class Offre {
    String id;
    String titre;
    String description;

    public Offre() {
    }

    public Offre(String id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Offre id(String id) {
        setId(id);
        return this;
    }

    public Offre titre(String titre) {
        setTitre(titre);
        return this;
    }

    public Offre description(String description) {
        setDescription(description);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titre='" + getTitre() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

   
}
