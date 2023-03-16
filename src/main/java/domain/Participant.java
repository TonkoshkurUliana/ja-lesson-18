package domain;

public class Participant {
  private Integer id;
  private String name;
  private String email;
  private Integer level;
  private Integer primarySkill;

  public Participant(Integer id, String name, String email, Integer level, Integer primarySkill) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.level = level;
    this.primarySkill = primarySkill;
  }

  public Participant() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getPrimarySkill() {
    return primarySkill;
  }

  public void setPrimarySkill(Integer primarySkill) {
    this.primarySkill = primarySkill;
  }

  @Override
  public String toString() {
    return "Participant{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", level=" + level +
            ", primarySkill=" + primarySkill +
            '}';
  }

}
