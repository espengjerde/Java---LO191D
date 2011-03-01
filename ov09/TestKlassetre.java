/**
 * Klassen Art med subklasser.
 * Liten testklient helt til slutt.
 * Merk at klassene må utvides for å løse oppgaven.
 */

class Art {
  private final String norskNavn;
  private final String latNavn;
  private final String latFamilie;

  /**
   * Konstruktøren Art: Ingen argumenter kan være null.
   * Ingen krav er satt til nye argumenter som kommer inn i subklassenes konstruktører.
   */
  public Art(String norskNavn, String latNavn, String latFamilie) {
    if (norskNavn == null || latNavn == null || latFamilie == null) {
      throw new IllegalArgumentException("Ingen av argumentene til Art-konstruktøren kan være null");
    }
    this.norskNavn = norskNavn.trim();
    this.latNavn = latNavn.trim();
    this.latFamilie = latFamilie.trim();
  }

  public String getNorskNavn() {
    return norskNavn;
  }

  public String getLatNavn() {
    return latNavn;
  }

  public String getLatFamilie() {
    return latFamilie;
  }

  public String toString() {
    return "Norsk navn: " + norskNavn + ", latinsk navn og familie: " + latNavn
            + ", " + latFamilie;
  }
}

class DyrSomIndivider extends Art {
  private final String antUnger; // eks. "3-4"
  private final boolean farlig;

  public DyrSomIndivider(String norskNavn, String latNavn,
    String latFamilie, String antUnger, boolean farlig) {
    super(norskNavn, latNavn, latFamilie);
    this.antUnger = antUnger;
    this.farlig = farlig;
  }

  public String getAntUnger() {
    return antUnger;
  }

  public boolean isFarlig() {
    return farlig;
  }

  public String toString() {
    String res = super.toString();
    res += ", Dyr som individ, antall unger: " + antUnger;
    res += (farlig) ? ", dyret er farlig." : ", dyret er ikke farlig.";
    return res;
  }
}

abstract class DyrIGrupper extends Art {
  public DyrIGrupper(String norskNavn, String latNavn, String latFamilie) {
    super(norskNavn, latNavn, latFamilie);
  }

  public String toString() {
    String res = super.toString();
    res += ", Dyr i gruppe";
    return res;
  }
}

class Fugl extends DyrIGrupper {
  private final String antEgg; // eks. "2-4"

  public Fugl(String norskNavn, String latNavn,  String latFamilie, String antEgg) {
    super(norskNavn, latNavn, latFamilie);
    this.antEgg = antEgg;
  }

  public String getAntEgg() {
    return antEgg;
  }

  public String toString() {
    String res = super.toString();
    res += ", dette er fugler, antall egg:  " + antEgg;
    return res;
  }
}

class Fisk extends DyrIGrupper {
  public Fisk(String norskNavn, String latNavn,  String latFamilie) {
    super(norskNavn, latNavn, latFamilie);
  }

  public String toString() {
    String res = super.toString();
    res += ", dette er fisk";
    return res;
  }
}

class TestKlassetre {
  public static void main(String[] args) {
    DyrSomIndivider dyr = new DyrSomIndivider("Bjørn", "XXX", "YYY", "1-2", true);
    System.out.println(dyr.getNorskNavn());
    System.out.println(dyr.getLatNavn());
    System.out.println(dyr.getLatFamilie());
    System.out.println(dyr.getAntUnger());
    System.out.println(dyr.isFarlig());
    System.out.println("toString(): " + dyr);

    Fugl fugl = new Fugl("Kolibri", "xxx", "yyy", "2-5");
    System.out.println(fugl.getNorskNavn());
    System.out.println(fugl.getLatNavn());
    System.out.println(fugl.getLatFamilie());
    System.out.println(fugl.getAntEgg());
    System.out.println("toString(): " + fugl);

    Fisk fisk = new Fisk("Hai", "ppp", "qqq");
    System.out.println(fisk.getNorskNavn());
    System.out.println(fisk.getLatNavn());
    System.out.println(fisk.getLatFamilie());
    System.out.println("toString(): " + fisk);
  }
}
