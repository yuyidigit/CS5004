package problem2;

import java.util.Objects;

/**
 * Abstract class for creators who are individual people.
 */
public abstract class Individual extends Creator {
  private String firstName;
  private String lastName;

  /**
   * Constructs an individual with first and last name.
   *
   * @param firstName first name
   * @param lastName last name
   */
  public Individual(String firstName, String lastName) {
    if (firstName == null || firstName.trim().isEmpty()) {
      throw new IllegalArgumentException("First name cannot be null or empty.");
    }
    if (lastName == null || lastName.trim().isEmpty()) {
      throw new IllegalArgumentException("Last name cannot be null or empty.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String getDisplayName() {
    return firstName + " " + lastName;
  }

  @Override
  public String toString() {
    return getDisplayName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Individual that = (Individual) o;
    return Objects.equals(firstName, that.firstName)
        && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, getClass());
  }
}
